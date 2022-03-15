package manager;

import model.Epic;
import model.SubTask;
import model.Task;

import java.util.HashMap;

public class Manager {
   // public static int id = 0;
    private final HashMap<Integer, Task> taskMap = new HashMap<>();
    private final HashMap<Integer, Epic> epicMap = new HashMap<>();
    private final HashMap<Integer, SubTask> subTaskMap = new HashMap<>();


    public static int getId() {
        return id;
    }

    public static int decrId() {
        return ++id;
    }

    public String recordNewTask(Task task){
        taskMap.put(task.getTaskId(), task);
        return "Task is added";
    }

    public String recordNewEpic(Epic epic){
        epicMap.put(epic.getEpicId(), epic);
        return "Epic is added";
    }

    public String recordNewSubTask(SubTask subTask) {
        subTaskMap.put(subTask.getSubTaskId(), subTask);
        return "SubTask is added";
    }

    //Получение списка всех задач.
    public HashMap<Integer, String> printAllRecords(){
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

    public String delAllRecords() {
        taskMap.clear();
        epicMap.clear();
        subTaskMap.clear();
        System.out.println("Map is cleared");
        return "Map is cleared";
    }

    public Task printRecordsToKey(int key) {
        if (taskMap.containsKey(key)) {
            return taskMap.get(key);
        } else if (epicMap.containsKey(key)){
            return epicMap.get(key);
        } else
        return subTaskMap.get(key);
    }

    // Обновление. Новая версия объекта с верным идентификатором передаются в виде параметра.
    public String reNewRecords(int key, Task object) {
        taskMap.put(key, object);
        return "Update Task is added";
    }

    public String reNewRecords(int key, Epic object) {
        epicMap.put(key, object);
        return "Update Epic is added";
    }

    public String reNewRecordsSubTask(int key, SubTask object) {
        String status = "NEW";
        subTaskMap.put(key, object);
        int newStatus = 0;
        int progressStatus = 0;
        int doneStatus = 0;
        for (SubTask tmp : subTaskMap.values()) {
            if (tmp.getIdEpic() == object.getIdEpic()) {
                String str = tmp.getTaskStatus();
                switch (str) {
                    case "NEW":
                        newStatus++;
                        break;
                    case "IN_PROGRESS":
                        progressStatus++;
                        break;
                    case "DONE":
                        doneStatus++;
                        break;
                }
            }
        }
        if (newStatus == 0 & progressStatus == 0) {
            status = "DONE";
        } else if (progressStatus > 0 | (newStatus > 0 & doneStatus > 0)) {
            status = "IN_PROGRESS";
        }
        System.out.println();
        Epic tmpEpic = epicMap.get(object.getIdEpic());
        Epic reNewEpic = new Epic(tmpEpic.getEpicName(), tmpEpic.getDescriptionEpic());
        reNewEpic.setEpicStatus(status);
        epicMap.put(object.getIdEpic(), reNewEpic);
        return "Update subTask is added";

    }

    //Удаление по идентификатору.
    public String delRecordsToKey(int key) {
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

    //Получение списка всех подзадач определённого эпика.
    public HashMap<Integer, String> printSubTaskToEpic (int key) {
        HashMap<Integer, String> printSubTask = new HashMap<>();
        int id = 0;
        for (SubTask tmp : subTaskMap.values()) {
            if (tmp.getIdEpic() == key) {
                printSubTask.put(id++, tmp.toString());
            }
        }
        return printSubTask;
    }
}
