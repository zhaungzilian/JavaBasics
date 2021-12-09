package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaReflectionTest {
    //src/main/java/Reflection/Users.java
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {

        //反向获取class信息
//        Class<?> c1 = Class.forName("Reflection.Users");
//        Class<?> c2 = Class.forName("Reflection.Users");
//        Class<?> c3 = Class.forName("Reflection.Users");
//        System.out.println("hashcode内存地址： \n"+c1.hashCode() +"\n"+ c2.hashCode()+"\n" +c3.hashCode());
//
//        Users users = new Users();
//        Class aClass = users.getClass();
//        System.out.println(aClass.hashCode());
/*
    System.out.println("---------------------第一种方式------------------------------------");
        //利用反射操作目标class
        Class getclass = Class.forName("Reflection.Users");
        //通过反射调用普通方法
        Users usermath = (Users) getclass.newInstance();
        //拿到声明方法，元素为string uname
        Method meth = getclass.getDeclaredMethod("username",String.class);
        //激活反射
        meth.invoke(usermath,"李宁");
        System.out.println(usermath.);
*/
        //用反射获取class方法
        System.out.println("---------------------第二种方式------------------------------------");
//        //通过构造器创建对象
//        Class user = Class.forName("Reflection.Users");
//        Constructor constructor = user.getDeclaredConstructor(int.class,String.class);
//        //创建实例
//        constructor.setAccessible(true);
//        Users instance = (Users) constructor.newInstance(1, "李华");
//        System.out.println("用构造器对指定目标类进行改造，从新添加了构造器和数据类型进行赋值： " + instance);


        System.out.println("---------------------第三种方式------------------------------------");
        Users users = new Users();
        Class usersClass = users.getClass();
        Method method = usersClass.getDeclaredMethod("getId", int.class);
        method.invoke(usersClass,1);
        method.setAccessible(true);



    }

}

