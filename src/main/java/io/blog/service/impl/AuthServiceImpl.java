package io.blog.service.impl;

import io.blog.mapper.AuthMapper;
import io.blog.service.AuthService;
import io.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthMapper authMapper;
    String key = "1234567890123456";

    @Autowired
    public void setAuthMapper(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    @Override
    public Map<String, Object> createAccount(UserVO user) {
        UserVO saveUser = new UserVO();
        saveUser.setUSERNAME(user.getUSERNAME());
        saveUser.setNICKNAME(user.getNICKNAME());
        saveUser.setEmail(user.getEmail());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String securePw = encoder.encode(user.getPASSWORD());
        saveUser.setPASSWORD(securePw);


        authMapper.createAccount(saveUser);
        return null;
    }

    @Override
    public boolean duplicationCheck(String email, String nickname) {
        Object object = authMapper.emailCheck(email);
        Object object2 = authMapper.nicknameCheck(nickname);

        return object == null && object2 == null;
    }

    @Override
    public  List<Map<String,Object>> viewAllUsers() {
        return authMapper.viewAllUsers();
    }

}
