package com.vlu.Nhom07;

import java.util.HashMap;

public class TodoManager {
  public TodoManager() {
    this.todos = new HashMap<>();
  }

  private final HashMap<String, Todo> todos;

  public void addTodo(String id, Todo todo) throws DuplicatedIdException {
    if (this.todos.containsKey(id)) {
      throw new DuplicatedIdException(id);
    }
    this.todos.put(id, todo);
  }

  public void updateTodo(String id, Todo todo) {
    this.todos.put(id, todo);
  }

  public Todo getTodoById(String id) {
    return this.todos.get(id);
  }

  public HashMap<String, Todo> getAllTodo() {
    return this.todos;
  }

  public static class DuplicatedIdException extends Exception {
    public DuplicatedIdException(String id) {
      super("A todo item with id " + id + " has already existed");
    }
  }
}
