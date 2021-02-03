package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * 服务端
 */
public class Server {
    private ServerSocket serverSocket;
    //        用于保存所有客户端输出流的数组用于让ClientHandler之间共享输出流广播消息使用
    private PrintWriter[] allOut = {};
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
          while (true){
              System.out.println("等待客户端连接……");
              Socket socket = serverSocket.accept();
              System.out.println("一个客户端连接了");
              Runnable handler = new ClientHandler(socket);
              Thread t = new Thread(handler);
              t.start();
          }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;//当前客户端的IP地址信息

        public ClientHandler(Socket socket){
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress();

        }


        public void run(){
            PrintWriter pw = null;
            try{
                /*
                    Socket提供的方法:
                    InputStream getInputStream()
                    通过socket获取的输入流可以读取远端计算机发送过来的数据
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(
                        in, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                //通过socket获取输出流用于给客户端发消息
                pw = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream(),"utf-8"
                                )
                        ),true
                );

//                将当前对应客户端的输出流存入共享数组allout中 来一个扩容一个
//                数组是存放的输出流
//                不行 每个线程都运行自己的ClientHandler this就是这些ClientHandler
//                synchronized (this)
//                不行 因为同步块中有扩容操作 allout对象指向的数组对象在变化
//                synchronized (allOut)
//                synchronized (serverSocket){
                synchronized (Server.class){
                //1先将allout数组扩容
                allOut = Arrays.copyOf(allOut,allOut.length+1);
                //2将当前pw存入数组最后一个位置
                allOut[allOut.length-1] = pw;
                }
                System.out.println("一个host上线了！当前在线人数："+allOut.length);

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(host+"说" + line);
                    //将消息发送给当前客户端
                    for (int i = 0;i< allOut.length;i++){
                        allOut[i].println(host+"说:"+line);
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                //处理该客户端断开连接后的操作
                synchronized (Server.class) {
                    for (int i = 0; i < allOut.length; i++) {
                        if (pw == allOut[i]) {
                            allOut[i] = allOut[allOut.length - 1];
                            allOut = Arrays.copyOf(allOut, allOut.length - 1);
                            break;
                        }
                    }
                }
                System.out.println(host+"下线了！当前在线人数："+allOut.length);
                try {
                    //最终不再通讯时候要关闭socket
                    //socket关闭以后，要通过socket获取的输入流与输出流就自动关闭了

                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
