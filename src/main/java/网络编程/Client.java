package 网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class Client {
    public static void main(String args[]) throws IOException {
        Socket socket=createSocket();
        initSocketConfig(socket);
        //连接到本地 端口为20000的服务端 连接超时5000
        socket.connect(new InetSocketAddress(InetAddress.getLocalHost(),20000),5000);
        System.out.println("成功连接到服务器");

        //输入流 用于获取服务端发送到的数据 socket.getInputStream()
        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //输出流 用于向服务端发送数据 socket.getOutputStream()
        PrintStream writer=new PrintStream(socket.getOutputStream());

        //键盘流
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        boolean flag=true;
        do {
            String line=cin.readLine();
            writer.println(line);//发送数据
            String rcv=reader.readLine();//接收数据
            System.out.println("Server:"+rcv);
            if (rcv.equalsIgnoreCase("bye")){
                flag=false;
            }
        }while (flag);

        //释放资源
        System.out.println("客户端退出");
        cin.close();
        writer.close();
        reader.close();
        socket.close();
    }

    private static void initSocketConfig(Socket socket) throws SocketException {
        socket.setSoTimeout(5000);//读超时时间
        socket.setReuseAddress(true);
        socket.setKeepAlive(true);
        socket.setOOBInline(true);
        socket.setTcpNoDelay(true);
        socket.setSoLinger(true,200);
        socket.setSendBufferSize(64*1024*1024);
        socket.setReceiveBufferSize(64*1024*1024);
    }

    private static Socket createSocket() throws IOException {
        Socket socket=new Socket();
        return socket;
    }
}
