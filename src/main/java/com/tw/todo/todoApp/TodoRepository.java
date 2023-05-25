package com.tw.todo.todoApp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, String> {

}
