package com.axe.todo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import  java.util.*;
import java.text.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer status;
    private String content;
    private Date createTime;
    private Date updateTime;
    private String author;

    public Todo(Integer status, String content, String author) {
        this.id = null;
        this.status = status;
        this.content = content;
        this.createTime = new Date();
        this.updateTime = new Date();
        this.author = author;
    }
}
