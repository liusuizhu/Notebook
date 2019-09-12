package util;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;

    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enQueue(E e) {
        if (tail == null) { // queue is empty
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        Node retNode = head;
        head = head.next;
        retNode.next = null; // clear to let GC do its work
        if (head == null)
            tail = null;
        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

//    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedListQueue<>();
//        for (int i = 0; i < 10; i++) {
//            queue.enQueue(i);
//            if (i % 3 == 2)
//                queue.deQueue();
//            System.out.println(queue);
//        }
//
//    }
}
