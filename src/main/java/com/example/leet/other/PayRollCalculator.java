package com.example.leet.other;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PayRollCalculator {

    private final static LocalTime OFFICIAL_START = LocalTime.of(17, 00);
    private final static LocalTime OFFICIAL_END = LocalTime.of(4, 00);

    public static void main(String[] args) {
        System.out.println(payCalculator("05:00 PM", "04:00 AM", "09:00 PM"));//136
        System.out.println(payCalculator("04:00 PM", "04:00 AM", "09:00 PM"));//136
        System.out.println(payCalculator("06:00 PM", "06:00 AM", "09:00 PM"));//124
        System.out.println(payCalculator("06:00 PM", "11:00 PM", "09:00 PM"));//52
        System.out.println(payCalculator("06:00 PM", "09:00 PM", "09:00 PM"));//36
        System.out.println(payCalculator("06:00 PM", "08:00 PM", "09:00 PM"));//24
        System.out.println(payCalculator("06:00 PM", "01:00 AM", "09:00 PM"));//76
        System.out.println(payCalculator("06:00 PM", "12:00 AM", "09:00 PM"));//60
    }

    public static String payCalculator(String startTime, String endTime, String bedTime) {
        LocalTime start = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("hh:mm a"));
        LocalTime end = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("hh:mm a"));
        LocalTime bed = LocalTime.parse(bedTime, DateTimeFormatter.ofPattern("hh:mm a"));

        if (start.isBefore(OFFICIAL_START)) {
            System.out.println(" Start Time is before 5 PM adjusting to 5 PM");
            start = OFFICIAL_START;
        }

        if (end.isAfter(OFFICIAL_END) && end.isBefore(OFFICIAL_START)) {
            System.out.println("End Time is after 4 PM adjusting to 4 AM");
            end = OFFICIAL_END;
        }

        double total = 0.0;
        if((OFFICIAL_END.isBefore(end) && end.isBefore(bed)) || end.equals(bed)){
            return String.format("$%.2f", 12 * Math.ceil(ChronoUnit.MINUTES.between(start, end) / 60.0));
        }
        total += 12 * Math.ceil(ChronoUnit.MINUTES.between(start, bed)/60.0);
        LocalTime temp = OFFICIAL_END.isBefore(end) ? end : LocalTime.MAX;
        total += 8 * Math.ceil(ChronoUnit.MINUTES.between(bed, temp)/60.0);
        if(end.isAfter(LocalTime.MIDNIGHT) && !end.isAfter(OFFICIAL_END)) {
            total += 16 * Math.ceil(ChronoUnit.MINUTES.between(LocalTime.MIDNIGHT, end)/60.0);
        }

        return String.format("$%.2f", total);
    }

}
