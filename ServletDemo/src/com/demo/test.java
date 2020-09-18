package com.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) throws ParseException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy:MM:dd hh:mm:ss");
//        Date dateStart = simpleDateFormat.parse("2020:06:06 22:10:00");
//        Date dateEnd = simpleDateFormat.parse("2020:06:06 22:10:30");
//        System.out.println(dateStart.getTime());
//        System.out.println(dateEnd.getTime());
        Date date1 = new Date(1591452600000L);
        Date date2 = new Date(1591452630000L);
        while (true){
            Thread.sleep(1000);
            Date nowdate = new Date();
            if (nowdate.after(date1) && nowdate.before(date2)){
                System.out.println("正常进入时间区间，此时时间为" + nowdate.toString());
            }else{
                System.out.println("还未进入时间区间");
            }
        }
    }
}
