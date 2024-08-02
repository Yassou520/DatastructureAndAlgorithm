package stack;

public class MyCalculator {
    public static void main(String[] args) throws Exception {
        MyStack<Integer> numStack = new MyStack<>(100);
        MyStack<Character> oprStack = new MyStack<>(100);
        String expression = "7*7-5+5*6-20";
        int n = expression.length();
        int index = 0;
        while (index < n){
            char ch = expression.charAt(index);
            if (!isDigital(ch)){
                if (oprStack.isEmpty()){
                    oprStack.push(ch);
                }else if (getPriority(oprStack.peek())>=getPriority(ch)){
                    int num2=numStack.pop();
                    int num1=numStack.pop();
                    char opr=oprStack.pop();
                    int res = calc(num1,num2,opr);
                    oprStack.push(ch);
                    numStack.push(res);
                }else {
                    oprStack.push(ch);
                }
                index++;
            }else {
                int t =0;
                while (index<n&&isDigital(expression.charAt(index))){
                    ch = expression.charAt(index);
                    int num = ch-'0';
                    t=t*10+num;
                    index++;
                }
                numStack.push(t);
            }
        }
        while (!oprStack.isEmpty()){
            int num2=numStack.pop();
            int num1=numStack.pop();
            char opr = oprStack.pop();
            int res = calc(num1,num2,opr);
            numStack.push(res);
        }
        System.out.println(expression+"="+numStack.pop());
    }
    public static boolean isDigital(char c){
        return Character.isDigit(c);
    }
    public static int getPriority(char c){
        if (c=='*' || c=='/'){
            return 3;
        }else if (c=='+' || c=='-'){
            return 2;
        }else {
            return -1;
        }
    }
    public static int calc(int num1,int num2,char opr){
        int res=0;
        switch (opr){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num1 - num2;
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
