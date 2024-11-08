package com.vlu.Nhom07;

import org.junit.BeforeClass;
import org.junit.Test;

public class TodoManagerTest {

  private static TodoManager todoManager;

  @BeforeClass
  public static void setup() {
    todoManager = new TodoManager();
  }

  @Test
  public void testTodoManagerAddTodo01() throws Exception {
    String id = "Task0001";
    Todo todo = new Todo("Web design", "Thiết kế giao diện web", "Giao diện web");

    todoManager.addTodo(id, todo);
  }

  @Test
  public void testTodoManagerAddTodo02() throws Exception {
    String id = "Task0001";
    Todo todo = new Todo("Game unity", "Làm game platformer 2d", "game");

    todoManager.addTodo(id, todo);
  }

  @Test
  public void testTodoManagerUpdateTodo01() throws Exception {
    String id = "Task0001";
    Todo todo = new Todo("Game godot", "Làm game platformer 2d trên godot", "làm game bằng go");

    todoManager.updateTodo(id, todo);
  }

  @Test
  public void testTodoManagerUpdateTodo02() throws Exception {
    String id = "Task0002";
    Todo todo = new Todo("Mobile app", "Làm app bán hàng", "app trên điện thoại");

    todoManager.updateTodo(id, todo);
  }

  @Test
  public void testTodoManagerRemoveTodo01() throws Exception {
    todoManager.removeTodoById("Task0001");
  }

  @Test(expected = TodoManager.ItemNotFoundException.class)
  public void testTodoManagerRemoveTodo02() throws Exception {
    todoManager.removeTodoById("Task0001");
  }
}
