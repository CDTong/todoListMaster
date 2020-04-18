package com.axe.todo.controller;
//控制器

import com.axe.todo.entity.Todo;
import com.axe.todo.entity.TodoEnum;
import com.axe.todo.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoService {

    @Autowired
    //Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    public void setRepository(TodoRepository repository) {
        this.repository = repository;
    }

    private TodoRepository repository;

    //RequestMapping是一个用来处理请求地址映射的注解
    @RequestMapping("/")
    public ModelAndView index() {
        // 创建 ModelAndView 对象，并设置视图名称
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("list", repository.findAll());
        return mv;
    }

    @RequestMapping("/list")
    public Object listAll() {
        // 添加模型数据
        return repository.findAll();
    }

    @RequestMapping("/add")

    //保存status的转换的两个状态？
    public String add(String content, String author) {
        repository.save(new Todo(TodoEnum.StatusTodo.getStatus(), content, author));
        return "redirect:/";
    }




    @RequestMapping("/modify/{id}/{status}")
    public String modify(@PathVariable Long id, @PathVariable Integer status) {
        repository.updateById(id, status);
        return "redirect:/";
    }
}
