package io.blog.controller;

import io.blog.exception.UnauthorizedException;
import io.blog.helper.ResultMap;
import io.blog.service.PostService;
import io.blog.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static io.blog.helper.ResultMap.getSuccessMap;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService service;

    @GetMapping("/list")
    public Map<String, Object> viewAllPost() {
        return getSuccessMap("Success to load", service.viewAllPost());
    }

    @GetMapping("/{id}")
    public Map<String, Object> viewDetailPost(@PathVariable("id") int id) {
        try {
            Map<String, Object> result = service.viewDetailPost(id);
            return getSuccessMap("Success to load - postId : " + id, result);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Post is not exist");
        }
    }

    @PostMapping("/")
    public Map<String, Object> createNewPost(@RequestBody PostVo postVo, @RequestHeader HttpHeaders header) throws UnauthorizedException {
        try {
            Map<String, Object> result = service.createNewPost(postVo, header.get("authorization").toString());
            System.out.println(result);
            return getSuccessMap("Post is created", result);
        } catch (UnauthorizedException e) {
            throw new UnauthorizedException();
        }
    }

    @PutMapping("/view/{id}")
    public Map<String, Object> increaseView(@PathVariable("id") int id) {
        service.increaseView(id);
        System.out.println("success");
        return getSuccessMap("success", null);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Map<String, Object> responseStatus(Exception e, HttpServletResponse response) {
        response.setStatus(404);
        return ResultMap.getBadRequestMap(e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public Map<String, Object> badToken(HttpServletResponse response) {
        response.setStatus(401);
        return ResultMap.getUnauthorizedMap("Invalid token");
    }


}
