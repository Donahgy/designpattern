package extendtest;

public class Person implements Say{

    @Override
    public void say(String name) {
        System.out.println("I am a person and my name is "+name);
    }
}
