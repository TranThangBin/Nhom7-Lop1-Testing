package com.vlu.Nhom07;

import java.util.HashMap;

public class TodoManager {

  public TodoManager() {
    this.todos = new HashMap<>();
  }

  public static class DuplicatedIdException extends Exception {
    public DuplicatedIdException(String id) {
      super("A todo item with id " + id + " has already existed");
    }
  }

  public static class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String id) {
      super("Cannot found any item with id " + id);
    }
  }

  private final HashMap<String, Todo> todos;

  public void addTodo(String id, Todo todo) throws DuplicatedIdException {
    if (this.todos.containsKey(id)) {
      throw new DuplicatedIdException(id);
    }
    this.todos.put(id, todo);
  }

  public void updateTodo(String id, Todo todo) throws ItemNotFoundException {
    if (!this.todos.containsKey(id)) {
      throw new ItemNotFoundException(id);
    }
    this.todos.put(id, todo);
  }

  public void removeTodoById(String id) throws ItemNotFoundException {
    if (!this.todos.containsKey(id)) {
      throw new ItemNotFoundException(id);
    }
    this.todos.remove(id);
  }

  public Boolean exist(String id) {
    return this.todos.containsKey(id);
  }

  public Todo getTodoById(String id) {
    return this.todos.get(id);
  }

  public HashMap<String, Todo> getAllTodo() {
    return this.todos;
  }
}
