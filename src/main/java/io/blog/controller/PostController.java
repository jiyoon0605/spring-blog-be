package io.blog.controller;

import io.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService service;

    @GetMapping("/list")
    public List<Map<String, Object>> viewPostList() {
        return service.viewAllPost();
    }

    @GetMapping("/detail")
    public Map<String, Object> viewDetailPost() {
        return service.viewDetailPost(0);
    }
}
