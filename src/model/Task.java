package model;

import java.util.Objects;

import static model.TaskStatus.NEW;

public class Task {

    public static int idMap = 0;
    public static int id = 0;
    private int taskId;
    private final String taskName;
    private final String descriptionTask;
    private TaskStatus taskStatus;

    // общий конструктор


    public Task(int taskId, String taskName, String descriptionTask, TaskStatus taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.descriptionTask = descriptionTask;
        this.taskStatus = taskStatus;
    }

    public Task(String taskName, String descriptionTask, TaskStatus taskStatus) {
        this.taskName = taskName;
        this.descriptionTask = descriptionTask;
        this.taskStatus = taskStatus;
        this.taskId = incremTaskId();
    }

    // конструктор для создания эпика
    public Task(String taskName, String descriptionTask) {
        this.taskName = taskName;
        this.descriptionTask = descriptionTask;
        this.taskStatus = NEW;
        this.taskId = incremTaskId();

    }

    public static int incremTaskId () {
        return id++;
    }

    public static int incremIdMap() {
        return idMap++;
    }

    public static int getIdMap() {
        return idMap;
    }

    public static void setIdMap(int idMap) {
        Task.idMap = idMap;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId && Objects.equals(taskName, task.taskName) && Objects.equals(descriptionTask,
                task.descriptionTask) && taskStatus == task.taskStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskName, descriptionTask, taskStatus);
    }
}
