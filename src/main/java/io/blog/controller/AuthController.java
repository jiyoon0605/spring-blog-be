package io.blog.controller;


import io.blog.helper.ResultMap;
import io.blog.service.AuthService;
import io.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/user")
    public Map<String, Object> createAccount(@RequestBody UserVO user) {
        boolean result = authService.duplicationCheck(user.getEMAIL(), user.getNICKNAME());
        if (result) {
            Map<String, Object> map = authService.createAccount(user);
            return ResultMap.getSuccessMap("Account creation successful", map);
        } else {
            return ResultMap.getFailureMap("email or nickname is duplicated");
        }
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody UserVO user) {
        Map<String, Object> result = authService.login(user.getEMAIL(), user.getPASSWORD());
        if (Boolean.parseBoolean(result.get("success").toString())) {
            Map<String, Object> token = new HashMap<>();
            token.put("token", result.get("token").toString());
            return ResultMap.getSuccessMap("Login Success", token);
        }else{
            return ResultMap.getFailureMap(result.get("message").toString());
        }
    }

    @GetMapping("/view")
    public List<Map<String, Object>> viewAllUser() {
        return authService.viewAllUsers();
    }

}
