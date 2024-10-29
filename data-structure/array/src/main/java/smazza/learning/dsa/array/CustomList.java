package smazza.learning.dsa.array;

import java.util.Arrays;

public class CustomList<T> {

    private T[] value;

    private T[] shiftRight(T[] list, Integer index) {
        T[] copy = Arrays.copyOf(list, list.length+1);

        for(int i=copy.length-1 ; i > index ; i--)
            copy[i] = copy[i-1];

        copy[index] = null;

        return copy;
    }

    private T[] shiftLeft(T[] list, Integer index) {
        T[] copy = Arrays.copyOf(list, list.length);

        for( ; index < copy.length; index++) {
            copy[index] = copy[index+1];
        }

        return Arrays.copyOf(copy, copy.length-1);
    }

    public CustomList(T ...list) {
        this.value = Arrays.copyOf(list, list.length);
    }

    public T[] toArray() {
        return value;
    }

    public void clear() {
        value = Arrays.copyOf(value, 0);
    }

    public Boolean isEmpty() {
        return value == null || value.length == 0;
    }

    public Boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

    public Boolean containsAll(T[] list) {
        for(T obj : list)
            if(!contains(obj))
                return Boolean.FALSE;

        return Boolean.TRUE;
    }

    public Boolean containsAll(CustomList<T> list) {
        return containsAll(list.value);
    }

    public Boolean addAll(T[] list) {
        Integer initialSize = size();
        value = Arrays.copyOf(value, initialSize+list.length);

        for(int i=0 ; i < list.length ; i++, initialSize++)
            value[initialSize] = list[i];

        return Boolean.TRUE;
    }

    public Boolean addAll(CustomList<T> list) {
        return addAll(list.value);
    }

    public Boolean addAll(Integer index, T[] list) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();

        value = Arrays.copyOf(value, size());

        for(int j=0 ; j < list.length ; j++, index++) {
            value = shiftRight(value, index);
            value[index] = list[j];
        }

        return Boolean.TRUE;
    }

    public Boolean addAll(Integer index, CustomList<T> list) throws ArrayIndexOutOfBoundsException {
        return addAll(index, list.value);
    }

    public Boolean remove(Object obj) {

        for(int i=0 ; i < size() ; i++)
            if(value[i] == obj) {
                for (int j = i ; j < size()-1; j++)
                    value[j] = value[j+1];

                value = Arrays.copyOf(value, size()-1);
                i--;
            }

        if(value[size()-1] == obj)
            value = Arrays.copyOf(value, size()-1);


        return Boolean.TRUE;
    }

    public Boolean removeAll(T[] list) {
        return removeAll(new CustomList<>(list));
    }

    public Boolean removeAll(CustomList<T> list) {
        for(int i=0 ; i < size() ; i++)
            if(list.contains(value[i])) {
                for (int j = i ; j < size()-1; j++)
                    value[j] = value[j+1];

                value = Arrays.copyOf(value, size()-1);
                i--;
            }

        if(list.contains(value[size()-1]))
            value = Arrays.copyOf(value, size()-1);

        return Boolean.TRUE;
    }

    public Boolean retainAll(T[] list) {
        return retainAll(new CustomList<>(list));
    }

    public Boolean retainAll(CustomList<T> list) {
        for(int i=0 ; i < size() ; i++)
            if(!list.contains(value[i])) {
                for (int j = i ; j < size()-1; j++)
                    value[j] = value[j+1];

                value = Arrays.copyOf(value, size()-1);
                i--;
            }

        if(!list.contains(value[size()-1]))
            value = Arrays.copyOf(value, size()-1);

        return Boolean.TRUE;
    }

    public Boolean add(T obj) {
        value = Arrays.copyOf(value, size()+1);

        value[size()-1] = obj;

        return Boolean.TRUE;
    }

    public Boolean add(Integer index, T obj) {

        value = shiftRight(value, index);
        value[index] = obj;

        return Boolean.TRUE;
    }

    public Boolean addFirst(T obj) {
        return add(0, obj);
    }

    public Boolean addLast(T obj) {
        add(size()-1, obj);

        T t = value[size()-1];
        value[size()-1] = value[size()-2];
        value[size()-2] = t;

        return Boolean.TRUE;
    }

    public Integer indexOf(T obj) {
        for(int i=0 ; i < size() ; i++)
            if(value[i] == obj)
                return i;

        return -1;
    }

    public Integer lastIndexOf(T obj) {
        for(int i=size()-1 ; i >= 0 ; i--)
            if(value[i] == obj)
                return i;

        return -1;
    }

    public Integer size() {
        return value.length;
    }

    public T get(Integer index) {
        if(index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();

        return value[index];
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size()-1);
    }

    public T remove(Integer index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();

        T returnValue = value[index];

        if(index == size()-1) {
            value = Arrays.copyOf(value, size()-1);
            return returnValue;
        }

        for ( ; index < size()-1; index++)
            value[index] = value[index+1];

        value = Arrays.copyOf(value, size()-1);


        return returnValue;
    }

    public T removeFirst() throws ArrayIndexOutOfBoundsException {
        return remove(0);
    }

    public T removeLast() throws ArrayIndexOutOfBoundsException {
        return remove(size()-1);
    }

    public T set(Integer index, T obj) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();

        value[index] = obj;

        return obj;
    }

    public CustomList<T> reversed() {
        CustomList<T> reversed = new CustomList<>(value);

        for(int i=0, j=size()-1 ; i < size() ; i++, j--)
            reversed.set(i, get(j));

        return reversed;
    }

    public CustomList<T> sublist(Integer startIndex, Integer endIndex) throws ArrayIndexOutOfBoundsException {
        if(startIndex < 0 || startIndex > endIndex || endIndex >= size())
            throw new ArrayIndexOutOfBoundsException();

        CustomList<T> sublist = new CustomList<>(Arrays.copyOf(value, (endIndex-startIndex)+1));

        for(int j=sublist.size()-1 ; endIndex >= startIndex ; endIndex--, j--)
            sublist.set(j, get(endIndex));

        return sublist;
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
