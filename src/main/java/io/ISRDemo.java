package io;

import java.io.*;

public class ISRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis =
                new FileInputStream("osw.txt");
        InputStreamReader isr =
                new InputStreamReader(fis,"utf-8");
        int d;
        /*
        int read()
        字符流的read()
         */
        while ((d=isr.read())!=-1){
            System.out.println((char)d);
        }
        isr.close();
    }
}
