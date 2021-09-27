package com.company.spring;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式发布-订阅模式
 */
public class ObserMan {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer concreteObserver1 = new ConcreteObserver1();
        Observer concreteObserver2 = new ConcreteObserver2();
        subject.add(concreteObserver1);
        subject.add(concreteObserver2);
        subject.notifyObserver();
    }

}

//抽象对象
abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    //增加观察者方法
    public void add(Observer observer) {
        observers.add(observer);
    }

    //删除观察者方法
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    //通知对象
    protected abstract void notifyObserver();

}

//具体目标
class ConcreteSubject extends Subject {

    @Override
    protected void notifyObserver() {
        System.out.println("具体目标发生变化~~~");
        for (Observer observer : observers) {
            observer.response();
        }
    }
}

class ConcreteObserver1 implements Observer {

    @Override
    public void response() {
        System.out.println("具体观察者1做出反应");
    }
}

class ConcreteObserver2 implements Observer {

    @Override
    public void response() {
        System.out.println("具体观察者2做出反应");
    }
}

interface Observer {
    void response();//响应
}
