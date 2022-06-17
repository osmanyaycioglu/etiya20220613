package com.training.dates;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateRun {
    public static void main(String[] args) {
        Date date = new Date();
        GregorianCalendar gr = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        LocalDate localDate = LocalDate.now()
                                       .plusDays(1);
        LocalDate localDate2 = LocalDate.of(1980,
                                            3,
                                            10)
                                        .plusWeeks(1)
                                        .plusDays(2);
        System.out.println(localDate2);
        System.out.println(localDate2.getDayOfWeek());

        DateTimeFormatter timeFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime parsedDate = LocalDateTime.parse("17/06/2022 09:35:17",
//                                                       timeFormatter2);
        LocalDateTime localDateTime1 = LocalDateTime.parse("2022-05-17T09:44:32.906301900");
        System.out.println(localDateTime);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(timeFormatter.format(localDateTime));

        System.out.println(timeFormatter2.format(localDateTime));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime1 = zonedDateTime.plusDays(10);

        ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(LocalDateTime.now(),
                                                        zoneId);
        // ZonedDateTime zonedDateTime1 = ZonedDateTime.parse("17/06/2022 09:35:17");
        Instant instant = zonedDateTime.toInstant();
        long milis = instant.toEpochMilli();

        Period period = Period.between(LocalDate.now(),localDate2);
        System.out.println("Period : " + period);

        Duration duration = Duration.between(localDateTime,localDateTime1);
        long milis2 = duration.toMillis();

        System.out.println("Duration : " + duration);
        System.out.println("Duration milis : " + milis2);
    }
}
