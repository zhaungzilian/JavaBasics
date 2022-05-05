package Thread多线程;
//方式二： runable 的流式写法
public class Runnable2 {
    public static void main(String[] args) {
        //run
        Runnable runnable = ()-> {
            for (int i = 0; i < 2000; i++) {
                System.out.println("方式二流式写法" + i);
            }
        };
        //start
        new Thread(runnable).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("main——" + i);
        }
    }
}
