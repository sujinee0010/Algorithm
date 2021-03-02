package Complete.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class p1662 {
    static int[] paren = new int[50];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int ans =0;
        Stack<Integer> in = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') in.push(i); //11 12 13
            if(s.charAt(i)==')') paren[in.pop()]=i;
        }

        ans = trans(0,s.length(),s);
        System.out.println(ans);

    }
    public static int trans(int start , int end, String s){
        int len =0;

        for(int i=start;i<end;i++){
            if (s.charAt(i)=='('){
                len += Character.getNumericValue(s.charAt(i-1)) * trans(i+1,paren[i], s) - 1 ;
                i = paren[i];
            }
            else
                len++;
        }

        return len;
    }
}
