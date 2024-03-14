package task2;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Stream;

public class task2 {
    public static void main(String[] args) {
        List<Human> input = new ArrayList<Human>();
        input.add(new Human(19, "Kirill", "Sokolovskiy", LocalDate.of(2004, 11, 29), 75));
        input.add(new Human(19, "Kirill", "Yakobchuk", LocalDate.of(2004, 5, 25), 59));
        input.add(new Human(19, "Kirill", "Zareckiy", LocalDate.of(2005, 1, 4), 55));
        input.add(new Human(19, "Kirill", "Lvov", LocalDate.of(2004, 1, 14), 59));
        input.add(new Human(19, "Valeria", "Sokolovskaya", LocalDate.of(2003, 6, 22), 52));
        input.add(new Human(19, "Ignat", "Kuzmin", LocalDate.of(2004, 9, 17), 59));

        Stream<Human> stream = input.stream();
        HumComp comporator = new HumComp();
        stream.filter(Human -> Human.weight < 60).sorted(comporator).limit(5).
                map(i -> i.firstName + " " + i.lastName).forEach(System.out::println);
    }
}
