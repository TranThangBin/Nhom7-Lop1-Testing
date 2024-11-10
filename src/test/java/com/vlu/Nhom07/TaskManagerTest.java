package com.vlu.Nhom07;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

  private static FileWriter writer;
  private static TaskManager taskManager;

  public static class TaskTestWatcher implements TestWatcher {
    @Override
    public void testSuccessful(ExtensionContext context) {
      try {
        writer.append(context.getDisplayName()).append(',').append("Pass\n");
      } catch (IOException e) {
        System.err.println(e.getMessage());
      }
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
      try {
        writer.append(context.getDisplayName()).append(',').append("Fail\n");
      } catch (IOException e) {
        System.err.println(e.getMessage());
      }
    }
  }

  @BeforeAll
  public static void setUp() throws Exception {
    String path = "JUnitTestResult.csv";
    writer = new FileWriter(path, Charset.defaultCharset(), true);
  }

  @AfterAll
  public static void tearDown() throws Exception {
    writer.close();
  }

  @BeforeEach
  public void initObject() {
    taskManager = new TaskManager();
  }

  @Test
  void test_addTask_01() throws Exception {
    Task expectedTask =
        new Task("My task for today", "This is what I need to do for today", "Just doing my thing");

    taskManager.addTask("task001", expectedTask);

    Task actualTask = taskManager.getTaskById("task001");

    assertEquals(expectedTask.getTitle(), actualTask.getTitle());
    assertEquals(expectedTask.getDescription(), actualTask.getDescription());
    assertEquals(expectedTask.getContent(), actualTask.getContent());
  }

  @Test
  void test_addTask_02() throws Exception {
    taskManager.addTask(
        "task001", new Task("Work task", "I have to do this for work", "Working hard"));

    assertThrows(
        TaskManager.DuplicatedIdException.class,
        () -> {
          taskManager.addTask(
              "task001",
              new Task("My Job's task", "This is the work for the job", "This is my job"));
        });
  }

  @Test
  void test_updateTask_01() throws Exception {
    taskManager.addTask("task101", new Task("Studying", "I need to study", "Study anytime"));

    Task expectedTask =
        new Task("Migrate test", "This test need to be updated", "Outdated test suite");

    taskManager.updateTask("task101", expectedTask);

    Task actualTask = taskManager.getTaskById("task101");

    assertEquals(expectedTask.getTitle(), actualTask.getTitle());
    assertEquals(expectedTask.getDescription(), actualTask.getDescription());
    assertEquals(expectedTask.getContent(), actualTask.getContent());
  }

  @Test
  void test_updateTask_02() throws Exception {
    taskManager.addTask(
        "task102", new Task("Interview", "Interview for a job", "I need to prepare"));

    assertThrows(
        TaskManager.DuplicatedIdException.class,
        () -> {
          taskManager.updateTask("task101", new Task());
        });
  }

  @Test
  void test_rmTaskById_01() throws Exception {
    taskManager.addTask("task001", new Task("Say hello", "Say hello to everyone", "Hello is nice"));
    taskManager.addTask(
        "task002",
        new Task("Goodbye", "Any good thing have to come to an end", "Goodbye my friend"));

    taskManager.removeTaskById("task001");

    Task expectedTask = null;
    Task actualTask = taskManager.getTaskById("task001");

    assertEquals(expectedTask, actualTask);
  }

  @Test
  void test_rmTaskById_02() {
    assertThrows(
        TaskManager.ItemNotFoundException.class,
        () -> {
          taskManager.removeTaskById("task001");
        });
  }

  @Test
  void test_queryTask_01() {
    Task expectedTask = null;
    Task actualTask = taskManager.getTaskById("work200");

    assertEquals(expectedTask, actualTask);
  }

  @Test
  void test_queryTask_02() throws Exception {
    Task expectedTask =
        new Task("Learning", "Learning from the best", "Prefer composition over inheritance");

    taskManager.addTask("learn101", expectedTask);

    Task actualTask = taskManager.getTaskById("learn101");

    assertEquals(expectedTask.getTitle(), actualTask.getTitle());
    assertEquals(expectedTask.getDescription(), actualTask.getDescription());
    assertEquals(expectedTask.getContent(), actualTask.getContent());
  }
}
