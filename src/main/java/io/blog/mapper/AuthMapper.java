package io.blog.mapper;


import io.blog.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface AuthMapper {
    public void createAccount(UserVO user);

    public Object emailCheck(@Param("email") String email);

    public Object nicknameCheck(@Param("nickname") String nickname);

    public List<Map<String, Object>> viewAllUsers();

    public List<Map<String, Object>> findUser(@Param("email") String email);

    public List<Map<String, Object>> login(@Param("email") String email);

}
