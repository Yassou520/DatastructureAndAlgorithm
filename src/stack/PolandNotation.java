package stack;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    private final static int Level_0=0;
    private final static int Level_1=1;
    private final static int Level_2=2;
    public static void main(String[] args) {
        String expr = "10*(1+5)-9/3";
        List<String> list = getStringList(expr);
        List<String> suffixExpression = parseSuffixExpression(list);
        int res = calculateSuffixExpression(suffixExpression);
        System.out.println(expr+"="+res);
    }
    public static int calculateSuffixExpression(List<String> ls){
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : ls) {
            if (s.matches("\\d+")){
                stack.push(Integer.parseInt(s));
            }else {
                int num1=stack.pop();
                int num2=stack.pop();
                int res=calc(num2,num1,s);
                stack.push(res);
            }
        }
        return stack.pop();
    }
    public static int calc(int num1,int num2,String expr){
        int res=0;
        switch (expr){
            case "+":
                res=num1+num2;
                break;
            case "-":
                res = num1-num2;
                break;
            case "*":
                res = num1*num2;
                break;
            case "/":
                res = num1/num2;
                break;
            default:
                System.out.println("不支持的操作");
                break;
        }
        return res;
    }

     public static List<String> parseSuffixExpression(List<String> ls) {
         Deque<String> s1 = new ArrayDeque<>();
        List<String> s2 = new ArrayList<>();
         for (String s : ls) {
             if (s.matches("\\d+")){
                 s2.add(s);
             }else if(s.equals("(")){
                 s1.push(s);
             }else if (s.equals(")")){
                 while (!s1.peek().equals("(")){
                     s2.add(s1.pop());
                 }
                 s1.pop();
             }else {
                 if (s1.isEmpty() || s1.peek().equals("(")){
                     s1.push(s);
                 }else {
                     while (!s1.isEmpty()&&getPriority(s)<=getPriority(s1.peek())){
                         s2.add(s1.pop());
                     }
                     s1.push(s);
                 }
             }
         }
         while (!s1.isEmpty()){
             s2.add(s1.pop());
         }
        return s2;
     }
    public static List<String> getStringList(String expr){
        int index=0;
        int len=expr.length();
        char ch;
        String temp="";
        List<String> resList = new ArrayList<>();
        while (index < len){
            ch = expr.charAt(index);
            if (Character.isDigit(ch)){
                while (index<len && Character.isDigit(expr.charAt(index))){
                    ch = expr.charAt(index);
                    temp+=ch;
                    index++;
                }
                resList.add(temp);
                temp="";
            }else {
                resList.add(ch+"");
                index++;
            }
        }
        return resList;
    }
    public static int getPriority(String opr){
        if (opr.equals("+") || opr.equals("-")){
            return Level_1;
        }else if (opr.equals("*") || opr.equals("/")){
            return Level_2;
        }else {
            System.out.println("不支持");
            return Level_0;
        }
    }
}
