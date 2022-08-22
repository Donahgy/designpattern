package designpattern.adapter.v2;

/**
 *  类的适配器的实现
 */
public class AdapterTest2 {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.output5v();
    }
}

class Adaptee{
    public int output220V() {
        return 220;
    }
}

interface Target {
    int output5v();
}

class  Adapter extends Adaptee implements Target{

    @Override
    public int output5v() {
        int i = output220V();
        System.out.println(String.format("原始电压：%d -> 输出电压：%d", i, 5));
        return 5;
    }
}