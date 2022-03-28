package manager;

import model.Epic;
import model.SubTask;
import model.Task;

import java.util.HashMap;

public interface TaskManager {
    void addNewTask(Task task);

    void addNewTask(Epic epic);

    void addNewTask(SubTask subTask);

    String reNewTask(int key, Task object);

    String reNewTask(int key, Epic object);

    String reNewTask(int key, SubTask object);

    HashMap<Integer, String> getAllTasks();
    void getHistoryTask();

    Object getTaskToKey(int key);

    HashMap<Integer, String> getSubTaskToEpic (int key);

    String delTaskToKey (int key);

    String delAllTask();

}
