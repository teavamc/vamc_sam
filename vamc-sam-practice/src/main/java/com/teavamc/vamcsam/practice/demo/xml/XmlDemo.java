package com.teavamc.vamcsam.practice.demo.xml;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * xml 解析 demo
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.demo.xml
 * @date 2021/1/18 上午11:08
 */
public class XmlDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 输入文件
        String fileUrl = "/Users/zhangchao/Desktop/teavamc_prj/vamc-sam/vamc-sam-practice/src/main/java/com/teavamc/vamcsam/practice/demo/xml/demo.xml";
        String res = readFile2(fileUrl);
//        String res = readFile(fileUrl);
//        res = XmlConvertUtils.getUTF8StringFromGBKString(res);
//        res = new String(res.getBytes("UTF-8"), "UTF-8");
        try{
            JSONObject object = XmlConvertUtils.xml2Json(res);
            System.out.println("转 json : " + object.toJSONString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test_1(){
        Map<String,String> map = new HashMap<>();
        map.put("AGSERVERHEAD_CHANNEL","KF");
        map.put("AGSERVERHEAD_FORMATTYPE","X");
        String request_pre = JSONObject.toJSONString(map);
        System.out.println("1----" + request_pre);
        Document document = DocumentHelper.createDocument();
        //默认根节点
        Element root =  document.addElement("ROOT");
        try {
            Element el = XmlConvertUtils.jsonToXml(request_pre, root);
            String xml_str = el.asXML();
            xml_str = "<?xml version=\"1.0\" encoding=\"gbk\"?>" + xml_str;
            System.out.println("2----" + xml_str);
//            System.out.println("3----" + XmlConvertUtils.json2xml(JSONObject.parseObject(request_pre)));
            // 再转成JSON字符串
            System.out.println("3----" + XmlConvertUtils.xml2JsonStr(xml_str));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static String readFile2(String strFile){
        StringBuilder result = new StringBuilder();
        try{
            InputStream is = new FileInputStream(strFile);
            //一定要在这个地方才不会乱码(utf-8,gb2312)
            InputStreamReader isr = new InputStreamReader(is, "gbk");
            BufferedReader br = new BufferedReader(isr);
            String temp;
            while((temp = br.readLine()) != null)
            {
                result.append(temp);
            }
            System.out.println("文件内容:\n" + new String(result));
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
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

    public static void GBK2UTF8(File file) throws IOException {
        //创建转换流对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"GBK");
        //创建集合保存读取的数据
        LinkedHashMap<char[],Integer> map = new LinkedHashMap<char[], Integer>();
        //读取文件,并存储
        char[] chs = new char[1024];
        int len = 0;
        while ((len = isr.read(chs))!=-1){
            map.put(chs,len);
        }
        //释放资源
        isr.close();

        //创建转换输出流,清空文件，重新写入
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream(file),"UTF-8");
        Set<char[]> set = map.keySet();
        for (char[] chars : set) {
            Integer length = map.get(chars);
            osw.write(chars,0,length);
        }
        //释放资源
        osw.close();
    }

    public String resposeString(String urlStr){
        String result = "";
        try
        {
            URL url = new URL(urlStr);
            HttpURLConnection httpURLConnection = null;
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);//上传数据
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            InputStream inputStream = httpURLConnection.getInputStream();//获取返回的数据流
            InputStreamReader isr = new InputStreamReader(inputStream, "gbk");//一定要在这个地方才不会乱码(utf-8,gb2312)
            BufferedReader br = new BufferedReader(isr);//利用BufferedReader将流转为String
            String temp;
            while((temp = br.readLine()) != null)
            {
                result = result + temp;
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
