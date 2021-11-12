package io.blog.controller;

import io.blog.helper.ResultMap;
import io.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static io.blog.helper.ResultMap.getSuccessMap;

@CrossOrigin("*")
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

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Map<String, Object> responseStatus(Exception e, HttpServletResponse response) {
        response.setStatus(404);
        return ResultMap.getBadRequestMap(e.getMessage());
    }
}
