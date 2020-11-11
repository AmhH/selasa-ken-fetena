package com.example.leet.mki;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

public class CalenderTest{

    public static void main(String[] args) {
        Date aDate = null;
        try {
            aDate = new SimpleDateFormat("yyy-mm-dd").parse("2012-01-15");
            Calendar aCalender = Calendar.getInstance();

            aCalender.setTime(aDate);
            System.out.println(aCalender.get(Calendar.DAY_OF_MONTH)  + ", " + aCalender.get(Calendar.MONTH));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate bDate = LocalDate.parse("2012-01-15", formatter);
            System.out.println(bDate.getDayOfMonth() + ", " + bDate.getMonthValue());
        }catch (ParseException ex){
            System.out.println("ParseException " + ex);
        }catch (DateTimeParseException ex){
            System.out.println("DateTimeParseException " + ex);
        }
    }
}