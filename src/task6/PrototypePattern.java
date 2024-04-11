package task6;

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Can prot = new EmptyColaCan();
        TrashBin bin = new TrashBin(prot);

        Can can1 = bin.pickCan();
        System.out.println(can1);
        System.out.println(can1.filled);

        Can can2 = bin.pickCan();
        System.out.println(can2);
        System.out.println(can2.filled);

        Can can3 = bin.pickCan();
        System.out.println(can3);
        System.out.println(can3.filled);
    }
}

class Can implements Cloneable{

    public boolean filled;
    @Override
    public Can clone() throws CloneNotSupportedException {
        Can copy = (Can) super.clone();
        return copy;
    }
}

class EmptyColaCan extends Can {
    public EmptyColaCan() {
        this.filled = false;
    }
}

class TrashBin{
    private Can concreteCan;
    public TrashBin(Can can) {
        this.concreteCan = can;
    }

    public Can pickCan() throws CloneNotSupportedException {
        return (Can) this.concreteCan.clone();
    }
}
