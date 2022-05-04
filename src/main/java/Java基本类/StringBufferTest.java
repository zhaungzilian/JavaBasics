package Java基本类;
/**
 * @author  zzy
 *
    当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类



 **/
public class StringBufferTest {


    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("java");
        stringBuffer.insert(3,"stringbuffer测试");

        int capacity = stringBuffer.capacity();
        System.out.println( "stringBuffer元素： "+ stringBuffer +
                "\n当前buffer容器为： " + capacity);


    }


}
