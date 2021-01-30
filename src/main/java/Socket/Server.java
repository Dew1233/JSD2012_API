package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class Server {
    private ServerSocket serverSocket;
    /*
    java.net.ServerScoket
    ServerSocket是运行在服务端的。它主要有两个作用
    1向系统申请并打开服务端口，客户端可以通过这个端口与服务端建立连接
    2监听服务端口 一旦一个客户端通过该端口与服务端建立连接则会创建一个
    Socket，通过它与客户端进行交互。

    如果把Socket比喻为电话，那么ServerSocket就相当于总机
     */
    public Server(){
        try{
            /*
            实例化ServerSocket是指定服务端口 如果该端口
            被占用会发生异常

             */
            System.out.println("正在启动服务端");
            serverSocket = new ServerSocket(8088);
            System.out.println("启动服务端完毕");


        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void start(){
        try{
            /*
            ServerSocket提供的方法：
            Socket accept()
            该方法是一个阻塞方法，调用后程序就卡住了 此时开始等待客户
            连接 一旦一个客户端建立连接 此时accept方法就会
            立即返回一个Socket实例，通过这个Socket就可以与连接的客户端进行交互
             */
            System.out.println("等待客户端连接");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(),"utf-8"
                    )
            );
            /*String msg = br.readLine();
            System.out.println("客户端说："+msg);*/
            while (true){
                String msg = br.readLine();
                System.out.println(msg);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
