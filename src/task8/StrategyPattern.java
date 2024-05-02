package task8;


public class StrategyPattern {
    public static void main(String[] args) {

        Context context = new Context();

        context.setStrategy(new ConcreteStrategyAdd());
        System.out.println("Result A : " + context.executeStrategy(3,4) );

        context.setStrategy(new ConcreteStrategySubtract());
        System.out.println("Result B : " + context.executeStrategy(3,4) );
    }
}

interface Strategy {
    int execute(int a, int b);
}

class ConcreteStrategyAdd implements Strategy {

    public int execute(int a, int b) {
        return a + b;
    }
}

class ConcreteStrategySubtract implements Strategy {

    public int execute(int a, int b) {
        return a - b;
    }
}

class Context {

    private Strategy strategy;


    public Context() {
    }


    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}
