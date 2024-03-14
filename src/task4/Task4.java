package task4;

public class Task4 {

    public static void main(String[] args) {
        MyExecutorService executor = new MyExecutorService(2);

        executor.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("Task_1 thread was interrupted");
            }
            System.out.println("Task 1 executed by " + Thread.currentThread().getName());
        });

        executor.submit(() -> System.out.println("Task 2 executed by "
                + Thread.currentThread().getName()));

        executor.shutDown();
    }
}