package Complete.baekjoon;

import java.util.Scanner;

public class p2824 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long num1 =1;
        for(int i=0;i<n;i++)
            num1*=sc.nextInt();

        int m = sc.nextInt();
        long num2 =1;
        for(int i=0;i<m;i++)
            num2*=sc.nextInt();

        String ans ="";
        ans = Long.toString(gcd(num1 , num2));

        if(ans.length()>9)
            ans = ans.substring(ans.length()-9);


        System.out.println(ans);
    }

    private static long gcd(long num1, long num2) {
        if(num2==0)
            return num1;
        else
            return  gcd(num2 , num1%num2);

    }
}
