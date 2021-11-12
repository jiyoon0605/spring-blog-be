package io.blog.controller;


import io.blog.helper.ResultMap;
import io.blog.service.AuthService;
import io.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
        if (!result) {
            throw new AuthorizationServiceException("email or nickname is duplicated");
        }

        Map<String, Object> map = authService.createAccount(user);
        return ResultMap.getSuccessMap("Account creation successful", map);

    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody UserVO user) {
        Map<String, Object> result = authService.login(user.getEMAIL(), user.getPASSWORD());
        if (!Boolean.parseBoolean(result.get("success").toString())) {
            throw new AuthorizationServiceException(result.get("message").toString());
        }
        Map<String, Object> token = new HashMap<>();
        token.put("token", result.get("token").toString());
        return ResultMap.getSuccessMap("Login Success", token);
    }

    @GetMapping("/view")
    public List<Map<String, Object>> viewAllUser() {
        return authService.viewAllUsers();
    }


    @ExceptionHandler(AuthorizationServiceException.class)
    public Map<String, Object> authorizationError(Exception e, HttpServletResponse response) {
        response.setStatus(401);
        return ResultMap.getRequestFailureMap(e.getMessage());
    }
}
