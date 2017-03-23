package eos.java.practice.structure_algorithm.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yanyuyu on 2017/3/23.
 */
public class TimeDifference {
    public static int diff(Date d1, Date d2) {
        int totalDays = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        int day1 = c1.get(Calendar.DAY_OF_YEAR);
        int day2 = c2.get(Calendar.DAY_OF_YEAR);

        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);

        int moreYear = year1 > year2 ? year1 : year2;
        int lessYear = year1 < year2 ? year1 : year2;

        while(lessYear < moreYear) {
            if(lessYear % 400 == 0 || (lessYear % 100 != 0 && lessYear % 4 == 0)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
            lessYear ++;
        }

        if(year1 > year2) {
            totalDays = totalDays - day2 + day1;
        } else if(year1 < year2) {
            totalDays = totalDays - day1 + day2;
        } else {
            totalDays = Math.abs(day2 - day1);
        }
        return totalDays;

    }

    public static void main(String args[]) throws ParseException {
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d1 = sdf.parse("2018-01-31 23:00:00");
        Date d2 = sdf.parse("2017-01-1 01:00:00");
        int diff = TimeDifference.diff(d1, d2);
        System.out.println("两个日期相差："+ diff + "天");
    }



}
