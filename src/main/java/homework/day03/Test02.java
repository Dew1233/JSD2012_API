package homework.day03;

import java.io.File;
import java.io.FileFilter;

/**
 * 列出当前目录中所有名字包含s的子项。
 *
 * 使用匿名内部类和lambda两种写法
 *
 * 单词记一记:
 * FileFilter   文件过滤器
 * accept       接受
 *
 *
 */
public class Test02 {
    public static void main(String[] args) {

        File dir = new File(".");
        //使用匿名内部类
        /*FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return name.contains("s");
            }
        };

        File[] subs = dir.listFiles(filter);*/
        //        lambda写法

        FileFilter filter1 = (file)-> file.getName().contains("s");
        File[] subs = dir.listFiles(filter1);

        System.out.println(filter1);
        System.out.println("子项个数"+subs.length);
        for(int i =0 ;i<subs.length;i++){
            System.out.println(subs[i].getName());
        }


    }
}
