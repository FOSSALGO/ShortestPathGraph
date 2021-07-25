package shortestpath;

import java.util.LinkedList;

class Queue<E> {

    private LinkedList<E> list = new LinkedList<E>();

    public Queue() {
        list = new LinkedList<E>();
    }

    public void add(E item) {
        list.addLast(item);
    }

    public E poll() {
        return list.poll();
    }

    public E peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

}
