package com.cxh.mybatis.mybatisdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.cxh.mybatis.mybatisdemo.entity.User;
import com.cxh.mybatis.mybatisdemo.enums.UserScore;
import com.cxh.mybatis.mybatisdemo.service.UserService;
import com.cxh.mybatis.mybatisdemo.utils.ImportExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.tools.DiagnosticListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String getUsersList(Model model){
        List<User> usersA = userService.findUsersList(UserScore.A);
        List<User> usersB = userService.findUsersList(UserScore.B);
        List<User> usersC = userService.findUsersList(UserScore.C);
        model.addAttribute("countA", usersA==null?0:usersA.size());
        model.addAttribute("countB", usersB==null?0:usersB.size());
        model.addAttribute("countC", usersC==null?0:usersC.size());
        return "/data";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        userService.updateStatus(id, 1);
        return "redirect:/index";
    }

    @PostMapping("/userList")
    public String piLiang( MultipartFile excelFile) throws Exception {
        String str="";
        Map<String,String> map = new HashMap<>();
        if (excelFile.isEmpty()){
            str="文件夹为空，重新上传";
            return str;
        }else {
            String fileName = excelFile.getOriginalFilename();
            InputStream is = excelFile.getInputStream();
            userService.addUsers(fileName,is);
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
