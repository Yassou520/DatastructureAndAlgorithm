package test;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class HWTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        String[] strings = new String[n];
        for (int i=0;i<n;i++){
            strings[i] = in.nextLine();
        }
        Arrays.sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }
}
}
