package com.teavamc.vamcsam.practice.demo.xml;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.dom4j.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.demo.xml
 * @date 2021/1/20 上午9:52
 */
public class XmlConvertUtils {

    /**
     * UTF-8 转 GBK
     * @param utf8Str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getGBKStringFromUTF8String(String utf8Str) throws UnsupportedEncodingException {
        return new String(utf8Str.getBytes("GBK"),"GBK");
    }

    /**
     * GBK 转 UTF-8 字符串
     * @param gbkStr
     * @return
     */
    public static String getUTF8StringFromGBKString(String gbkStr){
        byte[] utf8Byte = getUTF8BytesFromGBKString(gbkStr);
        return new String(utf8Byte, StandardCharsets.UTF_8);
    }

    /**
     * 将 gbk 转 utf8
     * @param gbkStr
     * @return
     */
    public static String getUTF8StringFromGBKString_V2(String gbkStr){
        StringBuilder sb = new StringBuilder();
        try{
            InputStream is = new ByteArrayInputStream(gbkStr.getBytes());
            InputStreamReader isr = new InputStreamReader(is, "gbk");
            BufferedReader br = new BufferedReader(isr);
            String temp;
            while((temp = br.readLine()) != null)
            {
                sb.append(temp);
            }
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
        int n = gbkStr.length();
        byte[] utfBytes = new byte[3 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int m = gbkStr.charAt(i);
            if (m < 128 && m >= 0) {
                utfBytes[k++] = (byte) m;
                continue;
            }
            utfBytes[k++] = (byte) (0xe0 | (m >> 12));
            utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
            utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
        }
        if (k < utfBytes.length) {
            byte[] tmp = new byte[k];
            System.arraycopy(utfBytes, 0, tmp, 0, k);
            return tmp;
        }
        return utfBytes;
    }


    /**
     * xml 转 json 字符串
     * @param xmlStr
     * @return
     * @throws DocumentException
     */
    public static String xml2JsonStr(String xmlStr) throws DocumentException {
        return xml2Json(xmlStr).toJSONString();
    }

    /**
     * xml转json
     * @param xmlStr
     * @return
     * @throws DocumentException
     */
    public static JSONObject xml2Json(String xmlStr) throws DocumentException {
        Document doc= DocumentHelper.parseText(xmlStr);
        JSONObject json=new JSONObject();
        dom4j2Json(doc.getRootElement(), json);
        return json;
    }

    /**
     * xml转json
     * @param element
     * @param json
     */
    public static void dom4j2Json(Element element, JSONObject json){
        //如果是属性
        for(Object o:element.attributes()){
            Attribute attr=(Attribute)o;
            if(!isEmpty(attr.getValue())){
                json.put("@"+attr.getName(), attr.getValue());
            }
        }
        List<Element> chdEl=element.elements();
        if(chdEl.isEmpty()&&!isEmpty(element.getText())){//如果没有子元素,只有一个值
            json.put(element.getName(), element.getText());
        }
        for(Element e:chdEl){//有子元素
            if(!e.elements().isEmpty()){//子元素也有子元素
                JSONObject chdjson=new JSONObject();
                dom4j2Json(e,chdjson);
                Object o=json.get(e.getName());
                if(o!=null){
                    JSONArray jsona=null;
                    if(o instanceof JSONObject){//如果此元素已存在,则转为jsonArray
                        JSONObject jsono=(JSONObject)o;
                        json.remove(e.getName());
                        jsona=new JSONArray();
                        jsona.add(jsono);
                        jsona.add(chdjson);
                    }
                    if(o instanceof JSONArray){
                        jsona=(JSONArray)o;
                        jsona.add(chdjson);
                    }
                    json.put(e.getName(), jsona);
                }else{
                    if(!chdjson.isEmpty()){
                        json.put(e.getName(), chdjson);
                    }
                }
            }else{//子元素没有子元素
                for(Object o:element.attributes()){
                    Attribute attr=(Attribute)o;
                    if(!isEmpty(attr.getValue())){
                        json.put("@"+attr.getName(), attr.getValue());
                    }
                }
                if(!e.getText().isEmpty()){
                    json.put(e.getName(), e.getText());
                }
            }
        }
    }

    /**
     * 将json字符串转换成xml
     *
     * @param json
     *            json字符串
     * @param parentElement
     *            xml根节点
     * @throws Exception
     */
    public static Element jsonToXml(String json, Element parentElement) throws Exception {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        return toXml(jsonObject, parentElement, null);
    }

    /**
     * 将json字符串转换成xml
     *
     * @param jsonElement
     *            待解析json对象元素
     * @param parentElement
     *            上一层xml的dom对象
     * @param name
     *            父节点
     */
    private static Element toXml(JsonElement jsonElement, Element parentElement, String name) {
        if (jsonElement instanceof JsonArray) {
            //是json数据，需继续解析
            JsonArray sonJsonArray = (JsonArray)jsonElement;
            for (int i = 0; i < sonJsonArray.size(); i++) {
                JsonElement arrayElement = sonJsonArray.get(i);
                toXml(arrayElement, parentElement, name);
            }
        }else if (jsonElement instanceof JsonObject) {
            //说明是一个json对象字符串，需要继续解析
            JsonObject sonJsonObject = (JsonObject) jsonElement;
            Element currentElement = null;
            if (name != null) {
                currentElement = parentElement.addElement(name);
            }
            Set<Map.Entry<String, JsonElement>> set = sonJsonObject.entrySet();
            for (Map.Entry<String, JsonElement> s : set) {
                toXml(s.getValue(), currentElement != null ? currentElement : parentElement, s.getKey());
            }
        } else {
            //说明是一个键值对的key,可以作为节点插入了
            addAttribute(parentElement, name, jsonElement.getAsString());
        }
        return parentElement;
    }

    /**
     *
     * @param element  	父节点
     * @param name		子节点的名字
     * @param value		子节点的值
     */
    public static void addAttribute(Element element, String name, String value) {
        //增加子节点，并为子节点赋值
        Element el = element.addElement(name);
        el.addText(value);
    }


    public static boolean isEmpty(String str) {
        if (str == null || str.trim().isEmpty() || "null".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 简单实现版本
     * @param jsonObj
     * @return
     */
    public static String json2xml(JSONObject jsonObj) {
        StringBuffer buff = new StringBuffer();
        JSONObject tempObj = null;
        JSONArray tempArr = null;
        for (String temp : jsonObj.keySet()) {
            buff.append("<" + temp.trim() + ">");
            jsonObj.get(temp);
            if (jsonObj.get(temp) instanceof JSONObject) {
                tempObj = (JSONObject) jsonObj.get(temp);
                buff.append(json2xml(tempObj));
            } else if (jsonObj.get(temp) instanceof JSONArray) {
                tempArr = (JSONArray) jsonObj.get(temp);
                if (tempArr.size() > 0) {
                    for (int i = 0; i < tempArr.size(); i++) {
                        tempObj = (JSONObject) tempArr.get(0);
                        buff.append(json2xml(tempObj));
                    }
                }
            } else {
                String tempStr = jsonObj.get(temp).toString();
                buff.append(tempStr.trim());
            }
            buff.append("</" + temp.trim() + ">");
        }
        return buff.toString();
    }

}
