package review.reflect;

public class Test2 {
    public static void main(String[] args) {
        User user = new User();
        ClassLoader userClassLoader = user.getClass().getClassLoader();
        System.out.println("User类的classLoader：" + userClassLoader);

        Vip vip = new Vip();
        ClassLoader vipClassLoader = vip.getClass().getClassLoader();
        System.out.println("Vip类的classLoader：" + vipClassLoader);

        System.out.println(vipClassLoader==userClassLoader);

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getPlatformClassLoader());

        System.out.println(ClassLoader.class.getClassLoader());
    }
}
