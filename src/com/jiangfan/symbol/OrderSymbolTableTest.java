package com.jiangfan.symbol;

/**
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  21:18
 */
public class OrderSymbolTableTest {
    public static void main(String[] args) {
        //创建有序符号表对象
        OrderSymbolTable<Integer, String> table = new OrderSymbolTable<>();

        table.put(1,"张三");
        table.put(2,"李四");
        table.put(4,"赵六");
        table.put(7,"田七");
        table.put(3,"王五");
        
        System.out.println(table.get(3));
        System.out.println("==================================");
        for (Integer integer : table) {
            System.out.println(table.get(integer));
        }
    }
    
}
