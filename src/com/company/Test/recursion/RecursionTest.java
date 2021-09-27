package com.company.Test.recursion;

import java.security.interfaces.ECKey;

public class RecursionTest {
    public static void main(String[] args) {

        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置迷宫的挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[1][2] = 1;
        map[2][2] = 1;
        System.out.println("开始地图\n");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        System.out.println("走过的地图\n");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //0 表示此路没走过 1 表示为墙 2 表示此路走过 3表示是思路
    // i j 表示从哪里开始走
    //按照下右上左的方式走
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2; //假设可以走通
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;//此路不通
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
