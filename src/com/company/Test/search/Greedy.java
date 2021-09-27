package com.company.Test.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Greedy {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("天津");
        hashSet4.add("上海");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        map.put("k1", hashSet1);
        map.put("k2", hashSet2);
        map.put("k3", hashSet3);
        map.put("k4", hashSet4);
        map.put("k5", hashSet5);
        HashSet<String> areaCodes = new HashSet<>();//存放所有地区
        areaCodes.addAll(hashSet1);
        areaCodes.addAll(hashSet2);
        areaCodes.addAll(hashSet3);
        areaCodes.addAll(hashSet4);
        areaCodes.addAll(hashSet5);
        LinkedList<String> list = new LinkedList<>();
        String maxKey;
        while (!areaCodes.isEmpty()) {//areaCodes存放这所有的城市
            maxKey = null; //这里每次进行筛选记得把maxKey都置为空
            for (String key : map.keySet()) {//遍历所有电台 map的key是电台,value是每个电台覆盖的城市
                HashSet<String> codes = map.get(key);
                codes.retainAll(areaCodes);
                //这里比较是哪个电台覆盖的城市最多，就让谁为maxKey
                if (codes.size() > 0 && (maxKey == null || codes.size() > map.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //退出for得到最大的maxKey
            if (maxKey != null) {
                list.add(maxKey);
                //清除所在的areaCodes中包含maxKey电台的地区
                areaCodes.removeAll(map.get(maxKey));
            }
        }
        System.out.println(list);
    }


}
