package com.growth.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections4.MapUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(XmlUtils.class);
    
    public static final Map<String,String>  convertXMLToMap(InputStream inputStream){
        Map<String,String> datas = new HashMap<String, String>();
        try {
           SAXReader reader = new SAXReader();
           Document document = reader.read(inputStream);
           logger.debug("解析的xml报文为:{}",document.asXML());
           Element root = document.getRootElement();
           for (Iterator i = root.elementIterator(); i.hasNext(); ) {
               Element element = (Element) i.next();
               datas.put(element.getName(), element.getStringValue());
            }
       } catch (DocumentException e) {
           throw new RuntimeException(e);
       }
        return datas;
    }
 
    
    public static final Map<String,String>  convertXMLToMap(String xml){
        Map<String,String> datas = new HashMap<String, String>();
        try {
           Document document = DocumentHelper.parseText(xml);
           Element root = document.getRootElement();
           for (Iterator i = root.elementIterator(); i.hasNext(); ) {
               Element element = (Element) i.next();
               datas.put(element.getName(), element.getStringValue());
            }
       } catch (DocumentException e) {
           throw new RuntimeException(e);
       }
        return datas;
    }
    
    public static final TreeMap<String,String>  convertXMLToTreeMap(String xml){
        TreeMap<String,String> datas = new TreeMap<String, String>();
        try {
           Document document = DocumentHelper.parseText(xml);
           Element root = document.getRootElement();
           for (Iterator i = root.elementIterator(); i.hasNext(); ) {
               Element element = (Element) i.next();
               datas.put(element.getName(), element.getStringValue());
            }
       } catch (DocumentException e) {
           throw new RuntimeException(e);
       }
        return datas;
    }
    public static final String convertMapToXML(Map<String,String> datas,String rootName){
        if(MapUtils.isEmpty(datas)){
            return null;
        }
        Document doc = DocumentHelper.createDocument();
        doc.setXMLEncoding("UTF-8");
        Element root = doc.addElement(rootName == null ? "xml" : rootName);
        Element element = null;
        for(Map.Entry<String, String> entry : datas.entrySet()){
            element = root.addElement(entry.getKey());
            element.addText(entry.getValue());
            //element.addText("<![CDATA["+entry.getValue()+"]]");
        }
        return formatXml(doc,"UTF-8",false);
    }
    
    
    public static String formatXml(Document document, String charset, boolean istrans) {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(charset);
//        format.setIndentSize(2);
//        format.setNewlines(true);
//        format.setTrimText(false);
//        format.setPadText(true);
//        以上4行用于处理base64图片编码以后放入xml时的回车变空格问题
        StringWriter sw = new StringWriter();
        XMLWriter xw = new XMLWriter(sw, format);
        xw.setEscapeText(istrans);
        try {
            xw.write(document);
            xw.flush();
            xw.close();
        } catch (IOException e) {
        }
        return sw.toString();
    }
}
