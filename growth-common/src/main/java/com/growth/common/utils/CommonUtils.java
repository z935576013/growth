package com.growth.common.utils;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonUtils {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
    
    public static final Map<String, String> getParamaterMap(String data) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        Enumeration<String> paramNames = request.getParameterNames();
        Map<String, String> params = new TreeMap<String, String>();
        StringBuilder sb = new StringBuilder();
        sb.append(data+":");
        while (paramNames != null && paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] values = request.getParameterValues(paramName);
            if (values == null || values.length == 0) {
                // Do nothing, no values found at all.
            } else {
                params.put(paramName, values[0]);
                sb.append(paramName+"="+values[0]+",");
            }
        }
        logger.debug(sb.toString());
        return params;
    }

    public static final String cutOutString(String str, int length) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (str.length() <= length) {
            return str;
        }
        return str.substring(0, length);
    }

    public static final GenericResult<Long> getLongValue(String s) {
        GenericResult<Long> result = new GenericResult<Long>();
        try {
            result.setObject(Long.valueOf(s));
        } catch (NumberFormatException e) {
            result.fail("NumberFormatError", "字符转换成Long类型出错");
        }
        return result;
    }

    public static final List<String>  convertStringToList(String splitString){
        if(StringUtils.isEmpty(splitString)){
            return null;
        }
        String [] arr = splitString.split(";");
        return Arrays.asList(arr);
    }
     
    public static final GenericResult<Integer> getIntegerValue(String s) {
        GenericResult<Integer> result = new GenericResult<Integer>();
        try {
            result.setObject(Integer.valueOf(s));
        } catch (NumberFormatException e) {
            result.fail("NumberFormatError", "字符转换成Integer类型出错");
        }
        return result;
    }

    public static final String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static final String convertToJson(Object object) {
        return JSON.toJSONString(object);
    }
    
//    public static final String convertToJson(Map map) {
//        StringBuffer sb = new StringBuffer("{");
//        Set es = map.entrySet();
//        Iterator it = es.iterator();
//        while (it.hasNext()) {
//            Map.Entry entry = (Map.Entry) it.next();
//            String k = (String) entry.getKey();
//            String v = (String) entry.getValue();
//            if (null != v && !"".equals(v) && !"appkey".equals(k)) {
//                sb.append("\"" + k + "\":\"" + v + "\",");
//            }
//        }
//        String params = sb.substring(0, sb.lastIndexOf(","));
//        params += "}";
//        return params;
//    }
    
    public static final Map<String,String> convertToMap(String json){
        return JSON.parseObject(json, HashMap.class);
    }
    
    
    public static final Map<String,String> convertResponseToMap(String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Map<String,String> datas = new HashMap<String,String>();
        datas.put("errcode", jsonObject.getString("errcode"));
        datas.put("prepayid", jsonObject.getString("prepayid"));
        datas.put("errmsg", jsonObject.getString("errmsg"));
        return datas;
    }
    
    public static final Map<String,String> convertDeliverResponseToMap(String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Map<String,String> datas = new HashMap<String,String>();
        datas.put("errcode", jsonObject.getString("errcode"));
        return datas;
    }
    
    public static final Map<String,String> convertTokenResponseToMap(String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Map<String,String> datas = new HashMap<String,String>();
        datas.put("access_token", jsonObject.getString("access_token"));
        datas.put("expires_in", jsonObject.getString("expires_in"));
        return datas;
    }
    
    public static final Map<String,Object> convertToResultMap(String json){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(json, HashMap.class);
    }
    
    public static final <T> T convertToClass(String json, Class<T> clazz){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(json, clazz);
    }
    
    
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
    // gson转换
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final Gson GSON = new GsonBuilder().setDateFormat(DATE_FORMAT).enableComplexMapKeySerialization()
            .create();
}
