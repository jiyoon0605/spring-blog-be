package io.blog.mapper;

import io.blog.vo.TestVO;

import java.util.List;

public interface TestMapper {
    public List<TestVO> viewAll();
    public void insert();
}
