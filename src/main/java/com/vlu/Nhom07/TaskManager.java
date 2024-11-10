package com.vlu.Nhom07;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {

  public TaskManager() {
    this.tasks = new HashMap<>();
  }

  private static class TaskItem {
    private Task task;
    private final Calendar createdAt;
    private Calendar updatedAt;

    public TaskItem(Task task, Calendar createdAt, Calendar updatedAt) {
      this.task = task;
      this.createdAt = createdAt;
      this.updatedAt = updatedAt;
    }
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

  public static class InvalidDateException extends Exception {
    public InvalidDateException(Calendar date) {
      super("The date " + date.toString() + " is invalid");
    }
  }

  private final HashMap<String, TaskItem> tasks;

  public void addTask(String id, Task task) throws DuplicatedIdException {
    if (this.tasks.containsKey(id)) {
      throw new DuplicatedIdException(id);
    }
    Calendar createdDate = Calendar.getInstance();
    this.tasks.put(id, new TaskItem(task, createdDate, createdDate));
  }

  public void updateTask(String id, Task task) throws ItemNotFoundException {
    if (!this.tasks.containsKey(id)) {
      throw new ItemNotFoundException(id);
    }
    TaskItem target = this.tasks.get(id);
    target.task = task;
    target.updatedAt = Calendar.getInstance();
    this.tasks.put(id, target);
  }

  public void removeTaskById(String id) throws ItemNotFoundException {
    if (!this.tasks.containsKey(id)) {
      throw new ItemNotFoundException(id);
    }
    this.tasks.remove(id);
  }

  public Task getTaskById(String id) {
    TaskItem item = this.tasks.get(id);
    if (item != null) {
      return item.task;
    }
    return null;
  }

  public Calendar getCreatedDate(String id) {
    return this.tasks.get(id).createdAt;
  }

  public Calendar getUpdatedDate(String id) {
    return this.tasks.get(id).updatedAt;
  }

  public HashMap<String, Task> getTasks() {
    HashMap<String, Task> res = new HashMap<>(this.tasks.size());
    this.tasks.forEach((id, item) -> res.put(id, item.task));
    return res;
  }
}
