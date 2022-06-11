package com.jiangfan.demo;

/**
 * 最⼩惩罚
 * 给定⼀个 ⽆向图 包含 N 个节点和 M 条边, 每条边 Mi 的代价为 Ci 。
 * 图中⼀条路径的惩罚是指对该路径上所有边的代价 Ci 执⾏位运算或（bitwise OR）操作得到的。
 * 假如⼀条路径上包含了边 M1，M2，M3 … … ，Mk，那么对应的惩罚就是 C1 OR C2 OR C3 OR … OR Ck。（OR代表位运算或，即 “|” ）
 * 问题：给定图上两个节点 start 和 end，找到从 start 到 end 的所有路径中惩罚值最⼩的路径，
 * 对应的最⼩惩罚值作为结果返回。如果路径不存在就返回 -1。
 * 注意：任意两个节点之间最多存在⼀条边，图中可能存在有环路。
 * 需要实现的⽅法原型:
 * int minPath(int n, int[][] edges, int start, int end)
 * 参数含义：
 * n：节点总数；节点编号从 1 开始，⼀直到 n，共有 n 个；
 * edges：⽆向图的边；edges[i] 表示边Mi，其中 edges[i][0] 和
 * edges[i][1] 是Mi的两个节点的编号，edges[i][2] 是Mi对应的代价 Ci；
 * start 和 end：路径的开始和结束节点编号
 * 限制条件: 1 <= n <=1000
 * 1 <= edges.length <= 10000
 * 1 <= Ci <=1024
 * 例：edges = [ [1，2，1]，[2，3，3]，[1，3，100] ]，对应的图如下：
 * 当 start = 1，end = 3 时，其最⼩惩罚路径是 1->2->3, C(1,2)=1并且C(2,3)=3,
 * 对应的惩罚值为 1 | 3 = 3。
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-10  11:37
 */
public class Demo03 {
    public static void main(String[] args) {
        char c = '2';
        int num = 2;
        String s = "3";
        System.out.println(num==(c-48));
    }
    
    public static int minPath(int n, int[][] edges, int start, int end){
        
        return 0;
    }
}