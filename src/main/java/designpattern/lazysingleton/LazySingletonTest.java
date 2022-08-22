package designpattern.lazysingleton;

public class LazySingletonTest {
    public static void main(String[] args) {
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}

class LazySingleton {
    private volatile static LazySingleton instance;

    public LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
