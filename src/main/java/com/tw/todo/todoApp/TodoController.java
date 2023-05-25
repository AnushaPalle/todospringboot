package com.tw.todo.todoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @RequestMapping("/todos/{id}")
    public Todo getTodo(@PathVariable String id) {
        return todoService.getTodo(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/todos")
    public void addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/todos/{id}")
    public void updateTodo(@RequestBody Todo todo, @PathVariable String id) {
        todoService.updateTodo(id, todo);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/todos/{id}")
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/todosBulk")
    public void addTodo(@RequestBody List<Todo> todoList) {
        todoService.addTodos(todoList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pagingTodos/{pageNumber}/{pageSize}")
    public Page<Todo> todoPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        return todoService.getTodoPagination(pageNumber,pageSize);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/pagingAndSortTodos/{pageNumber}/{pageSize}/{sortProperty}")
    public Page<Todo> todoPaginationAndSort(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, @PathVariable String sortProperty){
        return todoService.getTodoPaginationAndSort(pageNumber,pageSize, sortProperty);
    }

}
