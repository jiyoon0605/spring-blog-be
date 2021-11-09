package io.blog.service;

import io.blog.vo.TestVO;

import java.util.List;

public interface TestService {
    public List<TestVO> viewAll();
    public void insert();
}
