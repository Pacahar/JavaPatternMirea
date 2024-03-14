package task3;

public class Task3 {
    public static void main(String[] args) {
        SynchronizedList<Integer> list = new SynchronizedList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.forEach(System.out::println);

        System.out.println();

        SynchronizedSet<Integer> set = new SynchronizedSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.forEach(System.out::println);
    }
}
