package io.blog.mapper;

import io.blog.vo.PostVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PostMapper {
    public List<Map<String, Object>> viewAllPost();

    public List<Map<String, Object>> viewDetailPost(@Param("id") int id);

    public void createNewPost(PostVo post);

    public List<Map<String,Object>> getCreatedPost();

}
