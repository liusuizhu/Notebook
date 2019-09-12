package util;

public class ArrayStack<E> implements Stack<E> {

    private ArrayList<E> arrayList;

    public ArrayStack(int capacity) {
        arrayList = new ArrayList<>(capacity);
    }

    public ArrayStack() {
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

    public int Capacity() {
        return arrayList.getCapacity();
    }

    @Override
    public void push(E e) {
        arrayList.addLast(e);
    }

    @Override
    public E pop() {
        return arrayList.removeLast();
    }

    @Override
    public E peek() {
        return arrayList.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i < arrayList.getSize(); i++) {
            res.append(arrayList.get(i));
            if (i != arrayList.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
