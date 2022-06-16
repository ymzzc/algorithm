package com.jiangfan.algorithm;

/**
 * 分治算法：汉诺塔
 * 解析：
 * <p>
 * 注意 ：a是个变量，存放起始柱，最开始为A柱，变量b、c同理
 * <p>
 * 这个代码最底层只能实现把起始柱 a 上的最上面的圆盘移动到目标柱 c 上
 * 而变量 a 中存放的就是起始柱，圆盘在移动的过程中，不可能一直都是 A 柱移到 C 柱
 * 因此每次要移动的圆盘的起始柱、辅助柱以及目标柱都可能不一样
 * <p>
 * 第一次进入方法的时候：
 * <p>
 * 当你把 n 上面的 n-1 个圆盘移动到 B 柱上时，A是起始柱，C时辅助柱，B才是目标柱
 * 接下来你要把第 n 个移动到 C 柱，此时不需要调用方法，直接从 a 移动到 c上
 * 最后把 B 柱上的 n-1 个移动到 C 柱，此时 B 是起始柱，A 为辅助柱，C 是目标柱
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-16  21:05
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        // 只有一个盘
        if (num == 1) {
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
        } else {
            // 把上面num-1个盘借助c柱移动到b柱
            hanoiTower(num - 1, a, c, b);
            // 把num盘从a柱移动到c柱
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            // 把num-1个盘从b柱移动到c柱
            hanoiTower(num - 1, b, a, c);
        }
    }
}
