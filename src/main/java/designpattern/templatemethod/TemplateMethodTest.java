package designpattern.templatemethod;

public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractClass subClass = new SubClass();
        AbstractClass subClass1 = new SubClass1();
        subClass.operation();
        subClass1.operation();
    }
}

abstract class AbstractClass {
    public void operation(){
        System.out.println("pre ...");
        System.out.println("step1");
        System.out.println("step2");
        templateMethod();
    }

    public abstract void templateMethod();
}

class SubClass extends AbstractClass{

    @Override
    public void templateMethod() {
        System.out.println("subClass executed...");
    }
}

class SubClass1 extends AbstractClass{

    @Override
    public void templateMethod() {
        System.out.println("subClass1 executed...");
    }
}
