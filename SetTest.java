package com.test.myPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetTest {
    public List<Course> cousersToSelected;
    private String name;

    public SetTest(){
        cousersToSelected = new ArrayList<Course>();
    }
    public void testAdd(){
        /*
        添加备选课程
         */
        Course cr1 = new Course("1","数据课程");
        cousersToSelected.add(cr1);
//        Course temp = (Course) cousersToSelected.get(0);
//        System.out.println("添加了课程"+temp.id+":"+temp.name);

        Course cr2 = new Course("2","C语言");
        cousersToSelected.add(0,cr2);
//        Course temp2 = (Course) cousersToSelected.get(0);
//        System.out.println("添加了课程"+temp2.id+":"+temp2.name);

        Course[] course = {new Course("3","离散数学"),new Course("4","高等数学")};
        cousersToSelected.addAll(Arrays.asList(course));
//        Course temp3 = (Course) cousersToSelected.get(2);
//        Course temp4 = (Course) cousersToSelected.get(3);
//        System.out.println("添加了课程"+temp3.id+":"+temp3.name);
//        System.out.println("添加了课程"+temp4.id+":"+temp4.name);

    }

    /*
    判断是否包含备选课程
     */
    public void testIfContains(){
        Course course = cousersToSelected.get(0);
        System.out.println("第一个课程："+course.id+":"+course.name);
        System.out.println("是否存在："+cousersToSelected.contains(course));
        Course cs = new Course(course.id,course.name);
        System.out.println("是否存在："+cousersToSelected.contains(cs));
    }
    /*
    重写equals方法:模板
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Course)){
            return false;
        }
        Course course = (Course) obj;
        if (this.name == null){
            if (course.name == null)
                return true;
            else
                return false;
        } else {
            if (this.name.equals(course.name)) {
                return true;
            }
        }
        return true;
    }


    public static void main(String[] args){
        SetTest st = new SetTest();
        st.testAdd();
        st.testIfContains();
    }
}
