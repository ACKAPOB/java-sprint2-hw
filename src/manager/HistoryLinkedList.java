package manager;

import model.Task;

import java.util.*;

public class HistoryLinkedList{

    public Map <Integer, Node<Task>> map = new HashMap<>();
    private final LinkedList<Node<Task>> linkedList = new LinkedList<>();

    private Node<Task> first;
    private Node<Task> last;;

    static class Node <Task> {
        public Task value;
        public Node<Task> next;
        public Node<Task> prev;

        private Node( Node<Task> prev, Task value, Node<Task> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public void linkLast (Task task) { // будет добавлять задачу в конец этого списка
        final Node<Task> newNode = new Node<>(last, task, null);

        if (first == null & last == null) {
            first = newNode;
            last = newNode;
            return;
        }
        assert last != null;
        last.next = newNode;
        last = newNode;
        if (linkedList.size() == 10) {
            assert first != null;
            first.next.prev = null;
            linkedList.remove(0);
            map.remove(0);
        }
        map.put(task.getTaskId(), newNode);
        linkedList.add(newNode);
    }

    public void remove (Task task) {
        Node<Task> removeNode = map.get(task.getTaskId());
        if (removeNode.prev == null) { // определяем первую ноду
            assert false;
            removeNode.next.prev = null;
        }
        else if (removeNode.next == null) { // определяем последнюю ноду
            assert false;
            removeNode.prev.next = null;
        } else {
            removeNode.prev.next = removeNode.next; // тут некст предыдущей ноды у removeNode
            removeNode.next.prev = removeNode.prev;
        }
        map.remove(task.getTaskId());
        linkedList.remove(removeNode);
    }

    public List<Task> getTasks() {
        Node<Task> node = first;
        List<Task> list = new ArrayList<>();
        while (node != null) {
            list.add(first.value);
            node = node.next;
        }
        return list;
    }
}


