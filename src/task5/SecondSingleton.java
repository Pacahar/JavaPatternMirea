package task5;

public enum SecondSingleton {
    INSTANCE;
    int value;
    public SecondSingleton getInstance(){
        return INSTANCE;
    }

}
