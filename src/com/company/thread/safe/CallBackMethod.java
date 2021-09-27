package com.company.thread.safe;

public class CallBackMethod {
    public static void a(){
        System.out.println("来回调我.....");
    }

}

@FunctionalInterface
interface CallBack {
    void execute();
}

class Tool{
    public   void  testTime(CallBack callBack){
        long  begin = System.currentTimeMillis(); //测试起始时间
        callBack.execute();
        long  end = System.currentTimeMillis(); //测试结束时间
        System.out.println("[use time]:"  + (end - begin)); //打印使用时间
    }
    public static void main(String[] args) {
        Tool tool = new Tool();
        tool.testTime(CallBackMethod::a);
    }

}
