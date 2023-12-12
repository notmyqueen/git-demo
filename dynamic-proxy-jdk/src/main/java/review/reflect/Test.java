package review.reflect;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取Class的3种方式：
        //方式一：
        Class<?> aClass = Class.forName("review.reflect.User");

        //方式二：
        Class<User> userClass = User.class;

        //方式三：
        User user = new User();
        Class<? extends User> aClass1 = user.getClass();

        System.out.println(aClass == userClass);
        System.out.println(userClass == aClass1);

        System.out.println(aClass);
        System.out.println(userClass);
        System.out.println(aClass1);

        Class<? extends ClassLoader> aClass2 = ClassLoader.getSystemClassLoader().getClass();
        System.out.println("aClass2: " + aClass2);

        ClassLoader classLoader = User.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println("classLoader的类名字：" + classLoader.getClass().getName());
        ClassLoader.getSystemClassLoader();

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        System.out.println(new User());

        System.out.println("user的getClass方法：" + user.getClass());
    }

}
