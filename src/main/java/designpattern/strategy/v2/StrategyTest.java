package designpattern.strategy.v2;

public class StrategyTest {
    public static void main(String[] args) {
        Zombie normalZombie = new NormalZombie();
        normalZombie.display();
        normalZombie.move();
        normalZombie.setAttack(new HitAttack());
        normalZombie.attack();
    }
}

interface Moveable{
    void move();
}

interface Attack{
    void attack();
}

abstract class Zombie {
    Moveable moveable;
    Attack attack;
    abstract public void display();
    abstract void move();
    abstract void attack();

    public Zombie(Moveable moveable, Attack attack) {
        this.moveable = moveable;
        this.attack = attack;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }
}

class StepByStepMove implements Moveable{

    @Override
    public void move() {
        System.out.println("一步一动...");
    }
}

class BiteAttack implements Attack{

    @Override
    public void attack() {
        System.out.println("咬...");
    }
}

class HitAttack implements Attack{

    @Override
    public void attack() {
        System.out.println("打...");
    }
}

class FlagZombie extends Zombie{

    public FlagZombie() {
        super(new StepByStepMove(),new BiteAttack());
    }

    public FlagZombie(Moveable moveable, Attack attack) {
        super(moveable, attack);
    }

    @Override
    public void display() {
        System.out.println("我是旗手僵尸...");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attack.attack();
    }
}

class NormalZombie extends Zombie{

    public NormalZombie() {
         super(new StepByStepMove(),new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attack attack) {
        super(moveable, attack);
    }

    @Override
    public void display() {
        System.out.println("我是普通僵尸...");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attack.attack();
    }
}

