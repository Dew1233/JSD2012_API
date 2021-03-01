package log4j;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JULTest {
    @Test
    public void testQuick(){
        //1获取日志记录器对象
        Logger logger = Logger.getLogger("com.JSD2012.JULTest");
        //2日志记录输出
        logger.info("hello jul");

        //通用方法进行日志记录
        logger.log(Level.INFO,"info msg");

        //通过占位符方式输出变量名
        String name = "yegol";
        Integer age = 13;
        logger.log(Level.INFO,"用户信息:{0},{1}",new Object[]{name,age});


    }
    //日志级别
    @Test
    public void testLogLevel(){
        Logger logger = Logger.getLogger("com.JSD2012.JULTest");
//        日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }
}
