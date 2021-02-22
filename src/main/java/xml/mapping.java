package xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mapping {
    public static void main(String[] args) {
       Map<String ,String> mimeMapping = new HashMap<>();
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read("./config/web.xml");
            Element root = doc.getRootElement();
            System.out.println("根标签的名字："+root);
            List<Element> list = root.elements("mime-mapping");
            System.out.println("共有"+list.size()+"mime-mapping标签");

            /**
             *  <extension>中间的文本作为key
             *      <mime-type>中间的文本作为value
             *      存入mimeMapping这个Map完成初始化，初始化后mimeMapping应该有1011个元素
             */
            for (Element emple:list){
                String key = emple.elementText("extension");
                String value = emple.elementText("mime-type");
                mimeMapping.put(key,value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
