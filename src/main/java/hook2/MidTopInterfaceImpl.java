package hook2;

public abstract class MidTopInterfaceImpl implements TopInterface{


    @Override
    public String match(String arg) {
        String args1 = midMethod("args1");
        return args1 + " " +  arg;
    }

    public String midMethod(String arg)
    {
        System.out.println(arg);
        return arg;
    }

}
