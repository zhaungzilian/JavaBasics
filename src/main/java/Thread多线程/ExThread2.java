package Thread多线程;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ExThread2 {

    public static void main(String[] args) {

        new Thread(()->{
            int sum = 0 ;
            for (int i = 0; i < 200; i++) {
                sum += sum + i;
                System.out.println(sum);
            }
        }, "thead").start();


    }


    //获取web 地址图片工具
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
