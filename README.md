# Notebook
我的个人技术文章和学习笔记

### Java数据结构
> 数组相关问题

```java
public class ArrayList<E> implements List<E> {

    private static final int RESIZE_CAPACITY = 2;

    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;

    private int size;

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public void add(int index, E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        if(data.length == size)
            resize(RESIZE_CAPACITY * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return data[index];
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public void set(int index, E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal");
        data[index] = e;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        if (size == data.length / (RESIZE_CAPACITY * 2) && data.length / 2 != 0) // lazy resize
            resize(data.length / RESIZE_CAPACITY);

        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // clear to let GC do its work
        return res;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("ArrayList: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }
}
```