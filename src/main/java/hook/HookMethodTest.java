package hook;

/**
 *  Java钩子方法的实现
 */
public class HookMethodTest {
    public static void main(String[] args) {
        HookMethodTest hookMethodTest = new HookMethodTest();
        hookMethodTest.watch("aaa", () -> {
            System.out.println("This is hook method...");
        });
    }

    void watch(String a, HookInterface i) {
        System.out.println("This is watch method and the argument is " + a + "... ");
        i.show();
    }
}
