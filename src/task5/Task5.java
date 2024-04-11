package task5;

public class Task5 {
    public static void main(String[] args) {
        FirstSingleton ff = FirstSingleton.getInstance();
        ff.value = 10;
        FirstSingleton fs = FirstSingleton.getInstance();
        System.out.println(ff.value);
        System.out.println(fs.value);

        SecondSingleton sf = SecondSingleton.INSTANCE;
        sf.value = 20;
        SecondSingleton ss = SecondSingleton.INSTANCE;
        System.out.println(sf.value);
        System.out.println(ss.value);

        ThirdSingleton tf = ThirdSingleton.getInstance(30);
        ThirdSingleton ts = ThirdSingleton.getInstance();
        System.out.println(tf.getValue());
        System.out.println(ts.getValue());

    }
}
