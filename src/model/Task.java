public class Task {
    private static int taskId = 100;
    String taskName;
    String descriptionTask;
    String taskStatus;

    public Task(String taskName, String descriptionTask, String taskStatus) {
        this.taskName = taskName;
        this.descriptionTask = descriptionTask;
        this.taskStatus = taskStatus;
    }

    public static int getTaskId() {
        return taskId;
    }

    static int decrTaskId () {
        return taskId++;
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
