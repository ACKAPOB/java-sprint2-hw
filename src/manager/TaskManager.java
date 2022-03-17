package manager;

import model.Epic;
import model.SubTask;
import model.Task;
import model.TaskStatus;

import java.util.HashMap;

import static model.TaskStatus.*;

public interface TaskManager {
    public void addNewTask(Task task);

    public void addNewTask(Epic epic);

    public void addNewTask(SubTask subTask);

    public String reNewTask(int key, Task object);

    public String reNewTask(int key, Epic object);

    public String reNewTask(int key, SubTask object);

    public HashMap<Integer, String> getAllTasks();

    public HashMap<Integer, Task> getHistoryTask();

    public Object getTaskToKey(int key);

    public HashMap<Integer, String> getSubTaskToEpic (int key);

    public String delTaskToKey (int key);

    public String delAllTask();

}
