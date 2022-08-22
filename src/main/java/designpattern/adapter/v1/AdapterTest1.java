package designpattern.adapter.v1;

/**
 *  对象适配器模式的实现
 */
public class AdapterTest1 {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.output5V();
    }
}

class Adaptee {
    public int output220V() {
        return 220;
    }
}

interface Target {
    int output5V();
}

class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5V() {
        int i = adaptee.output220V();
        System.out.println(String.format("原始电压：%d -> 输出电压：%d", i, 5));
        return i;
    }
}
