/*
 * @Author: your name
 * @Date: 2020-04-18 12:56:48
 * @LastEditTime: 2020-04-21 03:53:42
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /undefined/Users/karro/IdeaProjects/todoList-master-clean/src/main/java/com/axe/todo/controller/UserService.java
 */
package com.axe.todo.controller;
//控制器

//push test
import org.apache.catalina.filters.ExpiresFilter;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserService {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginCheck(HttpServletRequest request) {

        String user = request.getParameter("user");
        String password = request.getParameter("password");

        Map<String, String> data = new HashMap<>();
        if("123".equals(user) && "123".equals(password)){
            data.put("result", "登陆成功");
        }
        else{
            data.put("result", "登陆失败");
        }

        return new ModelAndView("index");
    }


}
