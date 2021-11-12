package io.blog.service.impl;

import io.blog.mapper.PostMapper;
import io.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostMapper postMapper;

    @Override
    public List<Map<String, Object>> viewAllPost() {
        List<Map<String, Object>> result = postMapper.viewAllPost();
        result.forEach(map -> map.put("CREATED_AT", map.get("CREATED_AT").toString()));
        return result;
    }

    @Override
    public Map<String, Object> viewDetailPost(int id) throws IndexOutOfBoundsException {
        Map<String, Object> result = postMapper.viewDetailPost(id).get(0);
        result.put("CREATED_AT", result.get("CREATED_AT").toString());
        return result;
    }


}
