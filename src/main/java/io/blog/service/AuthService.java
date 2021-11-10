package io.blog.service;

import io.blog.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface AuthService {
    public Map<String, Object> createAccount(UserVO user);

    public boolean duplicationCheck(String email, String nickname);

    public List<Map<String,Object>>  viewAllUsers();
}
