package com.company.spring;

/**
 * 工厂方法模式
 * 1. 抽象工厂
 * 2. 具体工厂
 * 3. 抽象产品
 * 4. 具体产品
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory factory = new AbstractFactory1();
        Product product = factory.newProduct();
        product.show();
    }

}

interface Product {
    void show();
}

interface AbstractFactory {
    Product newProduct();
}

class ConcreteProduct1 implements Product {

    @Override
    public void show() {
        System.out.println("具体产品1进行展示....");
    }
}

class ConcreteProduct2 implements Product {

    @Override
    public void show() {
        System.out.println("具体产品2进行展示....");
    }
}

class AbstractFactory1 implements AbstractFactory {

    @Override
    public Product newProduct() {
        System.out.println("具体工厂1生产具体产品1....");
        return new ConcreteProduct1();
    }
}

class AbstractFactory2 implements AbstractFactory {

    @Override
    public Product newProduct() {
        System.out.println("具体工厂2生产具体产品2....");
        return new ConcreteProduct2();
    }
}