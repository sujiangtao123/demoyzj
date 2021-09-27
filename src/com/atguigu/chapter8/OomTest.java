package com.atguigu.chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OomTest {


    public static void main(String[] args) {
        List<Picture> pictureList = new ArrayList<>();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pictureList.add(new Picture(new Random().nextInt(1024 * 10)));
        }

    }

    static class Picture {
        private Byte[] pictures;

        public Picture(int length) {
            this.pictures = new Byte[length];
        }
    }
}
