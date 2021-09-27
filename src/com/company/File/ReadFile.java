package com.company.File;

import com.company.model.CallSessionBean;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

public class ReadFile {
    private static List<String> objectBd = Collections.synchronizedList(new ArrayList<>());
    private static List<String> objectQn = Collections.synchronizedList(new ArrayList<>());
    private static Map<String, CallSessionBean> qNmap5 = new ConcurrentHashMap<>();
    private static Map<String, CallSessionBean> bDmap5 = new ConcurrentHashMap<>();
    private static Map<String, String> relationMap = new ConcurrentHashMap<>();

    static {
        try (FileReader file = new FileReader("C:\\Users\\v_xmjtsu\\Documents\\WXWork\\1688850570756736\\Cache\\File\\2020-07\\external")) {
            try (BufferedReader buff = new BufferedReader(file)) {
                boolean eof = false;
                while (!eof) {
                    String line = buff.readLine();
                    if (line == null) {
                        eof = true;
                    } else {
                        String[] split = line.split("\t");
                        relationMap.put(split[0].trim(), split[1].trim());
                    }
                }
            }
            System.out.println("relationMap: " + relationMap.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ThreadMonthBd5 implements Callable<Map<String, CallSessionBean>> {

        @Override
        public Map<String, CallSessionBean> call() {
            //try (FileReader file = new FileReader("C:\\Users\\v_xmjtsu\\Documents\\WXWork\\1688850570756736\\Cache\\File\\2020-07\\call_05")) {
//            try (FileReader file = new FileReader("C:\\Users\\v_xmjtsu\\Downloads\\call_09")) {
            try {
                //BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Downloads\\call_06")));
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Documents\\WXWork\\1688850570756736\\Cache\\File\\2020-07\\call_04")));
                BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "utf-8"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
                String line = "";
                while ((line = reader.readLine()) != null) {
                    CallSessionBean callSessionBean = new CallSessionBean();
                    String[] split = line.split("\t");
                    callSessionBean.setAgencyId(relationMap.get(split[1].trim()));
                    callSessionBean.setCallCenterSessionId(split[2].trim());
                    callSessionBean.setStartTime(split[4].trim());
                    callSessionBean.setEndTime(split[5].trim());
                    callSessionBean.setSeatNo(split[6].trim());
                    callSessionBean.setCustomerNumber(split[7].trim().replace("-", ""));
                    callSessionBean.setTalkDuration(split[8].trim());
                    bDmap5.put(callSessionBean.getCallCenterSessionId(), callSessionBean);
                    objectBd.add(callSessionBean.getCallCenterSessionId());
                }
                System.out.println("本地文件本该有的数据条数objectBd: " + objectBd.size());
                System.out.println("本地文件本该有的数据条数bDmap5: " + bDmap5.size());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return bDmap5;
        }
    }

    static class ThreadMonthQn5 implements Callable<Map<String, CallSessionBean>> {
        @Override
        public Map<String, CallSessionBean> call() {
//            try (FileReader file = new FileReader("C:\\Users\\v_xmjtsu\\Documents\\WXWork\\1688850570756736\\Cache\\File\\2020-07\\20190901-20190930.csv")) {
            try {
                //BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Documents\\WXWork\\1688850570756736\\Cache\\File\\2020-07\\20190401-20190430.csv")));
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Documents\\WeChat Files\\wxid_7i5v3krr88db22\\FileStorage\\File\\2020-08\\20190401-20190430.csv")));
                BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "utf-8"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
                String line = "";
                while ((line = reader.readLine()) != null) {
                    CallSessionBean callSessionBean = new CallSessionBean();
                    String[] split = line.split(",");
                    if(!split[0].trim().equals("企业编号")){
                        callSessionBean.setAgencyId(split[0].trim());
                        callSessionBean.setCallCenterSessionId(split[1].trim());
                        callSessionBean.setSeatNo(split[2].trim());
                        callSessionBean.setStartTime(split[3].trim());
                        callSessionBean.setEndTime(split[4].trim());
                        callSessionBean.setCustomerNumber((split[5].substring(split[5].indexOf(":") + 1).trim()).replace("-",""));
                        callSessionBean.setTalkDuration(split[6].trim());
                        qNmap5.put(callSessionBean.getCallCenterSessionId(), callSessionBean);
                        objectQn.add(callSessionBean.getCallCenterSessionId());
                    }
                }
                System.out.println("青牛文件本该有的数据条数objectQn: " + objectQn.size());
                System.out.println("青牛文件本该有的数据条数qNmap5: " + qNmap5.size());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return qNmap5;
        }
    }

    public static void main(String[] args) throws Exception {
        FutureTask<Map<String, CallSessionBean>> futureTaskBd = new FutureTask(new ThreadMonthBd5());
        FutureTask<Map<String, CallSessionBean>> futureTaskQn = new FutureTask(new ThreadMonthQn5());
        new Thread(futureTaskBd).start();
        new Thread(futureTaskQn).start();
        Map<String, CallSessionBean> stringCallSessionBeanMapBd = futureTaskBd.get();
        Map<String, CallSessionBean> stringCallSessionBeanMapQn = futureTaskQn.get();
        System.out.println("Main线程返回本地条数MapBd: " + stringCallSessionBeanMapBd.size());
        System.out.println("Main线程返回青牛条数MapQn: " + stringCallSessionBeanMapQn.size());
        Set<String> stringBd = stringCallSessionBeanMapBd.keySet();
        Set<String> stringQn = stringCallSessionBeanMapQn.keySet();
        Set<String> set = new HashSet<String>();
        Set<String> result = new HashSet<String>();
        set.addAll(stringQn);
        result.addAll(stringQn);
        set.removeAll(stringBd);
        result.retainAll(stringBd);
        System.out.println("青牛和本地的差集: " + set.size());
        System.out.println("青牛和本地的交集: " + result.size());
        //本地缺少数据存进去
        List<String> collect = set.parallelStream().map((s) -> qNmap5.get(s).toString()).collect(Collectors.toList());
        writeObjectToFile(collect, "G:\\dataLoss8.txt");
        System.out.println("缺少数据存文件结束");
        //筛选值不相等数据
        List<String> collect1 = result.parallelStream().filter((s) -> !qNmap5.get(s).equals(bDmap5.get(s))).collect(Collectors.toList());
        System.out.println("青牛和本地值不相等的条数: " + collect1.size());
        int size = collect1.size();
        int pageSize = 10000;
        int a = ((size % pageSize) == 0 ? (size / pageSize) : (size / pageSize + 1));
        System.out.println("一共 "+a+" 批次");
        for (int i = 0; i < a; i++) {
            //List<String> collect2 = collect1.stream().skip(i * pageSize).limit(pageSize).map((ss) -> qNmap5.get(ss).toString()).collect(Collectors.toList());
            List<String> collect2 = collect1.stream().skip(i * pageSize).limit(pageSize).map((ss) -> toStringDifferent(qNmap5.get(ss),bDmap5.get(ss))).collect(Collectors.toList());
            writeObjectToFile(collect2, "G:\\数据不对.txt");
        }
        System.out.println("不相等数据存文件结束");
    }

    public static void writeObjectToFile(List<String> list, String name) {
        File file = new File(name);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i));
                bw.newLine();
            }
            System.out.println("写进去条数： " + list.size());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String toStringDifferent(CallSessionBean qnBean, CallSessionBean bdBean) {
        String callCenterSessionId = qnBean.getCallCenterSessionId();
        String seatNo = qnBean.getSeatNo();
        String startTime=qnBean.getStartTime();
        String endTime=qnBean.getEndTime();
        String customerNumber=qnBean.getCustomerNumber();
        String talkDuration=qnBean.getTalkDuration();
        String callSessionId=qnBean.getCallSessionId();
        String agencyId=qnBean.getAgencyId();
        if (!qnBean.getSeatNo().equals(bdBean.getSeatNo())) {
            seatNo = "seatNo: " + seatNo;
        }
        if(!qnBean.getStartTime().equals(bdBean.getStartTime())){
            startTime="startTime: "+startTime;
        }
       if(!qnBean.getEndTime().equals(bdBean.getEndTime())){
           endTime="endTime: "+endTime;

       }
       if(!qnBean.getCustomerNumber().equals(bdBean.getCustomerNumber())){
           customerNumber="customerNumber: "+customerNumber;
       }
       if(!qnBean.getAgencyId().equals(bdBean.getAgencyId())){
           agencyId="agencyId: "+agencyId;
       }
       if(!qnBean.getTalkDuration().equals(bdBean.getTalkDuration())){
           talkDuration="talkDuration: "+talkDuration;
       }
        return callCenterSessionId + " ," + seatNo + " ," +startTime+ " ," + endTime + " ," + customerNumber + " ," + talkDuration + " ," + callSessionId + " ," +agencyId;
    }
}
