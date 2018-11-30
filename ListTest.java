package com.test.myPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 备选课程类
 */
public class ListTest {
    /*
    用于存放备选课程的容器
     */
    public List cousersToSelected;
    public ListTest(){
        this.cousersToSelected = new ArrayList();

    }
    public void testAdd(){
        /*
        添加备选课程
         */
        Course cr1 = new Course("1","数据课程");
        cousersToSelected.add(cr1);
        Course temp = (Course) cousersToSelected.get(0);
        System.out.println("添加了课程"+temp.id+":"+temp.name);

        Course cr2 = new Course("2","C语言");
        cousersToSelected.add(0,cr2);
        Course temp2 = (Course) cousersToSelected.get(0);
        System.out.println("添加了课程"+temp2.id+":"+temp2.name);

        Course[] course = {new Course("3","离散数学"),new Course("4","高等数学")};
        cousersToSelected.addAll(Arrays.asList(course));
        Course temp3 = (Course) cousersToSelected.get(2);
        Course temp4 = (Course) cousersToSelected.get(3);
        System.out.println("添加了课程"+temp3.id+":"+temp3.name);
        System.out.println("添加了课程"+temp4.id+":"+temp4.name);

    }
    public void testGet() {
        int size = cousersToSelected.size();
        System.out.println("有如下课程待选：");
        for (int i = 0; i < size; i++) {
            Course cr = (Course) cousersToSelected.get(i);
            System.out.println("课程："+cr.id+":"+cr.name);
        }
    }
    /*
    * 通过迭代器遍历List
     */
    public void testIterator(){
        Iterator it = cousersToSelected.iterator();
        System.out.println("通过迭代器访问");
        while (it.hasNext()){
            Course cr = (Course) it.next();
            System.out.println("课程："+cr.id+":"+cr.name);
        }
    }
    /*
    foreach
     */
    public void testForEach(){
        System.out.println("通过foreach访问");
        for (Object obj:cousersToSelected){
            Course cr = (Course) obj;
            System.out.println("课程："+cr.id+":"+cr.name);
        }
    }
    /*
    修改List中的元素
     */
    public void testModify(){
        System.out.println("修改课程");
        cousersToSelected.set(2,new Course("3","毛概"));
    }
    /*
    删除List中的元素
     */
    public void testRemove(){
        //Course cr = (Course) cousersToSelected.get(3);
//        System.out.println("要删除的课程是："+cr.id+":"+cr.name);
        System.out.println("删除课程数组3和4");
        Course[] courses = {(Course) cousersToSelected.get(2),(Course) cousersToSelected.get(3)};
//        cousersToSelected.remove(cr);
        cousersToSelected.removeAll(Arrays.asList(courses));
        System.out.println("成功删除课程");
    }
    /*
    往List中添加一些奇怪的东西
     */
    public void testType(){
        System.out.println("add somthing-----");
        cousersToSelected.add("I am not a course;");
    }
    public static void main(String[] args){
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testRemove();
        lt.testForEach();
    }
}
