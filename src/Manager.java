import java.util.HashMap;

public class Manager {

    public static int taskId = 100;

    HashMap<Integer, Task> taskMap = new HashMap<>();
    HashMap<Integer, Epic> epicMap = new HashMap<>();
    HashMap<Integer, SubTask> subTaskMap = new HashMap<>();

    String recordNewTask(Task task){
        taskMap.put(taskId++, task);
        return "Task is added";
    }

    String recordNewEpic(Epic epic){
        epicMap.put(taskId++, epic);
        return "Epic is added";
    }

    String recordNewSubTask(SubTask subTask) {
        subTaskMap.put(taskId++, subTask);
        return "SubTask is added";
    }

    //Получение списка всех задач.
    HashMap<Integer, String> printAllRecords(){
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

    String delAllRecords() {
        taskMap.clear();
        epicMap.clear();
        subTaskMap.clear();
        System.out.println("Map is cleared");
        return "Map is cleared";
    }

    Object printRecordsToKey(int key) {
        if (taskMap.containsKey(key)) {
            return taskMap.get(key);
        } else if (epicMap.containsKey(key)){
            return epicMap.get(key);
        } else
        return subTaskMap.get(key);
    }

    // Обновление. Новая версия объекта с верным идентификатором передаются в виде параметра.
    String reNewRecords(int key, Task object) {
        taskMap.put(key, object);
        return "Update Task is added";
    }

    String reNewRecords(int key, Epic object) {
        epicMap.put(key, object);
        return "Update Epic is added";
    }

    String reNewRecordsSubTask(int key, SubTask object) {
        String status = "NEW";
        subTaskMap.put(key, object);
        int newStatus = 0;
        int progressStatus = 0;
        int doneStatus = 0;
        for (SubTask tmp : subTaskMap.values()) {
            if (tmp.idEpic == object.idEpic) {
                String str = tmp.taskStatus;
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
        Epic tmpEpic = epicMap.get(object.idEpic);
        Epic reNewEpic = new Epic (tmpEpic.epicName, tmpEpic.descriptionEpic);
        reNewEpic.epicStatus = status;
        epicMap.put(object.idEpic, reNewEpic);
        return "Update subTask is added";

    }

    //Удаление по идентификатору.
    String delRecordsToKey (int key) {
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
    HashMap<Integer, String> printSubTaskToEpic (int key) {
        HashMap<Integer, String> printSubTask = new HashMap<>();
        int id = 0;
        for (SubTask tmp : subTaskMap.values()) {
            if (tmp.idEpic == key) {
                printSubTask.put(id++, tmp.toString());
            }
        }
        return printSubTask;
    }
}
