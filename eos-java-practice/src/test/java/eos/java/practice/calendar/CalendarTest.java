package eos.java.practice.calendar;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Mr_yyy on 2017/3/26.
 */
public class CalendarTest {
    /**
     * 月份0~11
     */
    @Test
    public void testMonth() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" +c.get(Calendar.DATE));
        c.set(Calendar.MONTH, 3);
        System.out.println(c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" +c.get(Calendar.DATE));
        c.set(Calendar.MONTH, -1);
        System.out.println(c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" +c.get(Calendar.DATE));
        c.add(Calendar.MONTH, 4);
        System.out.println(c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" +c.get(Calendar.DATE));
    }

    /**
     * DayOfWeek: 1~7   1(星期七) 7(星期六)
     */
    @Test
    public void testDayOfWeek() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
    }

    @Test
    public void testDayOfMonth() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 返回当前日期是本月的第几周内
     */
    @Test
    public void testDayOfWeekInMonth() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
    }

    /**
     * DAY_OF_MONTH 
     * DAY_OF_YEAR
     */
    @Test
    public void testDay_MonthOrYear() {
        Calendar c = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i < 50; i ++) {
            //c.add(Calendar.DAY_OF_MONTH, 1);
            c.add(Calendar.DAY_OF_YEAR, 1);
            System.out.println(df.format(c.getTime()));
        }
    }
}
