package hook2;

public class MainClass {
    public static void main(String[] args) {
        MidTopInterfaceImpl midTopInterface = new MidTopInterfaceImpl(){
            @Override
            public String midMethod(String arg) {
                System.out.println(arg);
                return arg;
            }
        };
        String aaa = midTopInterface.match("aaa");
        System.out.println(aaa);
    }
}
