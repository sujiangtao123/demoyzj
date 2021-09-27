package com.atguigu.chapter5;




class Animal{
    public void eat(){
        System.out.println("动物进食");
    }
}

interface Huntable{
     void hunt();
}

class Dog extends Animal implements Huntable{


    @Override
    public void eat() {
        System.out.println("狗吃食物");
    }

    @Override
    public void hunt() {
        System.out.println("狗捉耗子，多管闲事");
    }
}


class Cat extends Animal implements Huntable{


    @Override
    public void eat() {
        System.out.println("猫吃食物");
    }

    @Override
    public void hunt() {
        System.out.println("猫捉耗子，天经地义");
    }
}


public class AnimalTest {

    private void show(Animal animal){
        animal.eat();
    }

    private void show(Huntable huntable){
        huntable.hunt();
    }
}
