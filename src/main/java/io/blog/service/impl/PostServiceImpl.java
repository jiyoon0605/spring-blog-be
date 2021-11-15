package io.blog.service.impl;

import io.blog.common.util.JwtUtil;
import io.blog.exception.UnauthorizedException;
import io.blog.mapper.PostMapper;
import io.blog.service.PostService;
import io.blog.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostMapper postMapper;

    @Value("${jwt.secret.key}")
    public String jwtKey;

    @Override
    public List<Map<String, Object>> viewAllPost() {
        List<Map<String, Object>> result = postMapper.viewAllPost();
        return result;
    }

    @Override
    public Map<String, Object> viewDetailPost(int id) throws IndexOutOfBoundsException {
        Map<String, Object> result = postMapper.viewDetailPost(id).get(0);
        return result;
    }

    @Override
    public Map<String, Object> createNewPost(PostVo postVo, String token) throws UnauthorizedException {
        JwtUtil jwtUtil = new JwtUtil();
        try {
            int id = Integer.parseInt(jwtUtil.verifyJWT(jwtKey, token).get("id").toString());
            postVo.setUSER_ID(id);
            postMapper.createNewPost(postVo);
            Map<String, Object> createdPost = postMapper.getCreatedPost().get(0);
            return createdPost;
        } catch (UnsupportedEncodingException e) {
            throw new UnauthorizedException();
        }
    }

    @Override
    public void increaseView(int id) {
        System.out.println(id);
        postMapper.increaseView(id);
    }


}
