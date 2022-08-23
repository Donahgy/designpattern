package designpattern.ovserver;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Subject subject = new Subject();
        subject.addObserver(task1);
        subject.addObserver(task2);
        subject.notifyObserver("xxx");
        System.out.println("--------------------");
        subject.remove(task1);
        subject.notifyObserver("yyyy");
    }
}

class Subject {
    // 容器
    List<Observer> container = new ArrayList<>();

    // add
    public void addObserver(Observer observer) {
        container.add(observer);
    }

    // remove
    public void remove(Observer observer) {
        container.remove(observer);
    }

    public void notifyObserver(Object object){
        for (Observer observer : container) {
            observer.update(object);
        }
    }
}

interface Observer {
    void update(Object object);
}

class Task1 implements Observer{

    @Override
    public void update(Object object) {
        System.out.println("task1 receive: " + object);
    }
}

class Task2 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println("task2 receive: " + object);
    }
}
