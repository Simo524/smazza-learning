package smazza.learning.dsa.linkedlist;


import java.util.Arrays;

public class Application {

    public static void main(String[] args) {



        CustomList<Integer> list = new CustomList<>(1, 2, 3, 4);

        System.out.println("list.isEmpty(): " + list.isEmpty());
        System.out.println("list.contains(1): " + list.contains(1));
        System.out.println("list.containsAll(new Integer[]{1, 2, 4}): " + list.containsAll(new Integer[]{1, 2, 4}));
        System.out.println("list.containsAll(new CustomList<>(1, 2, 3)): " + list.containsAll(new CustomList<>(1, 2, 3)));
        list.addAll(new Integer[]{3, 11});
        System.out.println("list.addAll(new Integer[]{3, 11}): " + list);
        list.addAll(new CustomList<>(3, 11));
        System.out.println("list.addAll(new CustomList<>(3, 11)): " + list);
        list.addAll(5, new Integer[]{1243, 98234});
        System.out.println("list.addAll(5, new Integer[]{1243, 98234}): " + list);
        list.addAll(5, new CustomList<>(231675, 2143876));
        System.out.println("list.addAll(5, new CustomList<>(231675, 2143876)): " + list);
        list.remove((Object) 3);
        System.out.println("list.remove((Object) 3): " + list);
        list.remove(0);
        System.out.println("list.remove(0): " + list);
        list.removeAll(new Integer[]{3, 11});
        System.out.println("list.removeAll(new Integer[]{3, 11}): " + list);
        list.removeAll(new CustomList<>(1, 2, 4));
        System.out.println("list.removeAll(new CustomList<>(1, 2, 4)): " + list);
        list.retainAll(new Integer[]{231675, 2143876});
        System.out.println("list.retainAll(new Integer[]{231675, 2143876}): " + list);
        list.retainAll(new CustomList<>(231675, 2143876));
        System.out.println("list.retainAll(new CustomList<>(231675, 2143876)): " + list);
        System.out.println("list.indexOf(231675): " + list.indexOf(231675));
        System.out.println("list.lastIndexOf(231675): " + list.lastIndexOf(231675));
        System.out.println("list.size(): " + list.size());
        list.add(11);
        System.out.println("list.add(11): " + list);
        list.add(0, 76);
        System.out.println("list.add(0, 76): " + list);
        list.addFirst(1);
        System.out.println("list.addFirst(1): " + list);
        list.addLast(999);
        System.out.println("list.addLast(999): " + list);
        System.out.println("list.get(3): " + list.get(3));
        System.out.println("list.getFirst(): " + list.getFirst());
        System.out.println("list.getLast(): " + list.getLast());
        list.removeFirst();
        System.out.println("list.removeFirst(): " + list);
        list.removeLast();
        System.out.println("list.removeLast(): " + list);
        System.out.println("list.toArray(): " + Arrays.toString(list.toArray()));
        list.set(0, 0);
        System.out.println("list.set(0, 0): " + list);
        System.out.println("list.reversed(): " + list.reversed());
        System.out.println("list.sublist(0, 1): " + list.sublist(0, 1));
        list.clear();
        System.out.println("list.clear(): " + list);

    }
}
