package task5;

public class Task5 {
    public static void main(String[] args) {
        SecondSingleton f = SecondSingleton.INSTANCE;
        f.value = 10;
        SecondSingleton s = SecondSingleton.INSTANCE;
        System.out.println(f.value);
        System.out.println(s.value);

    }
}
