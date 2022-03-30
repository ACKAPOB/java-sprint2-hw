import manager.HistoryManager;
import manager.InMemoryHistoryManager;
import manager.Managers;
import manager.TaskManager;
import model.Epic;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.List;

import static model.TaskStatus.*;

public class Main {

    public static void main(String[] args) {

        TaskManager taskManager = Managers.getDefaultTaskManager();
        Task task1 = new Task("task1", "desc1", NEW);
        taskManager.addNewTask(task1);
        Task task2 = new Task("task2", "desc2", NEW);
        taskManager.addNewTask(task2);
        Epic epic1 = new Epic("epic1", "descEpic1");
        taskManager.addNewTask(epic1);
        Epic epic2 = new Epic("epic2", "descEpic2");
        taskManager.addNewTask(epic2);
        SubTask subTask1 = new SubTask( 2,"subTask1_EPIC1", "DescSubTask1", NEW);
        taskManager.addNewTask(subTask1);
        SubTask subTask2 = new SubTask( 3,"subTask2_EPIC2", "DescSubTask2", NEW);
        taskManager.addNewTask(subTask2);
        SubTask subTask3 = new SubTask( 3,"subTask3_EPIC2", "DescSubTask3", NEW);
        taskManager.addNewTask(subTask3);

        System.out.println(taskManager.getAllTasks());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");

        SubTask reNewSubTask2 = new SubTask( 3,"NEWsubTask1", "NEWDescSubTask2", DONE);
        taskManager.reNewTask(7, reNewSubTask2);

        System.out.println(taskManager.getAllTasks());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        Task task11 = new Task("task11", "desc11", DONE);
        taskManager.reNewTask(0, task11);
        //System.out.println(taskManager.getAllTasks());
        //System.out.println("Таска по ключу " + taskManager.getTaskToKey(0));
        //System.out.println("Субтаски эпика " + taskManager.getSubTaskToEpic(2));
        //System.out.println("Удаление таски по ключу " + taskManager.delTaskToKey(6));

        taskManager.getTaskToKey(0);
        taskManager.getTaskToKey(1);
        taskManager.getTaskToKey(2);
        taskManager.getTaskToKey(3);
        taskManager.getTaskToKey(4);
        taskManager.getTaskToKey(5);
        taskManager.getTaskToKey(6);
        taskManager.getTaskToKey(7);
        taskManager.getTaskToKey(8);
        taskManager.getTaskToKey(9);
        taskManager.getTaskToKey(10);

        taskManager.delTaskToKey(2);
        taskManager.delTaskToKey(3);


        //taskManager.getHistoryTask();

        //System.out.println("последние просмотренные пользователем задачи  "  + taskManager.getHistoryTask());
        System.out.println(taskManager.getAllTasks());

        //System.out.println("Удаление всех тасков " + taskManager.delAllTask());
    }
}

