package com.test.myPackage;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TestGenerator;
import org.apache.ibatis.io.ResolverUtil;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
    /*
    带有泛型 - Course的List类型属性
     */
    public List<Course> courses;

    public TestGeneric(){
        this.courses = new ArrayList<Course>();
    }
    /*
        test添加
     */
    public void testAdd(){
        Course cr1 = new Course("1","大学英语");
        courses.add(cr1);
        // 泛型集合中不能添加泛型集合类型及子类型以外的对象，否则会报错
//        courses.add("jjjjjj");
        Course cr2 = new Course("2","基础课程");
        courses.add(cr2);
    }
    public void testForEach(){
        for(Course cr:courses){
            System.out.println(cr.id+":"+cr.name);
        }
    }
    /*
    泛型 集合可以添加泛型子类型的对象实例
     */
    public void testChild(){
        ChildCourse ccr = new ChildCourse();
        ccr.id = "3";
        ccr.name = "子类型实例";
        courses.add(ccr);
    }
    /*
    泛型不能使用基本类型
     */
    public void testBasicType(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        System.out.println("基本类型必须使用包装类进行泛型");
    }
    public static void main(String[] args){
        TestGeneric tg = new TestGeneric();
        tg.testAdd();
        tg.testChild();
        tg.testForEach();
        tg.testBasicType();
    }
}
