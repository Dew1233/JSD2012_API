package homework.day01;

/**
 *实现方法,完成获取下列文件名中的后缀名
 * ext 这里是单词extension的前三个字母，这里指"后缀"的意思。
 * 注:开发中当一个单词作为标识符命名比较长时，可以用类似方式简写
 */
public class Test01 {
    public static void main(String[] args) {
        String fileName1 = "logo.png";
        String fileName2 = "jquert.1.1.2.js";

        String ext = getExtByName(fileName1);
        System.out.println(ext);
        ext = getExtByName(fileName2);
        System.out.println(ext);
    }

    /**
     * 获取给定文件名中的后缀名部分
     * @param name	文件名
     * @return
     *
     */
    public static String getExtByName(String name){
        //找到最后一个点的位置
        int last = name.lastIndexOf(".");

        return name.substring(last+1);
    }

}
