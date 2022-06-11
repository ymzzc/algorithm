package com.jiangfan.linear;

/**
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  19:28
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for (String str : stack) {
            System.out.print(str+" ");
        }
        System.out.println("-----------------------------");
        String result = stack.pop();
        System.out.println("弹出了元素："+result);
        System.out.println("弹出了元素："+stack.pop());
        System.out.println(stack.size());
    }
}
