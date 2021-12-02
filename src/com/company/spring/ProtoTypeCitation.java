package com.company.spring;

/**
 * 原型模式
 */
public class ProtoTypeCitation {
    public static void main(String[] args) throws CloneNotSupportedException {
        citation citation = new citation("jt", "获取状元", "北方学院");
        citation clone = (citation) citation.clone();
        System.out.println(citation == clone);
    }

}

class citation implements Cloneable {
    String name;
    String info;
    String college;

    public citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("奖状获取成功");
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("奖状被克隆成功");
        return super.clone();
    }
}
