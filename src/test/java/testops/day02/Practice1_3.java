package testops.day02;

import edu.princeton.cs.algs4.StdOut;
import org.testng.annotations.Test;
import top.testops.day01.impl.LinkQueue;
import top.testops.day01.impl.LinkStack;
import top.testops.day01.impl.Queue;
import top.testops.day01.impl.Stack;

import java.util.ArrayList;
import java.util.List;

public class Practice1_3 {
    @Test
    public void practice1() {
        LinkStack<Integer> stack = new LinkStack<Integer>();
//      0-9
//      4  3  2  1  0  9  8  7  6  5
//      4  6  8  7  5  3  2  9  0  1 (1要比0早出栈)
//      2  5  6  7  4  8  9  3  1  0
//      4  3  2  1  0  5  6  7  8  9
//      1  2  3  4  5  6  9  8  7  0
//    f:  false 0  4  6  5  3  8  7  2  9  1 （7要比1早出栈）
//    g:  false 1  4  7  9  8  6  5  3  2  0 （2要比0早出栈）
//    h:  true  2  1  4  3  6  5  8  7  9  0
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.push(5);
        stack.push(6);
        stack.pop();
        stack.pop();
        stack.push(7);
        stack.push(8);
        stack.pop();
        stack.pop();
        stack.push(9);
        stack.pop();
        stack.pop();

    }

    @Test
    public void Parentheses() {
//        String s = "[()]{}{[()()]()}";
//        String s = "[()]{}[()()]()}";
        String s = "[(){}{[()()]()}";
        LinkStack<Character> stack = new LinkStack<Character>();
        boolean flag = false;
        try {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ')' || c == ']' || c == '}') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        } catch (Exception e) {
            flag = false;
            System.out.println("结果是： " + flag);
            return;
        }
        if (stack.isEmpty()) {
            flag = true;
        } else {
            flag = false;
        }
        System.out.println("结果是： " + flag);

    }

    @Test
    public void peek() {
        LinkStack<Integer> stack = new LinkStack<Integer>();
        stack.push(10);
        stack.push(33);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }

    @Test
    public void expression() {
//        String ss = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String ss = "2 * 3 ) / 2 - 1 ) + 3 * 4 - 1 ) ) )";
//        String ss = "2 * 3 ) / 2 - 1 ) + 3 * 4 - 1 ) ) )";
        List<String> list = new ArrayList<String>();
        String[] target = ss.split(" ");
        int index = 1;
        for (int i = 0; i < target.length; i++) {
            list.add(target[i]);
        }
        for (int i = target.length - 1; i >= 0; i--) {
            String s = target[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (target[--i].equals(")")) {
                    index++;
                } else {
                    for (int j = 0; j < index; j++) {
                        list.add(i, "(");
                    }
                    index = 1;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

//        String s = target[i];
//        if (s.equals(")")){
//            all.push(")");
//        }
//        else if (s.equals("+")) {
//            ops.push(s);
//            all.push("(");
//        }
//        else if (s.equals("-")){ ops.push(s);all.push("(");}
//        else if (s.equals("*")){ ops.push(s);all.push("(");}
//        else if (s.equals("/")){ ops.push(s);all.push("(");}
//        else {
//            vals.push(Double.parseDouble(s));
//        }
    }

    @Test
    public void expression2() {
//        String ss = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String ss = "2 * 3 ) / 2 - 1 ) ) + 3 * 4 - 1 ) ) )";
        Stack<String> S = new Stack<String>();
        String[] target = ss.split(" ");
        for (int i = 0; i < target.length; i++) {
            String str = target[i];
            if (str.equals(")")) {
                String num2 = S.pop();
                String operator = S.pop();
                String num1 = S.pop();
                S.push("( " + num1 + " " + operator + " " + num2 + " )");
            } else
                S.push(str);
        }
        StdOut.println(S.pop());
    }

    @Test
    public void InfixToPostfix() {
//        String ss = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
        String ss = "( ( ( 2 * 3 ) / ( 2 - 1 ) ) + ( 3 * ( 4 - 1 ) ) )";
        Stack<String> vals = new Stack<String>();
        Stack<String> ops = new Stack<String>();

        String[] target = ss.split(" ");
        for (int i = 0; i < target.length; i++) {
            String s = target[i];
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String num1 = vals.pop();
                String num2 = vals.pop();
                String op = ops.pop();
                String result = op + num2 + num1;
                vals.push(result);
            } else {
                vals.push(s);
            }
        }
        for (String val : vals) {
            System.out.print(vals.pop() + " ");
        }
    }

    @Test
    public void InfixToPostfix2() {
//        String ss = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
        String ss = "( ( ( 2 * 3 ) / ( 2 - 1 ) ) + ( 3 * ( 4 - 1 ) ) )";
        Stack<String> vals = new Stack<String>();
        Stack<String> ops = new Stack<String>();

        String[] target = ss.split(" ");
        for (int i = target.length - 1; i >= 0; i--) {
            String s = target[i];
            if (s.equals(")")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals("(")) {
                String num1 = vals.pop();
                String num2 = vals.pop();
                String op = ops.pop();
                String result = op + num1 + num2;
                vals.push(result);
            } else {
                vals.push(s);
            }
        }
        System.out.print(vals.pop() + " ");
    }

    @Test
    public void EvaluatePostfix() {
//        23*21-/341-*+
        String ss = "23*21-/341-*+";
        Stack<Double> vals = new Stack<Double>();
        Stack<String> ops = new Stack<String>();
        String[] target = ss.split("");
        Double sum;
        for (int i = 0; i < target.length ; i++) {
            String s = target[i];
            if (s.equals("+")) {
                sum = vals.pop() + vals.pop();
                vals.push(sum);
            }
            else if (s.equals("-")) {
                Double num1 = vals.pop();
                Double num2 = vals.pop();
                sum = num2 - num1;
                vals.push(sum);
            }
            else if (s.equals("*")) {
                sum = vals.pop() * vals.pop();
                vals.push(sum);
            }
            else if (s.equals("/")){
                Double num1 = vals.pop();
                Double num2 = vals.pop();
                sum = num2 / num1;
                vals.push(sum);
            }
            else {
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
    @Test
    public void getKTest(){
        Queue<Character> queue = new Queue<Character>();
        String ss = "23*21-/341-*+";
        for (int i = 0; i < ss.length(); i++) {
            queue.enqueue(ss.charAt(i));
        }

        System.out.println(queue.getK(3));

    }

    @Test
    public void deleteEnd(){
        LinkQueue<Character> queue = new LinkQueue<Character>();
        String ss = "23*21-/341-*+";
        for (int i = 0; i < ss.length(); i++) {
            queue.enqueue(ss.charAt(i));
        }

    }
}
