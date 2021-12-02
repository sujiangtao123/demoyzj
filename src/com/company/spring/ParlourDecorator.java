package com.company.spring;

/**
 * 建造者模式
 * 1. 抽象建造者
 * 2. 具体建造者
 * 3. 产品角色
 * 4. 指挥者
 */
public class ParlourDecorator {
    public static void main(String[] args) {
        Decorator decorator = new ConcreteDecorator1();
        decorator.buildWall();
        decorator.buildTV();
        decorator.buildSofa();
        Parlour parlour = decorator.getParlour();
        parlour.show();
    }
}

class Parlour {
    private String wall;    //墙
    private String TV;    //电视
    private String sofa;    //沙发

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setTV(String TV) {
        this.TV = TV;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    public void show() {
        System.out.println(this.wall + "---" + this.sofa + "-----" + this.TV);
    }
}

abstract class Decorator {
    protected Parlour parlour = new Parlour();

    public abstract void buildWall();

    public abstract void buildTV();

    public abstract void buildSofa();

    public Parlour getParlour() {
        return parlour;
    }
}

class ConcreteDecorator1 extends Decorator {
    public void buildWall() {
        parlour.setWall("w1");
    }

    public void buildTV() {
        parlour.setTV("TV1");
    }

    public void buildSofa() {
        parlour.setSofa("sf1");
    }
}
