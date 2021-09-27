package com.company.Test;


import java.util.concurrent.atomic.AtomicReference;

public class SortTest {
    public static void main(String[] args) {
//        int[] arr = {1,2,2,3,3,4,5,6};
//        int first = 0;
//        int last = arr.length-1;
//        while (last < arr.length && last >= 0){
//            if(arr[last] == arr[first]){
//                first++;
//            }
//            last--;
//        }
//        System.out.println(Arrays.toString(arr));
        SimpleObject test = new SimpleObject("test", 50);
        AtomicReference<SimpleObject> simpleObjectAtomicReference = new AtomicReference<>(test);
        SimpleObject test6 = simpleObjectAtomicReference.getAndSet(new SimpleObject("test6", 50));
        SimpleObject simpleObject = simpleObjectAtomicReference.get();
        simpleObjectAtomicReference.compareAndSet(test,new SimpleObject("test6", 50));
        System.out.println(simpleObjectAtomicReference.get());
        System.out.println(test6.toString());
        System.out.println(simpleObject.toString());
    }
}

class SimpleObject{
    private String name;
    private int age;

    public SimpleObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
