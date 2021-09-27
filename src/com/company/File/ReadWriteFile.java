package com.company.File;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) throws IOException {
        //File f1 = new File("C:\\Users\\v_xmjtsu\\Documents\\WXWork\\1688850570756736\\Cache\\File\\2020-07\\call_05"); //读这个文件
       /* File f1 = new File("F:\\csv.txt"); //读这个文件
        File f2 = new File("f:\\tes.txt"); //写入到这个文件
        BufferedReader br = new BufferedReader(new FileReader(f1)); //创建读缓冲流
        BufferedWriter bw = new BufferedWriter(new FileWriter(f2)); //创建写缓冲流

        //一行一行写入
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.flush();
            //if(line.contains("8024501224550170675")){
                bw.write(line);
                bw.newLine();
           // }

        }
        br.close();
        bw.close();*/
        String ss = "G:\\sata\\ad";
        File file = new File(ss);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            System.out.println(parentFile);
            if (!parentFile.exists()) {
                file.mkdirs();
            }
            file.createNewFile();
        }

    }
}