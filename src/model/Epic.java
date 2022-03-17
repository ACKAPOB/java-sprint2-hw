package model;

public class Epic extends Task{

    // конструктор применяется при изменении состояниия
    public Epic(int taskId, String taskName, String descriptionTask, TaskStatus taskStatus) {
        super(taskId, taskName, descriptionTask, taskStatus);
    }
    // конструктор для создания нового эпика
    public Epic(String taskName, String descriptionTask, TaskStatus taskStatus) {
        super(taskName, descriptionTask, taskStatus);
    }

    public Epic(String taskName, String descriptionTask) {
        super(taskName, descriptionTask);
    }


}
