package 网络编程;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerTo extends Thread{

    private ServerSocket serverSocket;

    public ServerTo(int port) throws IOException {
         serverSocket = new ServerSocket(port);
         serverSocket.setSoTimeout(10000);
    }


    public void run() {
        //进入死锁，就可以将服务器在线
        while (true) {
            try {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                Socket accept = serverSocket.accept();
                System.out.println("远程主机地址：" + accept.getRemoteSocketAddress());
                //数据流将接送请求加入
                DataInputStream in = new DataInputStream(accept.getInputStream());
                //读取转码
                System.out.println(in.readUTF());
                //取出字节流
                DataOutputStream out = new DataOutputStream(accept.getOutputStream());
                out.writeUTF("谢谢连接我：" + "当前本地socket地址为： " + accept.getLocalSocketAddress() + "\nGoodbye!");
                accept.close();

            } catch (SocketTimeoutException e) {
                System.out.println("连接超时异常：   " + e);
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

    }

    public static void main(String[] args) {

        int port = Integer.parseInt(args[0]);
        try
        {
            Thread t = new ServerTo(port);
            t.run();
        }catch(IOException e)
        {
            e.printStackTrace();
        }


    }
}

