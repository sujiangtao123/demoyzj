package com.company.model;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class User implements Cloneable{
    private String name;

    private String sex;

    private String age;

    private List<String> lists;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public User(String name, String sex, String age, List<String> lists) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.lists = lists;
    }
    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//地址相等
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if(!sex.equals(user.sex)){
            Long date = getDate(user.sex, sex);
            if(1 == date){
                user.sex=sex;
            }
        }
        return Objects.equals(name, user.name) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }
    public static Long getDate(String endstartBd, String endstartQn){
        LocalDateTime parse = LocalDateTime.parse(endstartBd, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime parse1 = LocalDateTime.parse(endstartQn,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Instant instant = parse.toInstant(ZoneOffset.of("+8"));
        Instant instant1 = parse1.toInstant(ZoneOffset.of("+8"));
        return  Math.abs(Duration.between(instant,instant1).toMillis());
    }

    public static Long talkDuration(String talkDurationBd, String talkDurationQn){
        return Math.abs((Long.parseLong(talkDurationBd)-Long.parseLong(talkDurationQn)));
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", lists=" + lists +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
