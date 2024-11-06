package com.vlu.Nhom07;

public class Todo {
  public Todo() {
    this.title = "";
    this.description = "";
    this.content = "";
  }

  public Todo(String title, String description, String content) {
    this.title = title;
    this.description = description;
    this.content = content;
  }

  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
