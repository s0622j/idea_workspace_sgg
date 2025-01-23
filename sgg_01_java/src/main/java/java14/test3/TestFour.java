package java14.test3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestFour {
    public static void main(String[] args) {
        // jdk1.8之前的日期处理
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(date);
        System.out.println(strDate);
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        cal.add(Calendar.HOUR_OF_DAY,-1000);
        System.out.println(cal);
        Date date1 = cal.getTime();
        String strDate1 = sdf.format(date1);
        System.out.println(strDate1);
    }
}
