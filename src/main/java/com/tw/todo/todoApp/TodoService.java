package com.tw.todo.todoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }


    public Todo getTodo(String id) {
//        List<Todo> todos = todoRepository.findAll();       //findOne
//        for (int i = 0; i < todos.size(); i++) {
//            Todo todo = todos.get(i);
//            if (todo.getId().equals(id)) {
//                return todo;
//            }
//        }
        Todo todo = todoRepository.findById(id).get();
        return todo;
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void addTodos(List<Todo> todoList) {
        todoRepository.saveAll(todoList);
    }

    public void updateTodo(String id, Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }

    public Page<Todo> getTodoPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"title");
        return todoRepository.findAll(pageable);
    }

    public Page<Todo> getTodoPaginationAndSort(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if(sortProperty!=null){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sortProperty);
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"title");
        }
        return todoRepository.findAll(pageable);
    }
}
