package designpattern.innerclasssingleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton == instance);
    }
}

class InnerClassSingleton implements Serializable {

    private static final long serialVersionUID = 42L;

    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        if (InnerClassHolder.instance != null)
        {
            throw new RuntimeException("单例不允许多个实例...");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }
}
