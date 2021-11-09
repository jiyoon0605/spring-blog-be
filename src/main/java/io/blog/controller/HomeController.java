package io.blog.controller;

import io.blog.service.TestService;
import io.blog.vo.TestVO;
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
    public List<TestVO> test(Model model) {
        // model.addAllAttributes("viewAll",testService.viewAll());
        testService.insert();
        return testService.viewAll();
    }
}
