package io.blog.service.impl;


import io.blog.mapper.TestMapper;
import io.blog.service.TestService;
import io.blog.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {


    private TestMapper mapper;

    @Autowired
    public void setMapper(TestMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<TestVO> viewAll() {
        return mapper.viewAll();
    }

    @Override
    public void insert() {
        System.out.println("insert");
        mapper.insert();
    }

}
