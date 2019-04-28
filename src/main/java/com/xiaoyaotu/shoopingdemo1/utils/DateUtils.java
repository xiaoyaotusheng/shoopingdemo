package com.xiaoyaotu.shoopingdemo1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wazto on 2019/3/21.
 */
public class DateUtils {
    private static Calendar calendar = Calendar.getInstance();
    static SimpleDateFormat sdfall = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat sdfall2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    static SimpleDateFormat sdfall3 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    static SimpleDateFormat sdfday = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat sdfday2 = new SimpleDateFormat("yyyy/MM/dd");
   static  SimpleDateFormat sdfday3 =new SimpleDateFormat("yyyyMMdd");



    public static String getStringByDateForAll(Date data){
       String time=null;
       if(data==null){
           return null;
       }
        time=  sdfall.format(data);
        return  time;
    }

    public static String getStringByDateForAll2(Date data){
        String time=null;
        if(data==null){
            return null;
        }
        time=  sdfall2.format(data);
        return  time;
    }

    public static String getStringByDateForAll3(Date data){
        String time=null;
        if(data==null){
            return null;
        }
        time=  sdfall3.format(data);
        return  time;
    }

    public static String getStringByDateForDay(Date data){
        String time=null;
        if(data==null){
            return null;
        }
        time=  sdfday.format(data);
        return  time;
    }

    public static String getStringByDateForDay2(Date data){
        String time=null;
        if(data==null){
            return null;
        }
        time=  sdfday2.format(data);
        return  time;
    }

    public static String getStringByDateForDay3(Date data){
        String time=null;
        if(data==null){
            return null;
        }
        time=  sdfday3.format(data);
        return  time;
    }




    public static Date getDateByString(String data) {

        Date time = null;
        if (StringUtil.isNull(data))
            return null;
        try {
            time = sdfall.parse(data);
        } catch (ParseException ignored) {
        }
        if (time == null) {
            try {
                time = sdfday.parse(data);
            } catch (ParseException ignored) {
            }
            if (time == null) {
                try {
                    time = sdfall2.parse(data);
                } catch (ParseException ignored) {
                }
                if (time == null) {
                    try {
                        time = sdfall3.parse(data);
                    } catch (ParseException ignored) {
                    }
                    if (time == null) {
                        try {
                            time = sdfday2.parse(data);
                        } catch (ParseException ignored) {
                        }
                    }
                }
            }
        }
        return time;
    }

    public static Date getMonthBegin(Date date) {
        if (date == null)
            return null;
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.print(calendar.getTime());
        return calendar.getTime();
    }

    public static Date getMonthEnd(Date date) {
        if (date == null)
            return null;
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.SECOND, -1);
        System.out.print(calendar.getTime());
        return calendar.getTime();
    }

    public static Date getYearBegin(Date date) {
        if (date == null)
            return null;
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.print(calendar.getTime());
        return calendar.getTime();
    }

    public static Date getYearEnd(Date date) {
        if (date == null)
            return null;
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.SECOND, -1);
        System.out.print(calendar.getTime());
        return calendar.getTime();
    }

    public static int getquarter(Date date) {
        if (date != null)
            calendar.setTime(date);
        else
            calendar.setTime(new Date());
        return (calendar.get(Calendar.MONTH) + 3) / 3;
    }
}
