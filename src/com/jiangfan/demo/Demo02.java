package com.jiangfan.demo;

/**
 * 缩写校验（建议时间复杂度 O(n) ）
 * 给定⼀个⾮空字符串 s 和⼀个缩写 abbr，请校验它们是否匹配。假设字符串中只包含⼩写字⺟，缩写中只包含⼩写字⺟和数字。
 * 缩写中的数字表示其缩略的字符数；连续多位数字表示⼀个多位数。
 * 例如，字符串 “word” 的缩写有且仅有以下这些：[“word", “1ord”, “w1rd”,
 * “wo1d”, “wor1”, “2rd”, “w2d”, “wo2”, “1o1d”, “1or1”, “w1r1”, “1o2”, “2r1”, “3d”,“w3”, “4"]。
 * 例 1：输⼊：s = “internationalization"，abbr = “i12iz4n”
 * 返回：true
 * 解释：abbr 中的 12 表示有⼗⼆个字符被缩略了。
 * 例 2：输⼊：s = “apple"，abbr = “a2e"
 * 返回：false
 * 需要实现的⽅法原型：boolean valid(String word, String abbr)
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  9:24
 */
public class Demo02 {

    public static void main(String[] args) {

        boolean valid = valid("internationalization", "i12iz5");
        System.out.println(valid);
    }

    public static boolean valid(String word, String abbr) {
        // 两个字符的下标
        int i = 0, j = 0;
        // abbr 的数字
        int num = 0;
        while (i < word.length() && j < abbr.length()) {

            // abbr = '0' 返回false
            if (abbr.charAt(j) == '0') {
                return false;
            }

            // abbr不为字母 Character.isLetter() 判断是否越界，判断是否为字母 
            while (j < abbr.length() && !Character.isLetter(abbr.charAt(j))) {
                // 计算num 数字值   '0' = 48
                num = num * 10 + abbr.charAt(j) - 48;
                j++;
            }

            // s = “apple"，abbr = “a2le"

            // i跳过num个字符 然后继续比较字符是否一致
            i += num;

            // 两个字符遍历同时结束
            if (i == word.length() && j == abbr.length()) {
                return true;
            }
            // 两个字符不一致，结束 返回false  前提：下标未越界
            if (i < word.length() && j < abbr.length() && word.charAt(i) != abbr.charAt(j)) {
                return false;
            }
            // 一个 字符越界 一个未越界，返回false
            if ((i < word.length() && j >= abbr.length()) || (i >= word.length() && j < abbr.length())) {
                return false;
            }

            i++;
            j++;
            // 重置num
            num = 0;
        }

        return true;
    }

}
