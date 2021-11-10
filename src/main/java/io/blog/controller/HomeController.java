package io.blog.controller;

import io.blog.service.TestService;
import io.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HomeController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public List<UserVO> test(Model model) {
        testService.insert("testName");
        //testService.delete();
        return testService.viewAll();
    }

    @RequestMapping("/delete")
    public List<UserVO> delete() {
        testService.delete(1);
        return testService.viewAll();
    }


    @RequestMapping("/get")
    public List<UserVO> get(Model model) {
        return testService.viewAll();
    }
}
