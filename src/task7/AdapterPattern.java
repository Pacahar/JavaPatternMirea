package task7;

public class AdapterPattern {
    public static void main(String[] args) {
        Mouse beta = new MouseAdapter();
        System.out.println(beta.leftClick());
        System.out.println(beta.rightClick());
        System.out.println(beta.middleClick());
    }
}

interface Mouse{
    String leftClick();
    String rightClick();
    String middleClick();
}

class DefenderMouse{
    String signalOne(){
        return "left";
    }
    String signalTwo(){
        return "right";
    }
    String signalTree(){
        return "middle";
    }
}

class MouseAdapter extends DefenderMouse implements Mouse {

    @Override
    public String leftClick() {
        return signalOne();
    }

    @Override
    public String rightClick() {
        return signalTwo();
    }

    @Override
    public String middleClick() {
        return signalTree();
    }
}
