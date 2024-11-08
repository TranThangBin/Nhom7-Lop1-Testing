package com.vlu.Nhom07;

import org.junit.*;

import static org.junit.Assert.*;

public class TodoTest {

  private static Todo todo;

  @Before
  public void setup() throws Exception {
    todo = new Todo("Web design", "Thiết kế giao diện web xem phim", "Giao diện web");
  }

  @Test
  public void testTodoConstructor01() throws Todo.InvalidTextSizeException {
    Todo _ = new Todo("Web design", "Thiết kế giao diện web xem phim", "Giao diện web");
  }

  @Test(expected = Todo.InvalidTextSizeException.class)
  public void testTodoConstructor02() throws Exception {
    Todo _ = new Todo("Web", "Thiết kế giao diện web xem phim", "Giao diện web");
  }

  @Test
  public void testTodoGetTitle() {
    String expResult = "Web design";
    String result = todo.getTitle();

    assertEquals(expResult, result);
  }

  @Test
  public void testTodoSetTitle() throws Exception {
    todo.setTitle("Web");
  }

  @Test
  public void testTodoGetDescription() {
    String expResult = "Thiết kế giao diện web xem phim";
    String result = todo.getDescription();

    assertEquals(expResult, result);
  }

  @Test
  public void testTodoSetDescription() throws Exception {
    todo.setDescription("This description is way too long and should cause an exception");
  }

  @Test
  public void testTodoGetContent() {
    String expResult = "Giao diện web";
    String result = todo.getContent();

    assertEquals(expResult, result);
  }

  @Test
  public void testTodoSetContent() throws Exception {
    todo.setDescription("New Content");
  }
}
