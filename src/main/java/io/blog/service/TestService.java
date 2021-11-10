package io.blog.service;

import io.blog.vo.TestVO;
import io.blog.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestService {
    public List<UserVO> viewAll();
    public void insert(String name);
    public void delete(int id);
}
