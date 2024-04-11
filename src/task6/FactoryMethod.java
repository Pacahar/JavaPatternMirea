package task6;

interface Product { }

class ConcreteProductA implements Product { }

class ConcreteProductB implements Product { }

abstract class Creator {
    public abstract Product factoryMethod();
}

class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() { return new ConcreteProductA(); }
}

class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() { return new ConcreteProductB(); }
}

public class FactoryMethod {
    public static void main(String[] args) {

        Creator[] creators = {new ConcreteCreatorA(), new ConcreteCreatorB()};

        for (Creator creator: creators) {
            Product product = creator.factoryMethod();
            System.out.printf("Created {%s}\n", product.getClass());
        }
    }
}