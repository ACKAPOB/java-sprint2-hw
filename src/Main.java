public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();

        Task task1 = new Task("task1", "descTask1", "NEW");
        manager.recordNewTask(task1);

        Task task2 = new Task("task2", "descTask2", "NEW");
        manager.recordNewTask(task2);

        Epic epic1 = new Epic("Epic1", "descEpic1");
        manager.recordNewEpic(epic1);

        SubTask subTask1 = new SubTask(102, "SubTask1", "descSubTask1", "NEW");
        manager.recordNewSubTask(subTask1);

        SubTask subTask2 = new SubTask(102, "subtask2", "descSubTask2", "IN_PROGRESS");
        manager.recordNewSubTask(subTask2);

        Epic epic2 = new Epic("Epic2", "descEpic2");
        manager.recordNewEpic(epic2);

        SubTask subTask3 = new SubTask(106, "subtask3", "descSubTask3", "NEW");
        manager.recordNewSubTask(subTask2);

        System.out.println("______________________________________________");
        System.out.println(manager.printAllRecords());

        SubTask reNewSubTask = new SubTask(102, "SubTask2", "descSubTAsk2", "DONE");
        manager.reNewRecordsSubTask(105, reNewSubTask);
        System.out.println(manager.printAllRecords());

        System.out.println("______________________________________________");
        System.out.println(manager.printRecordsToKey(106));

        manager.delRecordsToKey(106);
        System.out.println("______________________________________________");
        System.out.println(manager.printRecordsToKey(106));

        manager.delRecordsToKey(101);
        System.out.println("______________________________________________");
        System.out.println(manager.printRecordsToKey(101));
    }
}


