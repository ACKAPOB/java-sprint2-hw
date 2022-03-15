package model;

import manager.Manager;

public class SubTask extends Task{

   // private final int idEpic;
    private int subTaskId;

    public SubTask(int idEpic, String taskName, String descriptionTask, String taskStatus) {
        super(taskName, descriptionTask, taskStatus);
        this.idEpic = idEpic;
        this.subTaskId = Manager.decrId();
    }

    public int getIdEpic() {
        return idEpic;
    }

    public int getSubTaskId() {
        return subTaskId;
    }

    public void setSubTaskId(int subTaskId) {
        this.subTaskId = subTaskId;
    }
}
