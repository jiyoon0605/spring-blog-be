package io.blog.controller;

import io.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static io.blog.helper.ResultMap.getSuccessMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService service;

    @GetMapping("/list")
    public Map<String, Object> viewPostList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        return getSuccessMap("",service.viewAllPost());
    }

    @GetMapping("/{id}")
    public Map<String, Object> viewDetailPost(@PathVariable("id")int id) {
        return getSuccessMap("",service.viewDetailPost(id));
    }
}
