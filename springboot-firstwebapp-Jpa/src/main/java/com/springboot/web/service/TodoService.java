package com.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.model.Todo;
import com.springboot.web.repo.TodoRepository;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;
    @Autowired
    TodoRepository todoRepository;

    static {
        todos.add(new Todo(1, "meghna", "a1@gmail.com", "high", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "meghna","a2@gmail.com", "low", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "meghna", "a3@gmail.com", "mid","Learn Hibernate", new Date(),
                true));
    }

    public List<Todo> retrieveTodos(String user) {
       
        return (List<Todo>)todoRepository.findAll();
    }
    
    public Todo retrieveTodo(int id) {
       
        return  todoRepository.findOne(id);
    	
    }

    @Transactional
    public void updateTodo(Todo todo){
    	todoRepository.save(todo);
    }
    @Transactional
    public void addTodo(String name,String email,String severity, String desc, Date targetDate,
            boolean isDone) {
        todoRepository.save(new Todo(++todoCount, name, email, severity, desc, targetDate, isDone));
    }
    @Transactional
    public void deleteTodo(int id) {
    todoRepository.delete(id);
    	
        }
    
}