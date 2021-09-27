package com.company.thread.safe;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 2) {
                list.remove(next);
            }
        }
    }
}
