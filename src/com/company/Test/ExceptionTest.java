package com.company.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionTest {
    public static void main(String[] args) {
        int[] n=new int[]{1,2,3};
        try {
            int i = n[3];
        } catch (Exception e) {
            System.out.println("异常类型是： "+getExceptionType(e));
            System.out.println("异常信息------>"+getExceptionMessage(e));
            System.out.println("异常的跟踪栈是： "+getExceptionSrintStackTrace(e));
            //e.printStackTrace();
        }
    }
    public static Throwable getExceptionType(Exception e) {
        return e;
    }
    public static String getExceptionMessage(Exception e) {
        return e.getMessage();
    }
    public static String getExceptionSrintStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
