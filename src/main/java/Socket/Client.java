package Socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    private Socket socket;

    /**
     * 构造方法，用来初始化客户端
     */
    public Client(){
       try {
           /*
           java.net.Socket 套接字
           Socket封装了Tcp协议的通讯细节 使用它可以和远端计算建立连接
           并通过它获取一个输入流一个输出流 使用这两个流的读写数据完成
           与远端计算机的交互

           实例化Socket时需要传入两个参数：
           1.服务端的地址信息（IP地址）
             用过地址可以找到网络上服务端的计算
           2.服务端打开的服务端口
             通过这个端口可以找到服务端计算机运行的服务端应用程序
            */
           System.out.println("正在连接服务端……");
//           176.212.28.201   176.212.28.215
           socket = new Socket("176.212.28.201",8088);
           System.out.println("与服务端建立连接！");
       }catch (IOException e){
           e.printStackTrace();
       }
    }

    /**
     * 客户端开始工作的方法
     */
    public void start(){
        //先启动读取服务端发送过来消息的线程
        ServerHandler handler = new ServerHandler();
        Thread t = new Thread(handler);
        t.setDaemon(true);
        t.start();
        try(
                PrintWriter pw = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream(),"utf-8"
                                )
                        ),true
                );

                ) {
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入文字，输入exit为退出");
            while (true){
                String line = scan.nextLine();
                if("exit".equals(line)){
                    break;
                }
                pw.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        client.start();
    }
    //该线程负责读取服务端发送过来的消息
    private class ServerHandler implements Runnable{
        public void run(){
            try(   BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(),"utf-8"
                    )
                    );
            ){
                String line ;
                //读取服务端发送过来的每一行字符串并输出到客户端的控制台
                while ((line = br.readLine())!=null){
                    System.out.println(line);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
