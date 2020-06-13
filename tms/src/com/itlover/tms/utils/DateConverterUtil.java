package com.itlover.tms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该类为日期的转换工具
 */
public class DateConverterUtil {

    public static String DateToString(Date date,String pattern){
        if(date == null || pattern == null || "".equals(pattern)){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);// yyyy-MM-dd HH:mm
        return simpleDateFormat.format(date);
    }

    public static Date StringToDate(String dateStr,String pattern){
        if(dateStr == null || pattern == null || "".equals(dateStr) || "".equals(pattern)){
            return null;
        }
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);// yyyy-MM-dd HH:mm
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {
        String string = DateConverterUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm");
        System.out.println(string);
        Date date = DateConverterUtil.StringToDate(string, "yyyy-MM-dd HH:mm");
        System.out.println(date);
    }
}
