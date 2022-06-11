package com.jiangfan.test;

import com.jiangfan.linear.LinkList;

/**
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  13:18
 */
public class TestLinkList {
    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();
        list.insert(0,"张三");
        list.insert(1,"李四");
        list.insert(2,"王五");
        list.insert(3,"赵六");
        //测试length方法
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.length());
        System.out.println("-------------------");
        //测试get方法
        System.out.println(list.get(2));
        System.out.println("------------------------");
        //测试remove方法
        String remove = list.remove(1);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("----------------");;
        for (String s : list) {
            System.out.println(s);
        }
    }
}
