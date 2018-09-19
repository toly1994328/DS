package 线性结构.栈.use;


import 线性结构.数组.ArrayGroup;

import java.util.Stack;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:14:53
 * 邮箱：1981462002@qq.com
 * 说明：查看是否成对出现
 */
public class DoubleJudge {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        String[] leftChars = new String[]{"(", "{", "["};
        String[] rightChars = new String[]{")", "}", "]"};
        //左侧字符
        ArrayGroup<String> leftArr = new ArrayGroup<>(leftChars);
        //右侧字符
        ArrayGroup<String> rightArr = new ArrayGroup<>(rightChars);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // String中的第i个字符
            if (leftArr.contains(String.valueOf(c))) {
                stack.push(c);
            } else if (rightArr.contains(String.valueOf(c))) {
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = DoubleJudge.isValid("{[{yy]}{$}]user()1{￥}");
        System.out.println(valid);
    }
}

