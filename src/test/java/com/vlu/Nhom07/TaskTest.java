package com.vlu.Nhom07;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TaskTest.TaskTestWatcher.class)
class TaskTest {

  private static FileWriter writer;

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

  @Test
  public void test_cons_01() {
    Task task = new Task();

    String expectedTitle = "Untitled";
    String expectedDesc = "Description is not provided";
    String expectedContent = "";

    String actualTitle = task.getTitle();
    String actualDesc = task.getDescription();
    String actualContent = task.getContent();

    assertEquals(expectedTitle, actualTitle);
    assertEquals(expectedDesc, actualDesc);
    assertEquals(expectedContent, actualContent);
  }

  @Test
  public void test_cons_02() throws Exception {
    Task task =
        new Task(
            "Web Design",
            "Let's design some webpage",
            "We should do this at the end of the semester");

    String expectedTitle = "Web Design";
    String expectedDesc = "Let's design some webpage";
    String expectedContent = "We should do this at the end of the semester";

    String actualTitle = task.getTitle();
    String actualDesc = task.getDescription();
    String actualContent = task.getContent();

    assertEquals(expectedTitle, actualTitle);
    assertEquals(expectedDesc, actualDesc);
    assertEquals(expectedContent, actualContent);
  }

  @Test
  public void test_cons_03() {
    assertThrows(
        Task.InvalidTextSizeException.class,
        () -> {
          Task _ =
              new Task(
                  "Web",
                  "Let's design some webpage",
                  "We should do this at the end of the semester");
        });
  }

  @Test
  public void test_cons_04() {
    assertThrows(
        Task.InvalidTextSizeException.class,
        () -> {
          Task _ =
              new Task(
                  "Web development",
                  "This description is to long and should throw an exception",
                  "Web development is fun");
        });
  }

  @Test
  public void test_getTitle_01() throws Exception {
    Task task =
        new Task("Gaming and entertainment", "Play game for fun", "Games are fun and entertaining");

    String expectedResult = "Gaming and entertainment";
    String actualResult = task.getTitle();

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void test_setTitle_01() throws Exception {
    Task task =
        new Task("Mobile phone", "Mobile phone hardware", "Analyze performance of mobile phone");

    task.setTitle("Mobile phone research");

    String expectedResult = "Mobile phone research";
    String actualResult = task.getTitle();

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void test_setTitle_02() throws Exception {
    Task task =
        new Task("PC building", "Building your dream PC", "Market research for PC hardware");

    assertThrows(
        Task.InvalidTextSizeException.class,
        () -> {
          task.setTitle("PC");
        });
  }

  @Test
  public void test_getDesc_01() throws Exception {
    Task task =
        new Task(
            "Discrete Math",
            "Boolean algebra and Graph theory",
            "Bitwise operation and graph traversal");

    String expectedResult = "Boolean algebra and Graph theory";
    String actualResult = task.getDescription();

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void test_setDesc_01() throws Exception {
    Task task =
        new Task(
            "Programming", "Build program and solve problem", "Learn data structure and algorithm");

    task.setDescription("Solving business problem");

    String expectedResult = "Solving business problem";
    String actualResult = task.getDescription();

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void test_setDesc_02() throws Exception {
    Task task =
        new Task("Software security", "Find vulnerability", "Find exploit and patching them");

    assertThrows(
        Task.InvalidTextSizeException.class,
        () -> {
          task.setDescription(
              "There are too much vulnerability to patch so we should start a new project");
        });
  }

  @Test
  public void test_getContent_01() throws Exception {
    Task task = new Task("Biology", "Learning about biodiversity", "Biology is diverse");

    String expectedResult = "Biology is diverse";
    String actualResult = task.getContent();

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void test_setContent_01() throws Exception {
    Task task = new Task("Chemistry", "Combining chemical", "Create new chemical");

    task.setContent("Don't mess up");

    String expectedResult = "Don't mess up";
    String actualResult = task.getContent();

    assertEquals(expectedResult, actualResult);
  }
}
