package manager;

import model.Task;

import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager {

    private final ArrayList <Integer>list = new ArrayList();

    @Override
    public void add(Task task) {
        if (list.size() > 10) {
            list.remove(0);
        }
        list.add(task.getTaskId());
    }

    @Override
    public ArrayList<Integer> getHistory() {
        return list;
    }
}
