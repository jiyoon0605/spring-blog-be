package io.blog.service;

import io.blog.exception.UnauthorizedException;
import io.blog.vo.PostVo;

import java.util.List;
import java.util.Map;

public interface PostService {
    public List<Map<String, Object>> viewAllPost();

    public Map<String, Object> viewDetailPost(int id) throws IndexOutOfBoundsException;

    public Map<String, Object> createNewPost(PostVo postVo, String token) throws UnauthorizedException;

    public void increaseView(int id);
}
