package com.app.pilotes.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
@Component
public class DateUtils {

    public static Timestamp newTimeStamp(){
        return new Timestamp(new Date().getTime());
    }

    public static Timestamp fiveMinutesTime(){
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());
        cal.add(Calendar.SECOND, -600);
        return new Timestamp(cal.getTime().getTime());
    }
}