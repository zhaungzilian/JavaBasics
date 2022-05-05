package Thread多线程;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author  zzy
 * @create
 * @desc
 * @return
 * 3种创建线程
 * 1. Thread class,  重写run方法，调用start
 *      1.1 luanda简写
 * 2. Runnable interface
 * 3. Callable
 *
 *
 *
 *
 **/


//1. 利用FileUtils 获取网页下载连接。 多线程下载图片
public class ExThread extends Thread{

    String url;
    String fname;

    public ExThread( String url, String fname){
        this.url = url;
        this.fname = fname;
    }

    @Override
    public void run() {
        WebLoder webLoder = new WebLoder();
        webLoder.loding(url, fname);
        System.out.println("下载的文件名炜： " + fname);
    }


    public static void main(String[] args) {

        ExThread exThread = new ExThread("https://img1.doubanio.com/view/photo/sqxs/public/p2503810618.webp", "浴血黑帮.jpg");
        ExThread exThread2 = new ExThread("https://img9.doubanio.com/view/photo/l/public/p2503810615.webp", "浴血黑帮2.jpg");
        exThread.start();
        exThread2.start();

    }

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