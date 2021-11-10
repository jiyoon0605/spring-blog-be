package io.blog.mapper;

import io.blog.vo.TestVO;
import io.blog.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper {
    public List<UserVO> viewAll();
    public void insert(@Param("name") String name);
    public void delete(@Param("id") int id);
}
