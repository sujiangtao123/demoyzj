package com.company.File;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.*;

public class CsvTest {
    public static void main(String[] args) throws Exception{
        List<String> ss = new ArrayList<>();
        for(int i =0;i<2000;i++){
            ss.add("222");
        }
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        File dataDir = new File(new File("F:\\"), currentDate);
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
        File file = new File(dataDir, ".txt");
        writeObjectToFile(ss,file);
        String zipName = "agency_telData_" + System.currentTimeMillis() + ".zip"; // 生成的zip文件名
        File zipFile = new File("F:\\" + zipName); // zip文件完整路径

        try (FileOutputStream fos = new FileOutputStream(zipFile);
             CheckedOutputStream cos = new CheckedOutputStream(fos, new CRC32());
             ZipOutputStream zos = new ZipOutputStream(cos)) {
                String fileName = "agency_" + currentDate + System.currentTimeMillis()+".txt";
                try {
                    zos.putNextEntry(new ZipEntry(fileName));
//                    FileUtils.copyFile(agencyCsvFile, zos);
                } catch (IOException e) {
                   e.printStackTrace();
                }
        }
        System.out.println(UUID.randomUUID().toString().replace("-", ""));

    }
    private static void writeObjectToFile(List<String> list, File file) {
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
