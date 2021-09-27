package com.atguigu.chapter5;

import org.w3c.dom.html.HTMLOListElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class OperandStackTest {

  private void testOperandStack(){
      byte i =15;
      int j = 8;
      int k = i+j;
  }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(0);
        Collections.addAll(list,1,2,3);
        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            Integer next = iterator.next();
//            if(next == 1){
//                list.remove(next);
//            }
//        }
        System.out.println(list);
    }

}
