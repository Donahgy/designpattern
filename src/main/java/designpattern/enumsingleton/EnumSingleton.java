package designpattern.enumsingleton;

public enum EnumSingleton {
   INSTANCE;

   public void print()
   {
       System.out.println(this.hashCode());
   }
}


class EnumTest{
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(EnumSingleton.INSTANCE.hashCode());
        }).start();

        new Thread(() -> {
            System.out.println(EnumSingleton.INSTANCE.hashCode());
        }).start();
    }
}