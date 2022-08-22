package designpattern.favtory;

public class FactoryMethod {
    public static void main(String[] args) {
        Application application = new ConCreateProductA();
        Product object = application.getObject();
        object.method1();
        Application application1 = new ConCreateProductA1();
        Product object1 = application1.getObject();
        object1.method1();
    }
}

interface Product {
    public void method1();
}

class ProductA implements Product {
    public void method1() {
        System.out.println("ProductA.method1 executed...");
    }
}

class ProductA1 implements Product {
    public void method1() {
        System.out.println("ProductA1.method1 executed...");
    }
}

abstract class Application {
    abstract Product createProduct() ;

    Product getObject() {
        return createProduct();
    }
}

class ConCreateProductA extends Application{

    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ConCreateProductA1 extends Application{

    @Override
    Product createProduct() {
        return new ProductA1();
    }
}
