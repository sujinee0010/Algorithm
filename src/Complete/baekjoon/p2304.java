package Complete.baekjoon;


import java.util.Scanner;

public class p2304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX = 10001;
        int n = sc.nextInt();

        int[] nums = new int[MAX];

        for (int i=0;i<n;i++){
            nums[sc.nextInt()] = sc.nextInt();
        }


        int ans =0;
        for (int i=0;i<nums.length;i++){
            // lm
            int lm = 0;
            for (int j=0;j<=i;j++)
                lm = Math.max(lm,nums[j]);
            // rm
            int rm = 0;
            for (int j=i;j<nums.length;j++)
                rm = Math.max(rm,nums[j]);


            ans += Math.min(lm,rm);

        }

        System.out.println(ans);


    }
}
