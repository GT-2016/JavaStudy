package com.test.myPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
    /*
    用来放学生类型的对象
     */
    public Map<String,Student> students;
    /*
    构造方法，初始化students
     */
    public MapTest(){
        this.students = new HashMap<String, Student>();
    }

    /*
    测试方法：输入学生ID，判断是否被占用

     */
    public void testPut(){
        //创建一个Scanner对象，用来获取输入的学生id和姓名
        Scanner console = new Scanner(System.in);
        int i = 0;
        while (i < 3){
            System.out.println("请输入学生ID:");
            String ID = console.next();

            Student st = students.get(ID);
            if (st == null){
                System.out.println("请输入学生姓名:");
                String name = console.next();
                // 创建新的学生对象
                Student newStudent = new Student(ID,name);
                // 通过调用students的put方法，添加ID和name

                students.put(ID,newStudent);
                System.out.println("新增学生对象:"+students.get(ID).name);
                i++;

            } else {
                System.out.println("该学生ID已被占用");
                continue;
            }
        }

    }
    /*
    增加学生对象
     */
    public void testPutStudents(){
//        Student newStudent =
        students.put("1",new Student("1","Sunny"));
        students.put("2",new Student("2","Jack"));
        students.put("3",new Student("3","Mary"));
    }
    /*
    测试Map的keySet方法
     */
    public void testKeySet(){
        // 通过keySet方法，返回Map中的所有键的set集合
        Set<String> KeySet = students.keySet();
        System.out.println("共"+students.size()+"名学生");
        for (String stuId: KeySet){
            Student st = students.get(stuId);
            if(st != null){
                System.out.println("学生" + stuId + "：" + st.name);
            }
        }
    }
    /*
    测试删除Map中的映射
     */
    public void testRemove(){
        //提示
        while (true) {
            System.out.println("请输入要删除学生的ID：");
            Scanner console = new Scanner(System.in);
            String ID = console.next();
            // 判断该ID是否有对应学生对象
            Student st = students.get(ID);

            if (st == null) {
                System.out.println("该ID不存在");
                continue;
            }
            students.remove(ID);
            System.out.println("成功删除学生");
            break;
        }
    }
    /*
    通过entrySet方法遍历Map
     */
    public void testEntrySet(){
        // 通过entrySet方法，返回Map中的所有键值对
        Set<Map.Entry<String, Student>> entrySet = students.entrySet();
        for (Map.Entry<String, Student> entry : entrySet){
            System.out.println("取得键："+entry.getKey());
            System.out.println("对应的值为："+entry.getValue().name);

        }
    }
    /*
    使用put方法修改Map中的已有映射
     */
    public void testModify(){
        //提示输入要修改的学生ID
        System.out.println("请输入要修改的学生ID");
        Scanner console = new Scanner(System.in);
        while (true){
            String stuID = console.next();
            Student student = students.get(stuID);
            if (student == null ){
                System.out.println("该ID不存在！请重新输入");
                continue;
            }
            System.out.println("当前学生ID："+stuID);
            System.out.println("请输入新的学生姓名：");
            String name = console.next();
            Student newStudent = new Student(stuID, name);
            students.put(stuID, newStudent);
            System.out.println("修改成功！");
            break;
        }
    }
    public static void main(String[] args){
        MapTest mt = new MapTest();
        mt.testPutStudents();
        mt.testKeySet();
        mt.testModify();
        mt.testEntrySet();
    }
}