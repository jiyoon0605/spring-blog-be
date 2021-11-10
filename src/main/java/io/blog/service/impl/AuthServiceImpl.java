package io.blog.service.impl;

import io.blog.common.util.JwtUtil;
import io.blog.mapper.AuthMapper;
import io.blog.service.AuthService;
import io.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthMapper authMapper;

    @Value("${jwt.secret.key}")
    public String jwtKey;

    @Autowired
    public void setAuthMapper(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    @Override
    public Map<String, Object> createAccount(UserVO user) {
        UserVO saveUser = new UserVO();
        saveUser.setUSERNAME(user.getUSERNAME());
        saveUser.setNICKNAME(user.getNICKNAME());
        saveUser.setEMAIL(user.getEMAIL());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String securePw = encoder.encode(user.getPASSWORD());
        saveUser.setPASSWORD(securePw);


        authMapper.createAccount(saveUser);
        Map<String, Object> result = authMapper.findUser(saveUser.getEMAIL()).get(0);
        return result;
    }

    @Override
    public boolean duplicationCheck(String email, String nickname) {
        Object object = authMapper.emailCheck(email);
        Object object2 = authMapper.nicknameCheck(nickname);

        return object == null && object2 == null;
    }

    @Override
    public List<Map<String, Object>> viewAllUsers() {
        return authMapper.viewAllUsers();
    }

    @Override
    public Map<String, Object> login(String email, String password) {
        List<Map<String, Object>> data = authMapper.login(email);
        Map<String, Object> result = new HashMap<>();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String securePw = encoder.encode(password);

        if (data.size() <= 0) {
            result.put("success", false);
            result.put("message", "Account does not exist");
        } else if (data.get(0).get("PASSWORD") != securePw) {
            result.put("success", false);
            result.put("message", "Passwords do not match");
        } else {
            result.put("success", true);
            System.out.println(jwtKey);
            JwtUtil jwtUtil = new JwtUtil();
            Map<String, Object> userData = data.get(0);
            String token = jwtUtil.createToken(
                    Long.valueOf(String.valueOf(userData.get("ID"))),
                    userData.get("EMAIL").toString(),
                    jwtKey);
            result.put("token", token);

        }

        return result;

    }

}
