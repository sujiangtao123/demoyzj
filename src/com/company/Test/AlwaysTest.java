package com.company.Test;

import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AlwaysTest {
    public static void main(String[] args) {
        LocalDateTime of = LocalDateTime.of(2021, 5, 10, 10, 23, 50);
        LocalDate of1 = LocalDate.of(2021, 3, 1);
//        System.out.println(Duration.between(of, LocalDateTime.now()).toDays());
//        System.out.println(of1.minusDays(10));
//        System.out.println(new DecimalFormat("0.00").format((float) 164587 / 100));
//        System.out.println(DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm")
//                .format(LocalDateTime.ofInstant(Instant.ofEpochSecond(15454545), ZoneId.of("Asia/Shanghai"))));

        Deque<Integer> list = new LinkedList<>();
        list.offer(1);
        list.poll();
    }
}
