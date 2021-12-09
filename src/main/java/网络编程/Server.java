package 网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {
    public static void  main(String args[]) throws IOException {
        //创建服务端套接字，监听20000端口
        ServerSocket server=createSocket();
        initServerConfig(server);
        System.out.println("服务端准备就绪>> IP:"+server.getLocalSocketAddress().toString()+" PORT:"+server.getLocalPort());
        while (true){
            //监听
            Socket client=null;
            try {
                client=server.accept();
                System.out.println("有客户端连接：IP:"+client.getInetAddress().getHostAddress()+" PORT:"+client.getPort());
                //开个线程去处理和客户端的交互
                new ClientHandler(client).start();
            }catch (SocketTimeoutException e){

            }
        }
    }

    private static void initServerConfig(ServerSocket server) throws IOException {
        server.setSoTimeout(5000);
        server.setReuseAddress(true);
        server.setReceiveBufferSize(64*1024*1024);
        server.setPerformancePreferences(1,1,1);
        server.bind(new InetSocketAddress(20000));
    }

    private static ServerSocket createSocket() throws IOException {
        ServerSocket serverSocket=new ServerSocket();
        return serverSocket;
    }

    private static class ClientHandler extends Thread{

        private Socket mClient;
        private boolean flag=true;

        public ClientHandler(Socket socket){
            this.mClient=socket;
        }
        @Override
        public void run() {
            super.run();
            BufferedReader reader=null;
            PrintStream writer=null;
            try {
                //获取输入流 接收客户端的输入 mClient.getInputStream()
                reader=new BufferedReader(new InputStreamReader(mClient.getInputStream()));
                //获取输出流 用于向客户端发送数据 mClient.getOutputStream()
                writer=new PrintStream(mClient.getOutputStream());

                //读取客户端发送到数据
                do {
                    String msg=reader.readLine();
                    System.out.println("Client:"+msg);
                    if (msg.equalsIgnoreCase("bye")){
                        writer.println("bye");
                        flag=false;
                    }else {
                        writer.println("len="+msg.length());
                    }
                }while (flag);
            } catch (IOException e) {
                e.printStackTrace();
            }  finally {
                try {
                    //客户端退出后释放资源
                    reader.close();
                    writer.close();
                    mClient.close();
                    System.out.println("客户端退出");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

