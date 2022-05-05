package Thread多线程;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class CallableImp implements Callable<Boolean> {
    String url;
    String fname;
    CallableImp(String url,String fname){
        this.url= url;
        this.fname = fname;
    }

    @Override
    public Boolean call() throws Exception {
        new WebLoder().loding(url,fname);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableImp c1 = new CallableImp("https://img1.doubanio.com/view/photo/sqxs/public/p2503810618.webp","1.jpg");
        CallableImp c2 = new CallableImp("https://img1.doubanio.com/view/photo/sqxs/public/p2503810618.webp","2.jpg");
        CallableImp c3 = new CallableImp("https://img1.doubanio.com/view/photo/sqxs/public/p2503810618.webp","3.jpg");
        //1创建执行服务类 : 输入线程数
       ExecutorService ex = Executors.newFixedThreadPool(3);

        //2提交执行
        Future<Boolean> future = ex.submit(c1);
        Future<Boolean> future2 = ex.submit(c2);
        Future<Boolean> future3 = ex.submit(c3);

        //3获取结果
        Boolean r1 = future.get();
        Boolean r2 = future2.get();
        Boolean r3 = future3.get();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        //4关闭线程池
        ex.shutdown();




    }

    class WebLoder{
        public void loding(String url, String fname){
            try {
                FileUtils.copyURLToFile(new URL(url), new File(fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
