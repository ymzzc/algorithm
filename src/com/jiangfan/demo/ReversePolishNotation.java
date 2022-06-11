package com.jiangfan.demo;

import com.jiangfan.linear.Stack;

/**
 * 逆波兰表达式求值问题
 * <p>
 * 中缀表达式    逆波兰表达式
 * a+b          ab+
 * a+(b-c)      abc-+
 * a+(b-c)*d    abc-d*+
 * a*(b-c)+d    abc-*d+
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  20:06
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        //中缀表达式3*（17-15）+18/6的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*","18", "6","/","+"};
        int result = caculate(notation);
        System.out.println("逆波兰表达式的结果为："+result);
    }

    /**
     * @param notaion 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     */
    public static int caculate(String[] notaion){
        // 创建栈存放数字
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < notaion.length; i++) {
            String curr = notaion[i];
            // 判断该字符串是不是运算符，如果不是，把该该操作数压入oprands栈中
            Integer o1;
            Integer o2;
            Integer result;
            switch (curr){
                case "+":
                    // 运算符弹出两个操作数
                    o1 = stack.pop();
                    o2 = stack.pop();
                    // 运算
                    result = o2 + o1;
                    // 压栈
                    stack.push(result);
                    break;
                case "-":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 - o1;
                    stack.push(result);
                    break;
                case "*":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 * o1;
                    stack.push(result);
                    break;
                case "/":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 / o1;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(curr));
                    break;
            }
        }
        // 遍历结束后，拿出栈中最终的结果返回
        Integer result = stack.pop();
        return result;
    }
}
