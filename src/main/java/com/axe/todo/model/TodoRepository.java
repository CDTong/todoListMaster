package com.axe.todo.model;
//模型

import com.axe.todo.entity.Todo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface TodoRepository extends CrudRepository<Todo, Long> {

    @Override
    List<Todo> findAll();

    @Override
    @SuppressWarnings("unchecked")
    Todo save(Todo todo);

    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query("update Todo as t set t.status = ?2 where t.id=?1")
    void updateById(Long id, int status);
}


