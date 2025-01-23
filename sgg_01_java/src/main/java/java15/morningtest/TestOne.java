package java15.morningtest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestOne {
    public static void main(String[] args) {
        // JDK1.8之前处理日期
        Date date = new Date();
        System.out.println(date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(date);
        System.out.println(strDate);
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        cal.add(Calendar.YEAR,-10);
        Date date1 = cal.getTime();
        String strDate1 = sdf.format(date1);
        System.out.println(strDate1);
    }
}
