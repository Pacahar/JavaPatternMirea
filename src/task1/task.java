package task1;

public class task{
    public static void main(String[] args) {
        Integer a = 12;
        Integer b = -13;
        Integer c = -11;
        Comp comparator = new Comp();
        System.out.println(comparator.compare(a, b));
        System.out.println(comparator.compare(a, c));
        System.out.println(comparator.compare(b, c));
    }
}
