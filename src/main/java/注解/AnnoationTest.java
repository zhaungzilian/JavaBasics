package 注解;


import java.lang.annotation.*;

@Documented()
@Retention(RetentionPolicy.RUNTIME)//在虚拟机中保留注解，通过反射后可以得到注解信息
@Target(ElementType.METHOD) //限定只能修饰方法methon
public @interface AnnoationTest {
    int id() default 1;
    String username() default "root";
}
