package io.blog.controller;


import io.blog.helper.ResultMap;
import io.blog.service.AuthService;
import io.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/user")
    public Map<String, Object> signUp(@RequestBody UserVO user) {
        boolean result = authService.duplicationCheck(user.getEmail(), user.getNICKNAME());
        if (result) {
            authService.createAccount(user);
            return ResultMap.getSuccessMap("Account creation successful");
        } else {
            return ResultMap.getFailureMap("DUPLICATE");
        }

    }

    @GetMapping("/view")
    public List<Map<String, Object>> viewAllUser() {
        return authService.viewAllUsers();
    }

}
