package 泛型;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class GenericsTests {

    //泛型的方法使用   比较数的大小   该类型是class类型
    public static <T extends Comparable<T>> T maximum(T x,T y,T m){
        T max = m;
        if (x.compareTo(max) > 0){
            max = x;
        }
        if (y.compareTo(max)>0){
            max = y;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.printf("%d, %d 和 %d 其中最大的值是 %d\n",20,1133,44 ,maximum(20,1133,44));
        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        Generics<String> generics = new Generics<>();
        generics.add("lihuanihao");
        generics.delet();
        System.out.println(generics.get());


    }

}
//泛型类
class Generics<T>{
    private T t;
    public void add(T t){
        this.t =t;
    }
    public T get(){
        return t;
    }
    public void delet(){
        this.t = null;
    }
}