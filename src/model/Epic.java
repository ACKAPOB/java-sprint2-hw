package model;

import manager.Manager;

import java.util.HashMap;

public class Epic{

    private final int epicId;
    private final String epicName;
    private final String descriptionEpic;
    private String epicStatus;

    public Epic(String epicName, String descriptionEpic) {
        this.epicId = Manager.decrId();
        this.epicName = epicName;
        this.descriptionEpic = descriptionEpic;
        this.epicStatus = "NEW";
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

