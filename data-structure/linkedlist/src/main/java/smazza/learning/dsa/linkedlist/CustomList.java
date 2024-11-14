package smazza.learning.dsa.linkedlist;

import java.util.Arrays;
import java.util.Objects;

public class CustomList<T> {

    private CustomListNode<T> head;
    private Integer length;

    public CustomList(CustomListNode<T> head) {
        this.head = head;
        this.length = 0;

        CustomListNode<T> current = head;
        while(!Objects.isNull(current)) {
            length++;

            current = current.getNext();
        }
    }

    public CustomList(T value) {
        this.head = new CustomListNode<>(value);
        this.length = 1;
    }

    public CustomList(T ...value) {
        this.head = new CustomListNode<>(value[0]);
        this.length = value.length;

        CustomListNode<T> current = head;
        for(int i=1 ; i < length ; i++) {
            current.setNext(new CustomListNode<>(value[i]));

            current = current.getNext();
        }
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[length];

        CustomListNode<T> current = head;
        int i=0;
        while(!Objects.isNull(current)) {
            array[i] = current.getValue();

            i++;
            current = current.getNext();
        }

        return array;
    }

    public void clear() {
        head = null;
        length = 0;
    }

    public Boolean isEmpty() {
        return Objects.isNull(head) || Objects.isNull(head.getValue());
    }

    public Boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

    public Boolean containsAll(T[] list) {
        for(T el : list)
            if(!contains(el))
                return Boolean.FALSE;

        return Boolean.TRUE;
    }

    public Boolean containsAll(CustomList<T> list) {
        return containsAll(list.toArray());
    }

    public Boolean addAll(T[] list) {
        CustomListNode<T> tail = head;
        while(!Objects.isNull(tail.getNext()))
            tail = tail.getNext();

        for(T obj : list) {
            tail.setNext(new CustomListNode<>(obj));
            tail = tail.getNext();
        }

        length += list.length;

        return Boolean.TRUE;
    }

    public Boolean addAll(CustomList<T> list) {
        return addAll(list.toArray());
    }

    public Boolean addAll(Integer index, T[] list) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= length)
            throw new ArrayIndexOutOfBoundsException();

        CustomListNode<T> current = head;
        CustomListNode<T> repos = null;
        for (int i=0 ; i < index-1 ; i++)
            current = current.getNext();

        repos = current.getNext();

        for(T el : list) {
            current.setNext(new CustomListNode<>(el));

            current = current.getNext();
        }

        current.setNext(repos);
        length += list.length;

        return Boolean.TRUE;
    }

    public Boolean addAll(Integer index, CustomList<T> list) throws ArrayIndexOutOfBoundsException {
        return addAll(index, list.toArray());
    }

    public Boolean remove(Object obj) {
        CustomListNode<T> current = head;
        CustomListNode<T> last = null;
        while(!Objects.isNull(current)) {
            if(current.getValue().equals(obj)) {
                if(Objects.isNull(last))
                    head = current.getNext();
                else
                    last.setNext(current.getNext());
                length--;
            } else {
                last = current;
            }

            current = current.getNext();
        }

        return Boolean.TRUE;
    }

    public Boolean removeAll(T[] list) {

        for(T obj : list)
            remove(obj);

        return Boolean.TRUE;
    }

    public Boolean removeAll(CustomList<T> list) {
        return removeAll(list.toArray());
    }

    public Boolean retainAll(T[] list) {
        return retainAll(new CustomList<>(list));
    }

    public Boolean retainAll(CustomList<T> list) {

        CustomListNode<T> current = head;
        while(!Objects.isNull(current)) {
            if(!list.contains(current.getValue()) && !remove(current.getValue())) {
                return Boolean.FALSE;
            }

            current = current.getNext();
        }

        return Boolean.TRUE;
    }

    public Boolean add(T obj) {
        if(Objects.isNull(head)){
            head = new CustomListNode<>(obj);
            length++;

            return Boolean.TRUE;
        }

        CustomListNode<T> tail = head;
        while(!Objects.isNull(tail.getNext()))
            tail = tail.getNext();

        tail.setNext(new CustomListNode<>(obj));

        length++;

        return Boolean.TRUE;
    }

    public Boolean add(Integer index, T obj) {
        if(index < 0 || index >= length)
            throw new ArrayIndexOutOfBoundsException();

        if(index == 0)
            return addFirst(obj);

        CustomListNode<T> last = null;
        CustomListNode<T> current = head;
        for(int i=0 ; i < length ; i++) {
            if(i == index) {
                last.setNext(new CustomListNode<>(obj, current));
                length++;
                return Boolean.TRUE;
            }

            last = current;
            current = current.getNext();
        }

        return Boolean.FALSE;
    }

    public Boolean addFirst(T obj) {
        head = new CustomListNode<>(obj, head);
        length++;

        return Boolean.TRUE;
    }

    public Boolean addLast(T obj) {
        return add(obj);
    }

    public Integer indexOf(T obj) {
        CustomListNode<T> current = head;
        Integer index = 0;

        while(!Objects.isNull(current)) {
            if(current.getValue().equals(obj))
                return index;

            index++;
            current = current.getNext();
        }

        return -1;
    }

    public Integer lastIndexOf(T obj) {
        CustomListNode<T> current = head;
        Integer index = 0;
        Integer foundIndex = -1;

        while(!Objects.isNull(current)) {
            if(current.getValue().equals(obj))
                foundIndex = index;

            index++;
            current = current.getNext();
        }

        return foundIndex;
    }

    public Integer size() {
        return length;
    }

    public T get(Integer index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= length)
            throw new ArrayIndexOutOfBoundsException();

        CustomListNode<T> current = head;
        Integer i = 0;

        while(!Objects.isNull(current)) {
            if(i.equals(index)) {
                return current.getValue();
            }

            i++;
            current = current.getNext();
        }

        return null;
    }

    public T getFirst() {
        return head.getValue();
    }

    public T getLast() {
        if(Objects.isNull(head))
            return null;

        CustomListNode<T> tail = head;
        while(!Objects.isNull(tail.getNext()))
            tail = tail.getNext();

        return tail.getValue();
    }

    public T remove(Integer index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= length)
            throw new ArrayIndexOutOfBoundsException();

        CustomListNode<T> last = null;
        CustomListNode<T> current = head;
        Integer i = 0;

        while(!Objects.isNull(current)) {
            if(i.equals(index)) {
                if(Objects.isNull(last))
                    head = current.getNext();
                else
                    last.setNext(current.getNext());
                length--;

                return current.getValue();
            } else {
                last = current;
            }

            i++;
            current = current.getNext();
        }

        return null;
    }

    public T removeFirst() throws ArrayIndexOutOfBoundsException {
        if(isEmpty())
            throw new ArrayIndexOutOfBoundsException();

        T value = head.getValue();

        head = head.getNext();
        length--;

        return value;
    }

    public T removeLast() throws ArrayIndexOutOfBoundsException {
        CustomListNode<T> current = head;
        while(!Objects.isNull(current)) {
            if(Objects.isNull(current.getNext().getNext())) {
                T value = current.getNext().getValue();
                current.setNext(null);
                length--;
                return value;
            }

            current = current.getNext();
        }

        return null;
    }

    public T set(Integer index, T obj) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= length)
            throw new ArrayIndexOutOfBoundsException();

        CustomListNode<T> current = head;
        Integer i = 0;

        while(!Objects.isNull(current)) {
            if(i.equals(index)) {
                T value = current.getValue();
                current.setValue(obj);
                return value;
            }

            i++;
            current = current.getNext();
        }

        return null;
    }

    public CustomList<T> reversed() {
        T[] list = (T[]) new Object[length];
        T[] array = toArray();

        for(int i=0, j=length-1; i < length ; i++, j--)
            list[i] = array[j];

        return new CustomList<>(list);
    }

    public CustomList<T> sublist(Integer startIndex, Integer endIndex) throws ArrayIndexOutOfBoundsException {
        if(startIndex < 0 || startIndex > endIndex || endIndex >= length)
            throw new ArrayIndexOutOfBoundsException();

        CustomListNode<T> current = head;
        Integer i = 0;
        CustomList<T> sublist = null;
        while(!Objects.isNull(current)) {
            if(i.equals(startIndex)) {
                sublist = new CustomList<>(current.getValue());
                break;
            }

            i++;
            current = current.getNext();
        }

        current = sublist.head;
        while(!Objects.isNull(current)) {
            if(i+1 == endIndex) {
                current.setNext(null);
                return sublist;
            }

            i++;
            current = current.getNext();
        }

        return null;
    }

    @Override
    public String toString() {
        return "CustomList{ head = " + head + ", length = " + length + " }";
    }
}
