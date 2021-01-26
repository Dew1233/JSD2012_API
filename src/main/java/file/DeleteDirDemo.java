package file;

import java.io.File;

public class DeleteDirDemo {
    public static void main(String[] args) {
        //将当前目录下的xdemo目录删除
        File dir = new File("./xdemo");
        if(dir.exists()){
            //delete方法删除目录时要求该目录必须是一个空目录才可以
            dir.delete();
            System.out.println("目录已经删除");
        }else{
            System.out.println("目录不存在");
        }

    }
}
