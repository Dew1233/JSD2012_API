package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //在当前目录下新建一个文件test.txt
        File file = new File("./test.txt");
        /*
        boolean exists()
         */
        if(file.exists()){
            System.out.println("该文件已存在");
        }else{
            file.createNewFile();
            System.out.println("文件已经创建");
        }

    }
}
