package com.cxh.mybatis.mybatisdemo.controller;

import com.cxh.mybatis.mybatisdemo.entity.User;
import com.cxh.mybatis.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/index")
    public String getIndexPage(Model model){
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "/index";
    }
}
