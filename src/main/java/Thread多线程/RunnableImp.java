package Thread多线程;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
// 方式二 ， 继承runable接口， 用Thread（runnabel）作为启动类start();
public class  RunnableImp implements Runnable{

    public String url;
    public String fname;

    RunnableImp(String url, String fname){
         this.url = url;
         this.fname = fname;
    }

    @Override
    public void run() {
        System.currentTimeMillis();
        WebLoder webLoder = new WebLoder();
        webLoder.loding(url,fname);
        System.out.println("拷贝成功！ ");
    }


    public static void main(String[] args) {

        RunnableImp runnableImp = new RunnableImp("https://img1.doubanio.com/view/photo/sqxs/public/p2503810618.webp","aa.jpg");
        RunnableImp runnableImp2 = new RunnableImp("https://img9.doubanio.com/view/photo/l/public/p2503810615.webp","bb.jpg");

        new Thread(runnableImp).start();
        new Thread(runnableImp2).start();

    }

    //获取web 地址图片工具
    class WebLoder {
        public void loding(String url, String fname) {
            try {
                FileUtils.copyURLToFile(new URL(url), new File(fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
