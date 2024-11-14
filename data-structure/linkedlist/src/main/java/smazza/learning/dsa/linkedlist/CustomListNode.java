package smazza.learning.dsa.linkedlist;

public class CustomListNode<T> {

    private T value;
    private CustomListNode<T> next;

    public CustomListNode(T value, CustomListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public CustomListNode(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public CustomListNode<T> getNext() {
        return next;
    }

    public void setNext(CustomListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{ value = " + value + ", next -> " + next + " }";
    }
}
