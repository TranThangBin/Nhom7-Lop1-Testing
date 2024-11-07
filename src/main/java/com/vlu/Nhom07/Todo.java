package com.vlu.Nhom07;

public class Todo {

  public Todo() {
    this.title = "Untitled";
    this.description = "Description is not provided";
    this.content = "";
  }

  public Todo(String title, String description, String content) throws InvalidTextSizeException {
    title = title.trim();
    description = description.trim();

    if (title.length() < MIN_TITLE_LENGTH || title.length() > MAX_TITLE_LENGTH) {
      throw new InvalidTextSizeException(MIN_TITLE_LENGTH, MAX_TITLE_LENGTH);
    }
    if (description.length() > MAX_DESC_LENGTH) {
      throw new InvalidTextSizeException(0, MAX_DESC_LENGTH);
    }

    this.title = title;
    this.description = description;
    this.content = content;
  }

  private final int MIN_TITLE_LENGTH = 5;
  private final int MAX_TITLE_LENGTH = 20;
  private final int MAX_DESC_LENGTH = 50;

  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) throws InvalidTextSizeException {
    title = title.trim();
    if (title.length() < MIN_TITLE_LENGTH || title.length() > MAX_TITLE_LENGTH) {
      throw new InvalidTextSizeException(MIN_TITLE_LENGTH, MAX_TITLE_LENGTH);
    }
    this.title = title;
  }

  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) throws InvalidTextSizeException {
    description = description.trim();
    if (description.length() > MAX_DESC_LENGTH) {
      throw new InvalidTextSizeException(0, MAX_DESC_LENGTH);
    }
    this.description = description;
  }

  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content.trim();
  }

  public static class InvalidTextSizeException extends Exception {
    public InvalidTextSizeException(int range, int range2) {
      super(
          String.format(
              "Expected text size to be in range [%d, %d] characters",
              Math.min(range, range2), Math.max(range, range2)));
    }
  }
}
