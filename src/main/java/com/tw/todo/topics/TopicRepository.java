package com.tw.todo.topics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface TopicRepository extends CrudRepository<Topic, String> {
public interface TopicRepository extends JpaRepository<Topic, String> {

}
