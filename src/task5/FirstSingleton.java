package task5;

public class FirstSingleton {
    public static FirstSingleton instance;
    int value;
    public static synchronized FirstSingleton getInstance() {
        if (instance == null) {
            instance = new FirstSingleton();
        }
        return instance;
    }

}
