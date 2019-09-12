package util;

public class ArrayQueue<E> implements Queue<E> {

    private ArrayList<E> arrayList;

    public ArrayQueue(int capacity) {
        arrayList = new ArrayList<>(capacity);
    }

    public ArrayQueue() {
        arrayList = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return arrayList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public int getCapacity() {
        return arrayList.getCapacity();
    }
    
    @Override
    public void enQueue(E e) {
        arrayList.addLast(e);
    }

    @Override
    public E deQueue() {
        return arrayList.removeFirst();
    }

    @Override
    public E getFront() {
        return arrayList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front [");
        for (int i = 0; i < arrayList.getSize(); i++) {
            res.append(arrayList.get(i));
            if (i != arrayList.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
