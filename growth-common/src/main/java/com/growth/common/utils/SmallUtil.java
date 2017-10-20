package com.growth.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.growth.common.config.AppConfig;




/**
 * 常用工具
 * @author RED SEA
 * @created 2014-10-18 下午8:41:51
 * @version 1.0.0
 */
public class SmallUtil {
    
    private static Logger logger = LoggerFactory.getLogger(SmallUtil.class);
    
    private static String mqServerUrl = null;
    
    public static String getMqServerUrl() {
        if(null == mqServerUrl) {
            String envname = AppConfig.getEvnName().toLowerCase();
            String configPath = "conf/mq/config-"+envname+".properties";
            InputStream ins = SmallUtil.class.getClassLoader().getResourceAsStream(configPath);
            try {
                Properties props = new Properties();
                props.load(ins);
                mqServerUrl = props.getProperty("activemq_url");
            } catch (Exception e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }finally{
                if(null != ins) {
                    try {
                        ins.close();
                    } catch (IOException e) {
                        logger.error(ExceptionUtils.getStackTrace(e));
                    }
                }
            }
        }
        return mqServerUrl;
    }
    
    /**
     * yyyy-MM-dd日期格式的字符串转换为日期
     * @param dateStr
     * @return
     */
    public static Date changeDateStrToDate(String dateStr) {
    	if(null == dateStr || "".equals(dateStr.trim())) {
    		return null;
    	}
    	String[] strs = dateStr.split("-");
    	int year = Integer.parseInt(strs[0]);
		int month = Integer.parseInt(strs[1]);
		int day = Integer.parseInt(strs[2]);
		return SmallUtil.getDateByParams(year, month, day);
    }
    
    /**
     * @param map 键值对参数
     * @param destClass 目标类
     * @return 目标类的实例
     */
    public static Object mapToBean(Map map,Class destClass) {
        Object obj = null;
        try {
           obj = destClass.newInstance();
           List<Field> fields = getAllFields(destClass);
            for(Field field : fields) {
                if(map.containsKey(field.getName())) {
                    BeanUtils.setProperty(obj, field.getName(), map.get(field.getName()));
                }
            }
        } catch (Exception e) {
            logger.info(ExceptionUtils.getStackTrace(e));
        } 
        return obj;
    }
    
    
    
    /**
     * 将bean转换成map，为null，或者空字符串的属性不放到map中
     * @param obj
     * @return
     */
    public static Map<String, Object> transBean2Map(Object obj) {  
    	  
        if(obj == null){  
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);
                    
                    if(value != null) {
                    	boolean isNotEmpty = false;
                    	if (value instanceof String) {
                    		String v = ((String)value).trim();
                    		if (StringUtils.isNotBlank(v)) {
                    			isNotEmpty = true;
                    		}
                    	} else if (value instanceof Integer[]) {
                    		Integer[] v = (Integer[])value;
                    		if (v.length > 0) {
                    			isNotEmpty = true;
                    		}
                    	} else if (value instanceof String[]) {
                    		String[] v = (String[])value;
                    		if (v.length > 0) {
                    			isNotEmpty = true;
                    		}
                    	} else if (value instanceof Long[]) {
                    		Long[] v = (Long[])value;
                    		if (v.length > 0) {
                    			isNotEmpty = true;
                    		}
                    	} else if (value instanceof List) {
                    		List<?> v = (List<?>)value;
                    		if (CollectionUtils.isNotEmpty(v)) {
                    			isNotEmpty = true;
                    		}
                    	} else {
                    		isNotEmpty = true ;
                    	}
                    	if (isNotEmpty) {
                    		map.put(key, value); 
                    	}
                    }
                    
                }  
  
            }  
        } catch (Exception e) {  
        	logger.error("transBean2Map Error " , e );
        }  
  
        return map;  
  
    }  
    
    
    /**
     * 计算dateTwo和dateOne之间的时间差
     * @param dateOne
     * @param dateTwo
     * @return
     */
    public static long getDateDiff(Date dateOne,Date dateTwo) {
    	Calendar one = SmallUtil.getCalendarByDate(dateOne);
    	Calendar two = SmallUtil.getCalendarByDate(dateTwo);
    	return (two.getTimeInMillis() - one.getTimeInMillis())/(1000*3600*24);
    }
    
    //根据年月日得到时间
    public static  Date getDateByParams(int year,int month,int day) {
        Calendar cal = GregorianCalendar.getInstance(Locale.CHINA);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }
    
    //根据calendar得到yyyyMMdd, 如果传null则取当日日期
    public static int getDateIntegerByCalendar(Calendar calendar) {
        if(null == calendar) {
            calendar = GregorianCalendar.getInstance(Locale.CHINA);
        }
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return Integer.valueOf(year+""+(month<10?("0"+month):month)+""+(day<10?("0"+day):day));
    }
    
    //根据date得到yyyyMMdd
    public static int getDateIntegerByDate(Date date) {
    	Calendar cal = getCalendarByDate(date);
        return getDateIntegerByCalendar(cal);
    }
    
    public static Calendar getCalendarByDate(Date date) {
    	if(null == date) {
            date = GregorianCalendar.getInstance(Locale.CHINA).getTime();
        }
        Calendar cal = GregorianCalendar.getInstance(Locale.CHINA);
        cal.setTime(date);
        return cal;
    }
    
    /**
     * 日期目录 yyyy/mm/dd
     * @param date
     * @return
     */
    public static String getDateStrPath(Date date) {
    	Calendar cal = getCalendarByDate(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return "/"+year+"/"+(month<10?("0"+month):month)+"/"+(day<10?("0"+day):day);
    }
    
    /**
     * 根据指定日期得到该日期的显示格式
     * @param date
     * @return
     */
    public static String getDateDispStr(Date date) {
    	Calendar cal = getCalendarByDate(date);
    	int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        StringBuffer sb = new StringBuffer();
        sb.append(year).append("-").append(month).append("-").append(day).append(" ").append(hour).append(":").append(minute).append(":").append(second);
        return sb.toString();
    }
    
    /**
     * 根据给定的日期算出昨日日期,如果calendar为null 则算出当前日的昨日
     * @param 参数说明
     * @return 返回值
     */
    public static int getYesterdayInteger(Calendar calendar) {
        if(null == calendar) {
            calendar = GregorianCalendar.getInstance(Locale.CHINA);
        }
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)-1);
        return getDateIntegerByCalendar(calendar);
    }
    
    /**
     * 返回前days天
     * @param days 需要追溯多少天
     * @return 返回值 yyyyMMdd
     */
    public static int getDayBefore(int days) {
        Calendar calendar = GregorianCalendar.getInstance(Locale.CHINA);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)-days);
        return getDateIntegerByCalendar(calendar);
    }
    
    /**
     * 得到所有Field
     * @param 参数说明
     * @return 返回值
     */
    public static List<Field> getAllFields(Class clazz) {
        Stack<Class> stack = new Stack<Class>();
        while(clazz != Object.class) {
            stack.push(clazz);
            clazz = clazz.getSuperclass();
        }
        List<Field> list = new ArrayList<Field>(); 
        while(!stack.isEmpty()) {
            Class clz = stack.pop();
            Field[] fields = clz.getDeclaredFields();
            for(Field f:fields) {
                list.add(f);
            }
        }
        return list;
    }
    
    //Object转黄成字符串
    public static String ObjToString(Object obj) {
        Map resultMap = new HashMap();
        List<Field> fields = getAllFields(obj.getClass());
        for(Field f:fields) {
            try {
                resultMap.put(f.getName(), BeanUtils.getProperty(obj, f.getName()));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            }
        }
        return obj.getClass().getSimpleName()+":"+ resultMap.toString();
    }

    /**
     * 计算哈希值
     */
    public static int getHashCode(Object obj) {
        Stack<Class> stack = new Stack<Class>();
        Class clazz = obj.getClass();
        while(clazz != Object.class) {
            stack.push(clazz);
            clazz = clazz.getSuperclass();
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            Class clz = stack.pop();
            Field[] fields = clz.getDeclaredFields();
            for(Field f:fields) {
                try {
                    sum += f.get(obj).hashCode()*7;
                } catch (Exception e) {
                    
                }
            }
        }
        return sum;
    }
    
    /**
     * 是否全数字
     * @param 参数说明
     * @return 返回值
     */
    public static boolean isMatchData(String str) {
        String regix = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regix);
        return pattern.matcher(str).matches();
    }
    
    /**
     * 检查非空某个对象是否有非空字段
     * @param 参数说明 params 字段名||空值
     * @return 返回值
     * @throws Exception 
     */
    public static void checkParams(String[] params,Object obj){
        for(String str:params) {
            String[] keyval = str.split("#");
            String key = keyval[0];
            String val = keyval[1];
            try {
                String propertyVal = BeanUtils.getProperty(obj, key);
                if(null == propertyVal || val.equals(propertyVal)) {
                    logger.error(key+"不能为空");
                    throw new RuntimeException("300");
                }
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }
        }
    }
    /**
     * 在录入admin管理员密码时手动调用取出MD5，验证时也调用此方法
     * @param 参数说明
     * @return 返回值
     */
    public static String getMd5(String message) {
        try {
            message += "abcd*（）&……%￥#~！（）&……%￥344998AA*(&^%%#@ASSDDFFEE~!><>?+=_-&*^%$#@!*()";  //干扰串
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] tmp = md.digest(message.getBytes());
            char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                    '9', 'a', 'b', 'c', 'd', 'e', 'f' }; 
                // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
            // 所以表示成 16 进制需要 32 个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
                byte byte0 = tmp[i]; 
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf]; 
            }
            return new String(str); // 换后的结果转换为字符串;
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return null;
        }
    }
    
    public static String getMd5(String plainText ,boolean isEncode)  {
        try{
            
            if(isEncode)
            {
                MessageDigest md = MessageDigest.getInstance("MD5"); 
                md.update(plainText.getBytes()); 
                byte b[] = md.digest(); 

                int i; 

                StringBuffer buf = new StringBuffer(""); 
                for (int offset = 0; offset < b.length; offset++) { 
                i = b[offset]; 
                if(i<0) i+= 256; 
                if(i<16) 
                buf.append("0"); 
                buf.append(Integer.toHexString(i)); 
                } 

//                System.out.println("result: " + buf.toString());//32位的加密 

//                System.out.println("result: " + buf.toString().substring(8,24));//16位的加密 
                plainText =  buf.toString() ;
            }
        }    catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return null;
        }
            
            return plainText ;
    }
    
    /**
     * request 的 param塞到request的attribute
     * @param request
     */
    public static void setRequestParamsToAttribute(HttpServletRequest request) {
    	Enumeration enums = request.getParameterNames();
    	while(enums.hasMoreElements()) {
    		String key = enums.nextElement().toString();
    		request.setAttribute(key, request.getParameter(key));
    	}
    }
    
    /**
     * 算出总页数
     * @param rows
     * @param pageSize
     * @return
     */
    public static Long getPageCountByRows(Long rows,int pageSize) {
    	if(0 == rows) {
    		return 0L;
    	}
    	if(rows < pageSize) {
    		return 1L;
    	}
    	if(rows%pageSize == 0) {
    		return rows/pageSize;
    	}
    	return rows/pageSize + 1;
    }

    public static void main(String[] args) {
        System.out.println(getMd5("1",true));
    }
    
}
