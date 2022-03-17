package manager;

import model.Epic;
import model.SubTask;
import model.Task;
import model.TaskStatus;

import java.util.HashMap;

import static model.TaskStatus.*;

public class InMemoryTaskManager implements TaskManager{
    private final HashMap<Integer, Task> taskMap = new HashMap<>();
    private final HashMap<Integer, Epic> epicMap = new HashMap<>();
    private final HashMap<Integer, SubTask> subTaskMap = new HashMap<>();

    private final HistoryManager historyManager;

    public InMemoryTaskManager(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public void addNewTask(Task task){
        taskMap.put(task.getTaskId(), task);
    }

    @Override
    public void addNewTask(Epic epic){
        epicMap.put(epic.getTaskId(), epic);
    }

    @Override
    public void addNewTask(SubTask subTask) {
        subTaskMap.put(subTask.getTaskId(), subTask);
    }

    // Обновление. Новая версия объекта с верным идентификатором передаются в виде параметра.
    @Override
    public String reNewTask(int key, Task object) {
        Task tmpTask;
        tmpTask = taskMap.get(key);
        object.setTaskId(tmpTask.getTaskId());
        taskMap.put(key, object);
        return "Update Task is added";
    }

    @Override
    public String reNewTask(int key, Epic object) {
        Epic tmpEpic;
        tmpEpic = epicMap.get(key);
        object.setTaskId(key);
        epicMap.put(key, object);
        return "Update Epic is added";
    }

    @Override
    public String reNewTask(int key, SubTask object) {
        TaskStatus status = NEW;
        subTaskMap.put(key, object);
        int newStatus = 0;
        int progressStatus = 0;
        int doneStatus = 0;
        for (SubTask tmp : subTaskMap.values()) {
            if (tmp.getEpicId() == object.getEpicId()) {
                TaskStatus taskStatus = tmp.getTaskStatus();
                switch (taskStatus) {
                    case NEW:
                        newStatus++;
                        break;
                    case IN_PROGRESS:
                        progressStatus++;
                        break;
                    case DONE:
                        doneStatus++;
                        break;
                }
            }
        }
        if (newStatus == 0 & progressStatus == 0) {
            status = DONE; // если нет статусов NEW и IN_PROGRESS  значит все статусы DONE, передаем DONE в Эпик
        } else if (progressStatus > 0 // если хотя бы один статус IN_PROGRESS или есть статусы DONE и NEW
                | (newStatus > 0 & doneStatus > 0)) {
            status = IN_PROGRESS;
        }
        Epic tmpEpic = epicMap.get(object.getEpicId());
        Epic reNewEpic = new Epic(tmpEpic.getTaskId(), tmpEpic.getTaskName(), tmpEpic.getDescriptionTask(), status);
        epicMap.put(object.getEpicId(), reNewEpic);
        return "Update subTask is added";

    }

    //Получение списка всех задач.
    @Override
    public HashMap<Integer, String> getAllTasks(){
        HashMap <Integer, String> printAllRec = new HashMap<>();
        int id = 0;
        for(Task task : taskMap.values()) {
            printAllRec.put(id++, task.toString());
        }
        for(Epic epic : epicMap.values()) {
            printAllRec.put(id++, epic.toString());
        }
        for (SubTask subTask : subTaskMap.values()) {
            printAllRec.put(id++, subTask.toString());
        } return printAllRec;
    }

    @Override
    public HashMap<Integer, Task> getHistoryTask(){
        HashMap<Integer, Task> getHistoryMap = new HashMap<>();
        for (Integer key : historyManager.getHistory()) {
                if (taskMap.containsKey(key)) {
                    getHistoryMap.put(key, taskMap.get(key));
                } else if (epicMap.containsKey(key)){
                    getHistoryMap.put(key, epicMap.get(key));
                } else if (subTaskMap.containsKey(key))
                    getHistoryMap.put(key, subTaskMap.get(key));
        }
        return getHistoryMap;

    }

    @Override
    public Object getTaskToKey(int key) {
        if (taskMap.containsKey(key)) {
            historyManager.add(taskMap.get(key));
            return taskMap.get(key);
        } else if (epicMap.containsKey(key)){
            historyManager.add(epicMap.get(key));
            return epicMap.get(key);
        } else if (subTaskMap.containsKey(key)) {
            historyManager.add(subTaskMap.get(key));
            return subTaskMap.get(key);
        } return null;
    }

    @Override
    public HashMap<Integer, String> getSubTaskToEpic (int key) {
        HashMap<Integer, String> printSubTask = new HashMap<>();
        int id = 0;
        for (SubTask tmp : subTaskMap.values()) {
            if (tmp.getEpicId() == key) {
                printSubTask.put(id++, tmp.toString());
            }
        }
        return printSubTask;
    }

    @Override
    public String delTaskToKey (int key) {
        if (taskMap.containsKey(key)) {
            taskMap.remove(key);
            return "Task deleted";
        } else if (epicMap.containsKey(key)){
            epicMap.remove(key);
            return "Epic deleted";
        } else
            subTaskMap.remove(key);
        return "subTask deleted";
    }

    @Override
    public String delAllTask() {
        taskMap.clear();
        epicMap.clear();
        subTaskMap.clear();
        System.out.println("Map is cleared");
        return "Maps is cleared";
    }
}
