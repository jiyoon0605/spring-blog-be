package io.blog.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("test")
    @ResponseBody
    public String getHello() {
        System.out.println("test");
        return "hello world";
    }
}
