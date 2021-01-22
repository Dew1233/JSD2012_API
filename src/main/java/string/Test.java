package string;

public class Test {
    public static void main(String[] args) {
        String s1 = getHostName("www.tedu.cn");
        String s2 = getHostName("http.tarena.cn");
        String s3 = getHostName("doc.canglaoshi.com.cn");

        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);
        System.out.println("s3:"+s3);
    }

    /**
     * 获取给定网址中的域名(地址中第一个“."到第二个”.")
     * @param adress
     * @return
     */
    public static String getHostName(String adress){


        int index1  = adress.indexOf(".")+1;//检索第一次出现in的位置
        //地址中第二个”."出现的位置 从出现第一个点的下标开始再找
        int index2 = adress.indexOf(".",index1+1);
        return adress.substring(index1, index2);

    }
}
