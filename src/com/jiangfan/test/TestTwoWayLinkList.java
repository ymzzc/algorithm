package com.jiangfan.test;

import com.jiangfan.linear.TwoWayLinkList;

/**
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  16:39
 */
public class TestTwoWayLinkList {
    public static void main(String[] args) {
        TwoWayLinkList<String> list = new TwoWayLinkList<>();
        list.insert("张三");
        list.insert("李四");
        list.insert("王五");
        list.insert("刘六");
        list.remove(1);
        list.insert(1, "七仙女");
        list.insert(4, "八仙");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("======================================");
        System.out.println("第一个节点" + list.getFirst());
        System.out.println("最后一个节点" + list.getLast());
        System.out.println("======================================");
        list.reverse();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
