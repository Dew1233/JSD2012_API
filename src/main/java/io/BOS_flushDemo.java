package io;

import java.io.*;

/**
 * 使用缓冲输入流写出数据的缓冲区问题
 */
public class BOS_flushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos
                = new FileOutputStream("bos.txt");
        BufferedOutputStream bos
                 = new BufferedOutputStream(fos);
        String line = "在拿ash东方航空法实施";
         byte [] data = line.getBytes("utf-8");
         bos.write(data);
         /*
         void flush()
         将缓冲流中已经缓存的数据一次性写出
         频繁的调用flush会增加实际写出数据的次数，写出次数多
         则写效率差，但是可以提高写出数据的即时性。
          */
         bos.flush();
        System.out.println("完毕");
        /*
        缓冲流的close方法中会执行一次flush
         */
        bos.close();
    }
}
