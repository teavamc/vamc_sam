package com.teavamc.vamcsam.practice.demo.xml;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * xml 解析 demo
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.demo.xml
 * @date 2021/1/18 上午11:08
 */
public class XmlDemo {

    public static void main(String[] args) {
        // 输入文件
        String fileUrl = "/Users/zhangchao/Desktop/teavamc_prj/vamc-sam/vamc-sam-practice/src/main/java/com/teavamc/vamcsam/practice/demo/xml/demo.xml";
        String res = readFile(fileUrl);
        Map<String,String> resMap = convertXmlString(res);
        res = JSONObject.toJSONString(resMap);
        System.out.println("转 json : " + res);
    }


    public static String readFile(String strFile){
        String res = null;
        try{
            InputStream is = new FileInputStream(strFile);
            int iAvail = is.available();
            byte[] bytes = new byte[iAvail];
            is.read(bytes);
            System.out.println("文件内容:\n" + new String(bytes));
            res = new String(bytes);
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public static Map<String,String> convertXmlString(String xmlStr){
        if (StringUtils.isBlank(xmlStr)){
            return null;
        }
        Map<String,String> map = new HashMap<>();
        try {
            xmlStr = xmlStr.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            Document doc = DocumentHelper.parseText(xmlStr);
            // 拿到 root 元素
            Element root = doc.getRootElement();
            // 遍历 root 下的元素
            Iterator<Element> iter = root.elementIterator();
            while(iter.hasNext()){
                // Return 节点
                Element tmpElement = (Element) iter.next();
                map.put(tmpElement.getName(),tmpElement.getText());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
