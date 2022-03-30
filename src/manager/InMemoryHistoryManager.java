package manager;

import model.Task;

import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    public HistoryLinkedList historyLinkedList = new HistoryLinkedList();

    @Override
    public void add(Task task) {
        historyLinkedList.linkLast(task);
    }

    @Override
    public void remove(int id) {
        HistoryLinkedList.Node<Task> tmp1 = historyLinkedList.map.get(id);
        Task tmp2 = tmp1.value;
        historyLinkedList.remove(tmp2);
    }

    @Override
    public List<Task> getHistory() {
        return historyLinkedList.getTasks();
    }
}