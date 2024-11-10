package com.vlu.Nhom07;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.stream.Stream;

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
  void test_addTask_01() {}

  @Test
  void updateTask() {}

  @Test
  void removeTaskById() {}

  @Test
  void getTaskById() {}

  @Test
  void getCreatedDate() {}

  @Test
  void getUpdatedDate() {}

  @Test
  void getTasks() {}
}
