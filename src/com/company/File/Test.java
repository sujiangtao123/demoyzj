package com.company.File;

import com.company.model.CallSessionBean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    private static List<String> objectBd = Collections.synchronizedList(new ArrayList<>());
    private  static Map<String, CallSessionBean> bDmap5=new ConcurrentHashMap<>();
    public static void main(String[] args) throws Exception{
        List<String> list = Collections.synchronizedList(new ArrayList(0));
        Collections.addAll(list,"1","2","3","4","5","6");
        for (int i=0;i<3;i++){
            writeObjectToFile(list,"G:\\test.txt");
        }

    }
    public static void writeObjectToFile(List<String> list,String name)
    {
        File file =new File(name);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter( new FileWriter(file,true) );
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i));
                bw.newLine();
            }
            System.out.println("存进去： "+list.size());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
