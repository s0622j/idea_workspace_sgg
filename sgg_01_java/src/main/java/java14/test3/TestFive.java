package java14.test3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestFive {
    public static void main(String[] args) {
        // jdk1.8之后的日期处理
        LocalDate localDate = LocalDate.now();// 没有时间的日期格式
        System.out.println(localDate);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getMonth().getValue());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfMonth());
        System.out.println("--------------------------------------------");
        LocalTime localTime = LocalTime.now();// 没有日期的时间格式
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());
        System.out.println("-----------------------------------------------");
        LocalDateTime localDateTime = LocalDateTime.now();// 日期和时间格式
        System.out.println(localDateTime);
    }
}
