import manager.Manager;
import model.Epic;
import model.SubTask;
import model.Task;

public class Main {
        //  Я сейчас в ветке мэйн
    public static void main(String[] args) {

        Manager manager = new Manager();

        //  Task task1 = new Task("task1", "descTask1", "NEW");
        manager.recordNewTask(task1);

        Task task2 = new Task("task2", "descTask2", "NEW");
        manager.recordNewTask(task2);

        Epic epic1 = new Epic("Epic1", "descEpic1");
        manager.recordNewEpic(epic1);
        System.out.println(epic1.getEpicId());

        SubTask subTask1 = new SubTask(3, "SubTask1", "descSubTask1", "NEW");
        manager.recordNewSubTask(subTask1);

        SubTask subTask2 = new SubTask(3, "subtask2", "descSubTask2", "NEW");
        manager.recordNewSubTask(subTask2);

        Epic epic2 = new Epic("Epic2", "descEpic2");
        manager.recordNewEpic(epic2);

        SubTask subTask3 = new SubTask(8, "subtask3", "descSubTask3", "NEW");
        manager.recordNewSubTask(subTask2);

        System.out.println("______________________________________________");
        System.out.println(manager.printAllRecords());

        SubTask reNewSubTask = new SubTask(3, "SubTask2", "descSubTAsk2", "DONE");
        manager.reNewRecordsSubTask(5, reNewSubTask);
        System.out.println(manager.printAllRecords());

        System.out.println("______________________________________________");
        System.out.println(manager.printRecordsToKey(1));

        manager.delRecordsToKey(3);
        System.out.println("______________________________________________");
        System.out.println(manager.printRecordsToKey(3));

        manager.delRecordsToKey(5);
        System.out.println("______________________________________________");
        System.out.println(manager.printRecordsToKey(5));
    }
}


