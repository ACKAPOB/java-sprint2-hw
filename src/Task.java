public class Task {
    String taskName;
    String descriptionTask;
    String taskStatus;

    public Task(String taskName, String descriptionTask, String taskStatus) {
        this.taskName = taskName;
        this.descriptionTask = descriptionTask;
        this.taskStatus = taskStatus;
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
