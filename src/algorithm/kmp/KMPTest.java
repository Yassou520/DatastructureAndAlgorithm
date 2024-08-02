package algorithm.kmp;

public class KMPTest {
    public static void main(String[] args) {
        String s = "ABABABBCD";
        String P = "ABB";
        System.out.println(kmp(s,P));
    }
    public static int kmp(String s,String pattern){
        int[] next = next(pattern);
        for (int i=0,j=0;i<s.length();i++){
            while (j>0&&s.charAt(i)!=pattern.charAt(j)){
                j=next[j-1];
            }
            if (s.charAt(i)==pattern.charAt(j)){
                j++;
            }
            if (j==pattern.length()){
                return i-j+1;
            }
        }
        return -1;
    }
    public static int[] next(String pattern){
        int len = pattern.length();
        int[] next = new int[len];
        for (int i=1,j=0;i<len;i++){
            while (j>0&&pattern.charAt(i)!=pattern.charAt(j)){
                j=next[j-1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
