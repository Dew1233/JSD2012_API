package homework.day12;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

/**
 * 浏览器发送过来的请求内容每个字符单独读取出来并输出到控制台
 * @author Xiloer
 *
 */
public class Test02 {
	private ServerSocket serverSocket;
	public Test02(){
		try {
            /*
            http://localhost:8088/
             */
			System.out.println("正在启动服务端");
			serverSocket = new ServerSocket(8088);
			System.out.println("服务端启动完毕！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void start(){
		try {
			System.out.println("等待客户端连接……");
			Socket socket = serverSocket.accept();
			System.out.println("一个客户端连接了！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	public static void main(String[] args) {
		Test02 server = new Test02();
		server.start();
	}

}
