package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EfficiencyTest {


    public static  void test1()  {
        //第一种无反射
        Users users = new Users();

        long statr = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            users.getEmail();
        }

        long end =  System.currentTimeMillis();
        System.out.println("普通的执行所需要的时间：  " + (end - statr)+" 毫秒");

    }

    //用反射测试速度 没有声明 getId.setAccessible(true);
    public static  void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //第一种无反射
        Users users = new Users();
        Class usersClass = users.getClass();
        Method getNames = usersClass.getDeclaredMethod("getNames", null);

        long statr = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getNames.invoke(users,null);
        }

        long end =  System.currentTimeMillis();
        System.out.println("反射的执行所需要的时间：  " + (end - statr)+" 毫秒");

    }

    public static  void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //第一种无反射
        Users users = new Users();
        Class usersClass = users.getClass();
        Method getId = usersClass.getDeclaredMethod("getId", null);
        getId.setAccessible(true);
        long statr = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
           getId.invoke(users,null);
        }

        long end =  System.currentTimeMillis();
        System.out.println("反射带有Accessible(true)的执行所需要的时间：  " + (end - statr)+" 毫秒");

    }



    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test1(); // 274 毫秒
        test2(); //2.98635 分钟
        test3();  // 8.586  秒
    }


}
