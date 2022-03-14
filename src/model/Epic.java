package model;

import manager.Manager;

import java.util.HashMap;

public class Epic extends Task{

    private final int epicId;
    private final String epicName;
    private final String descriptionEpic;
    private String epicStatus;

    public Epic(String taskName, String descriptionTask) {
        super(taskName, descriptionTask);
        this.epicName = taskName;
        this.descriptionEpic = descriptionTask;
        this.epicStatus = "NEW";
        this.epicId = Manager.decrId();
    }

    public int getEpicId() {
        return epicId;
    }

    public String getEpicName() {
        return epicName;
    }

    public String getDescriptionEpic() {
        return descriptionEpic;
    }

    public String getEpicStatus() {
        return epicStatus;
    }

    public void setEpicStatus(String epicStatus) {
        this.epicStatus = epicStatus;
    }

    @Override
    public String toString() {
        return "model.Epic{" +
                "epicName='" + epicName + '\'' +
                ", descriptionEpic='" + descriptionEpic + '\'' +
                ", epicStatus='" + epicStatus + '\'' +
                '}';
    }
}

