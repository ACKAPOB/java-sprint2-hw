package model;

import manager.Manager;

public class Task {
    private int taskId;
    private final String taskName;
    private final String descriptionTask;
    private String taskStatus;

    public Task(String taskName, String descriptionTask, String taskStatus) {
        this.taskId = Manager.decrId();
        this.taskName = taskName;
        this.descriptionTask = descriptionTask;
        this.taskStatus = taskStatus;
    }

    public Task(String taskName, String descriptionTask) {
        this.taskName = taskName;
        this.descriptionTask = descriptionTask;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return taskId == task.taskId;
    }

    @Override
    public int hashCode() {
        return taskId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                '}';
    }
}
