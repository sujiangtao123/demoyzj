package com.company.Test;

import javax.xml.transform.Source;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Demo1 {

    public static void main(String[] args) throws Exception {
//        outer:for(int x=0; x<3; x++)
//        {
//            n: for(int y=0; y<4; y++)
//            {
//                System.out.println("x="+x);
//                System.out.println("y="+y)
//                continue n;
//
//            }
//        }
        List<String> strings = Collections.singletonList(String.valueOf(5983013L));
        String collect = strings.stream().collect(Collectors.joining("\",\"", "[\"", "\"]"));

        System.out.println(LocalDate.parse("2021-01-21",DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }
}
