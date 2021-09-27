package com.atguigu.chapter10;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringTest {
    static String str = "asd";
    static char[] chars = {'a', 'b', 'c'};

    public void change(String str, char[] chars) {
        str = "abc";
        chars[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.change(StringTest.str, StringTest.chars);
        System.out.println(StringTest.str);
        System.out.println(StringTest.chars);

        List<Student> students = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        students.stream().collect(Collectors.groupingBy(Student::getType)).entrySet()
                .stream().forEach(entry -> {
            String key = entry.getKey();

            List<String> collect = entry.getValue().stream().map(Student::getName)
                    .collect(Collectors.toList());
            map.put(key, collect);
        });

        Map<String, List<String>> collect = students.stream().collect(Collectors.groupingBy(Student::getType,
                Collectors.mapping(Student::getName,
                        Collectors.toList())));
    }
}
