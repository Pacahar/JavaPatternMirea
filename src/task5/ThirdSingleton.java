package task5;

public class ThirdSingleton {
    private int value;

    private ThirdSingleton(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static class SingletonHolder {
        private static ThirdSingleton instance;
    }

    public static ThirdSingleton getInstance() {
        return SingletonHolder.instance;
    }

    public static ThirdSingleton getInstance(int value) {
        if (SingletonHolder.instance == null) {
            synchronized (ThirdSingleton.class) {
                if (SingletonHolder.instance == null) {
                    SingletonHolder.instance = new ThirdSingleton(value);
                }
            }
        }
        return SingletonHolder.instance;
    }
}
