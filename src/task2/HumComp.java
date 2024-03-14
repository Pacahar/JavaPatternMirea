package task2;

import java.util.Comparator;

public class HumComp implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        if (o1.birthDate.isAfter(o2.birthDate))
            return 1;
        if (o1.birthDate.isBefore(o2.birthDate))
            return -1;
        return 0;
    }
}
