package io.blog.controller;

import io.blog.helper.ResultMap;
import io.blog.service.PostService;
import io.blog.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import static io.blog.helper.ResultMap.getSuccessMap;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService service;

    @GetMapping("/list")
    public Map<String, Object> viewPostList() {
        return getSuccessMap("", service.viewAllPost());
    }

    @GetMapping("/{id}")
    public Map<String, Object> viewDetailPost(@PathVariable("id") int id) {
        try {
            Map<String, Object> result = service.viewDetailPost(id);
            return getSuccessMap("Success to load", result);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Post is not exist");
        }
    }

    @PostMapping("/")
    public Map<String, Object> createNewPost(@RequestBody PostVo postVo, @RequestHeader HttpHeaders header) throws UnsupportedEncodingException {
        try {
            Map<String, Object> result = service.createNewPost(postVo, header.get("authorization").toString());
            System.out.println(result);
            return getSuccessMap("Post is created", result);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedEncodingException();
        }
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Map<String, Object> responseStatus(Exception e, HttpServletResponse response) {
        response.setStatus(404);
        return ResultMap.getBadRequestMap(e.getMessage());
    }

    @ExceptionHandler(UnsupportedEncodingException.class)
    public Map<String, Object> badToken(HttpServletResponse response) {
        response.setStatus(401);
        return ResultMap.getUnauthorizedMap("Invalid token");
    }


}
