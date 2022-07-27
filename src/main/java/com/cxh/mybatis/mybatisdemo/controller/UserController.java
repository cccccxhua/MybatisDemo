package com.cxh.mybatis.mybatisdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.cxh.mybatis.mybatisdemo.entity.User;
import com.cxh.mybatis.mybatisdemo.enums.UserScore;
import com.cxh.mybatis.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CXH
 * @description
 * @create 2022-07-25 14:05
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/add")
    public String addUser(User user){
        userService.insertUser(user);
        return "redirect:/index";
    }

    @PostMapping(value = "/data")
    public String getUsersList(@RequestParam("start") String username, @RequestParam("end") UserScore score, Model model){
        username = "%" + username + "%" ;
        List<User> usersList = userService.findUsersList(username, score);
        model.addAttribute("usersList", usersList);
        return "/data";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        userService.updateStatus(id, 1);
        return "redirect:/index";
    }

    @PostMapping("/userList")
    public String piLiang( MultipartFile excelFile) throws IOException {
        String str="";
        Map<String,String> map = new HashMap<>();
        if (excelFile.isEmpty()){
            str="文件夹为空，重新上传";
            return str;
        }else {
            String fileName = excelFile.getOriginalFilename();
            InputStream is = excelFile.getInputStream();
            return "redirect:/index";
        }
    }


    private String getJsonString(int code, String msg){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg", msg);
        return json.toJSONString();
    }



}
