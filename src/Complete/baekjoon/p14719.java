package Complete.baekjoon;

import java.util.Scanner;

public class p14719 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int nums [] = new int[m];
        for(int i=0;i<m;i++){
            nums[i]=sc.nextInt();
        }
        int ans=0;

        for(int i=0;i<m;i++){
            // 왼
            int lm = 0;
            for(int j=0;j<=i;j++){
                lm = Math.max(nums[j],lm);
            }

            // 오
            int rm=0;
            for(int j=i;j<m;j++){
                rm = Math.max(nums[j],rm);
            }

            ans+=Math.min(lm,rm) - nums[i];
        }

        System.out.println(ans);


    }
}
