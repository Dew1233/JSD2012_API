package file;

import java.io.File;

/**
 * 创建一个多级目录
 * mkdir()的前提为当前最后一个文件之前的目录已经存在哦！不然创建不成功
 * mkdirs()会将当前目录之前都一下子创建成功
 */

public class MkDirsDemo {
    public static void main(String[] args) {
        //在当前目录下新建目录a/b/c/d/e/f
        File dir = new File("./a/b/c/d/e/f");
        if(dir.exists()){
            System.out.println("该目录已经存在");
        }else{
            dir.mkdirs();
            System.out.println("目录已经创建");
        }
    }
}
