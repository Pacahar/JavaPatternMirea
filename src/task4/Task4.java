package task4;

public class Task4 {

    public static void main(String[] args) {
        MyExecutorService executor = new MyExecutorService(2);

        executor.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Выполнение 1 было прервано");
            }
            System.out.println("Задание 1 было выполнено " + Thread.currentThread().getName());
        });

        executor.submit(() -> {
            System.out.println("Задание 2 было выполнено " + Thread.currentThread().getName());
        });

        executor.shutDown();
    }
}