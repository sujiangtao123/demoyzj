package com.atguigu.charater1;


public class ClassLoadTest {

    public static void main(String[] args) {

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
        //获取上层类加载器 扩展类加载器 extClassLoader
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent); //jdk.internal.loader.ClassLoaders$PlatformClassLoader@58ceff1
        //试图获取其上层, 获取不到引导类加载器
        System.out.println(parent.getParent()); // null

        //自定义类加载器
        System.out.println(ClassLoadTest.class.getClassLoader()); //jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc

        //为null说明string是引导类加载器加载  java的核心类库都是引导类加载器加载 bootStrapClassLoader
        System.out.println(String.class.getClassLoader()); // null

        //线程上下文类加载器(系统类加载器-自定义加载器)
        System.out.println(Thread.currentThread().getContextClassLoader());//jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc

 
    }
}
