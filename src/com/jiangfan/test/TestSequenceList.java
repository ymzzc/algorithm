package com.jiangfan.test;

import com.jiangfan.linear.SequenceList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  12:37
 */
public class TestSequenceList {
    public static void main(String[] args) {
    
        //创建顺序表对象
        SequenceList<String> sl = new SequenceList<>(10);
        //测试插入
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1, "詹姆斯");
        //测试获取
        String getResult = sl.get(1);
        System.out.println("获取索引1处的结果为：" + getResult);
        //测试删除
        String removeResult = sl.remove(0);
        System.out.println("删除的元素是：" + removeResult);
        //测试清空
        sl.clear();
        System.out.println("清空后的线性表中的元素个数为:" + sl.length());

        SequenceList<String> squence = new SequenceList<>(5);
        System.out.println("--------------------------------------");
        //测试遍历
        squence.insert(0, "姚明");
        squence.insert(1, "科比");
        squence.insert(2, "麦迪");
        squence.insert(3, "艾佛森");
        squence.insert(4, "卡特");
        for (String s : squence) {
            System.out.println(s);
        }
        
    }
}
