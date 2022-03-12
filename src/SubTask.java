public class SubTask extends Task{

    int idEpic;

    public SubTask(int idEpic, String taskName, String descriptionTask, String taskStatus) {
        super(taskName, descriptionTask, taskStatus);
        this.idEpic = idEpic;
    }

    @Override
    public String toString() {
        return "subTask{" +
                "taskName='" + taskName + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", idEpic=" + idEpic +
                '}';
    }
}
