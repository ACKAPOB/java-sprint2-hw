package model;

public class SubTask extends Task{

    private int epicId;

    public SubTask(int taskId, int epicId, String taskName, String descriptionTask, TaskStatus taskStatus) {
        super(taskId, taskName, descriptionTask, taskStatus);
        this.epicId = epicId;
    }

    public SubTask(int epicId, String taskName, String descriptionTask, TaskStatus taskStatus) {
        super(taskName, descriptionTask, taskStatus);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }
}
