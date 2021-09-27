package com.company.File;

import com.company.model.LeadBean;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class readExcelTxt {
    private static List<String> listJX = new ArrayList<>();
    private static List<String> listNJ = new ArrayList<>();
    private static List<String> listMJ = new ArrayList<>();
    private static List<LeadBean> listJXBean = new ArrayList<>();
    private static List<LeadBean> listNJBean = new ArrayList<>();
    private static List<LeadBean> listMJBean = new ArrayList<>();
    private static List<LeadBean> listElse = new ArrayList<>();
    private static Map<String, List<LeadBean>> resultMap = new ConcurrentHashMap<>();

    //江西
    static {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Desktop\\江西安友.txt")));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "gbk"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\t");
                if(split.length >=1){
                    listJX.add(split[0]);
                }else{
                    listJX.add(line);
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //南京
//    static {
//        try {
//            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Desktop\\南京初见.txt")));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "gbk"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                listNJ.add(line);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    //盟聚
    static {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Desktop\\安徽盟聚.txt")));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "gbk"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
            String line = "";
            while ((line = reader.readLine()) != null) {
                listMJ.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    static {
//        try {
//            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Desktop\\江苏盟聚.txt")));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "gbk"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                String[] split = line.split(";");
//                for (String s : split) {
//                    listMJ.add(s);
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    static {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Desktop\\江苏盟聚.txt")));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "gbk"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
            String line = "";
            while ((line = reader.readLine()) != null) {
                listMJ.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    static {
//        try {
//            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Desktop\\号码包.txt")));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "gbk"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                listMJ.add(line);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

//    static {
//        try {
//            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Desktop\\A1号码包.txt")));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "gbk"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                listMJ.add(line);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

//    static {
//        try {
//            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Desktop\\电话号码.txt")));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "gbk"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                listMJ.add(line);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    //数据加载完进行线程跑批
    static class ThreadLocalList implements Callable<Map<String, List<LeadBean>>> {

        @Override
        public Map<String, List<LeadBean>> call() throws Exception {
            try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\v_xmjtsu\\Desktop\\excel.txt")));
                BufferedReader reader = new BufferedReader(new InputStreamReader(bis, "gbk"), 5 * 1024 * 1024);// 用5M的缓冲读取文本文件
                String line = "";
                while ((line = reader.readLine()) != null) {
                    LeadBean leadBean = new LeadBean();
                    String[] split = line.split(";");
                    leadBean.setCompanyName(split[1].trim());
                    leadBean.setName(split[2].trim());
                    leadBean.setTelPhone(split[3].trim());
                    leadBean.setProvince(split[5].trim());
                    leadBean.setCity(split[6].trim());
                    leadBean.setQq(split[8].trim());
                    List<String> stringJx = listTrim(listJX);
                    List<String> stringNj = listTrim(listNJ);
                    List<String> stringMj = listTrim(listMJ);
                    if (stringJx.contains(leadBean.getTelPhone())) {
                        listJXBean.add(leadBean);
                        resultMap.put("JX", listJXBean);
                    }
                    if (stringNj.contains(leadBean.getTelPhone())) {
                        listNJBean.add(leadBean);
                        resultMap.put("NJ", listNJBean);
                    }
                    if (stringMj.contains(leadBean.getTelPhone())) {
                        listMJBean.add(leadBean);
                        resultMap.put("MJ", listMJBean);
                    }
                    if (!stringJx.contains(leadBean.getTelPhone()) && !stringNj.contains(leadBean.getTelPhone())
                            && !stringMj.contains(leadBean.getTelPhone())) {
                        listElse.add(leadBean);
                        resultMap.put("ELSE", listElse);
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return resultMap;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(listJX.size());
        System.out.println(listNJ.size());
        System.out.println(listMJ.size());
        FutureTask<Map<String, List<LeadBean>>> futureTask = new FutureTask<>(new ThreadLocalList());
        new Thread(futureTask).start();
        Map<String, List<LeadBean>> stringListMap = futureTask.get();
        if (stringListMap.get("JX") != null && !stringListMap.get("JX").isEmpty()) {
            List<String> collect = listJXBean.stream().map(bean -> bean.toString()).collect(Collectors.toList());
            writeObjectToFile(collect, "G:\\江西.txt");
        }
        if (stringListMap.get("NJ") != null && !stringListMap.get("NJ").isEmpty()) {
            List<String> collect = listNJBean.stream().map(bean -> bean.toString()).collect(Collectors.toList());
            writeObjectToFile(collect, "G:\\南京.txt");
        }
        if (stringListMap.get("MJ") != null && !stringListMap.get("MJ").isEmpty()) {
            List<String> collect = listMJBean.stream().map(bean -> bean.toString()).collect(Collectors.toList());
            writeObjectToFile(collect, "G:\\盟聚.txt");
        }
        if (stringListMap.get("ELSE") != null && !stringListMap.get("ELSE").isEmpty()) {
            List<String> collect = listElse.stream().map(bean -> bean.toString()).collect(Collectors.toList());
            writeObjectToFile(collect, "G:\\未匹配.txt");
        }

    }

    private static List<String> listTrim(List<String> list) {
        List<String> l = new ArrayList<>();
        for (String t : list) {
            l.add(t.trim());
        }
        return l;
    }

    private static void writeObjectToFile(List<String> list, String name) {
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
}
