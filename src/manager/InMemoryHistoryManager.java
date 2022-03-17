package manager;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private List <Integer> list = new ArrayList();

    @Override
    public void add(Task task) {
        if (list.size() > 10) {
            list.remove(0);
        }
        list.add(task.getTaskId());
    }

    @Override
    public List<Integer> getHistory() {
        return list;
    }



}
