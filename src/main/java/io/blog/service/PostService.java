package io.blog.service;

import java.util.List;
import java.util.Map;

public interface PostService {
    public List<Map<String,Object>> viewAllPost();
    public Map<String,Object> viewDetailPost(int id);

}
