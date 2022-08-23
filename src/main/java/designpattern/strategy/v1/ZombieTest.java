package designpattern.strategy.v1;

public class ZombieTest {
    public static void main(String[] args) {
        AbstractZombie normalZombie = new NormaZombie();
        AbstractZombie flagZombie = new FlagZombie();

        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();

        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();
    }
}

abstract class AbstractZombie {
    public abstract void display();

    public void attack()
    {
        System.out.println("咬...");
    }

    public void move()
    {
        System.out.println("移动...");
    }
}

class NormaZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("我是普通僵尸...");
    }
}

class FlagZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("我是旗手僵尸...");
    }
}

class BigHeadZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("大头僵尸...");
    }

    @Override
    public void attack() {
        System.out.println("头撞...");
    }
}

class XxxZombie extends BigHeadZombie{
    @Override
    public void move() {
        System.out.println("xxxx...");
    }
}