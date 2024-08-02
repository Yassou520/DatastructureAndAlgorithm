package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeSolution {
    public static Map<Character,Integer> priorityMap = new HashMap<>(){{
        put('(',1);
        put('+',1);
        put('-',1);
        put('*',1);
        put('/',1);
    }};
    public static void main(String[] args) {
        LeetCodeSolution leetCodeSolution = new LeetCodeSolution();
        int calculate = leetCodeSolution.calculate("- 2-1 + 2 ");
        System.out.println(calculate);
    }
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        s = s.replace(" ", "");
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i=0;i<len;i++) {
            char ch = chars[i];
            if (isNum(ch)){
                int t =0;
                while (i<len && isNum(s.charAt(i))){
                    ch = chars[i++];
                    t=t*10+(ch-'0');
                }
                nums.addLast(t);
                i=i-1;
            }else {
                if (ch=='('){
                    if (chars[i+1]=='-'){
                        nums.addLast(0);
                    }
                    ops.addLast(ch);
                }else if (ch==')'){
                    while (!ops.isEmpty()&&ops.peekLast()!='('){
                        int num1 = nums.pollLast();
                        int num2 = nums.pollLast();
                        char opr = ops.pollLast();
                        int res = calc(num2, num1, opr);
                        nums.addLast(res);
                    }
                    ops.pollLast();
                }else {
                    if (ch=='-'&&nums.isEmpty()){
                        nums.addLast(0);
                    }
                    while (!ops.isEmpty()&&priorityMap.get(ops.peekLast())>=priorityMap.get(ch)){
                        int num1 = nums.pollLast();
                        int num2 = nums.pollLast();
                        char opr = ops.pollLast();
                        int res = calc(num2, num1, opr);
                        nums.addLast(res);
                    }
                    ops.addLast(ch);
                }
            }
        }
        while (!ops.isEmpty()){
            int num1 = nums.pollLast();
            int num2 = nums.pollLast();
            char opr = ops.pollLast();
            int res = calc(num2, num1, opr);
            nums.addLast(res);
        }
        return nums.pollLast();
    }
    public boolean isNum(char c){
        return Character.isDigit(c);
    }
    public int calc(int num1,int num2,char opr){
        int res=0;
        switch (opr){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num1-num2;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num1/num2;
                break;
            default:
                break;
        }
        return res;
    }
}
