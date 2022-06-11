package com.jiangfan.test;

import com.jiangfan.sort.Student;

/**
 * 定义测试类Test，在测试类Test中定义测试方法Comparable getMax(Comparable c1,Comparable c2)完成测试
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-10  18:08
 */
public class TestComparable {

    public static void main(String[] args) {
        Student s1 = new Student("张三",18);
        Student s2 = new Student("李四",20);
        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }
    
    // 排序
    public static Comparable getMax(Comparable c1,Comparable c2){
        int result = c1.compareTo(c2);
        if (result>=0){
            return c1;
        }else {
            return c2;
        }
    }
    
}
