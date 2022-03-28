package manager;

import model.Task;

import java.util.*;

public class HistoryLinkedList{

    public HistoryLinkedList historyLinkedList = new HistoryLinkedList();

    private final Map <Integer, Node<Task>> map = new HashMap<>();

    private final List<Task> list = new ArrayList<>();

    transient Node<Task> first;
    transient Node<Task> last;
    transient int size = 0;

    static class Node <Task> {
        public Task value;
        public Node<Task> next;
        public Node<Task> prev;

    }

    public void linkLast (Task task) { // будет добавлять задачу в конец этого списка

        final Node<Task> newNode = new Node<>();

        if (first == null || last == null) {
            first = newNode;
            return;
        }
        last.next = newNode;
        last = newNode;
        map.put(task.getTaskId(), newNode);
    }

    public void remove (Task task) {
        Node<Task> taskNode = map.get(task.getTaskId());
        Node<Task> prev = taskNode.prev;
        Node<Task> next = taskNode.next;
        prev.next = next;
        next.prev = prev;
    }

    public List<Task> getAll() {
        Node<Task> node = first;
        List<Task> list = new ArrayList<>();
        while (node != null) {
            list.add(first.value);
            node = node.next;
        }
        return list;
    }

}

/*
    transient Node <Task> first;
    transient Node <Task> last;
    transient int size = 0;

    private Map<Integer, Node<Task>> map = new HashMap<>();

    public void linkLast (Task element) {
        final Node<Task> newNode = new Node<>(last, element, null);

        if (first == null || last == null) {
            first = newNode;
            return;
        }
        last.next = newNode;
        last = newNode;
        map.put(element.getTaskId(), newNode);
    }

    public void remove (Task task){ будет добавлять задачу в конец этого списка
        Node<Task> taskNode = map.get(task.getTaskId());

    }

    public list<Task> getAll() {
        Node<Task> node = first;
        List<Task> list = new ArrayList<>();
        while (node != null) {
            list.add(first.data);
            node = node.next;
        }
        return list;
    }

    static class Node {
        public R data;
        public Node<R> next;
        public Node<R> prev;
    }
*/


