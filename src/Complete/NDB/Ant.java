package Complete.NDB;

import java.util.Scanner;

public class Ant {
    /*
    * i번째 식량 창고 까지 최적의 해
    * 점화식 : ai = max(ai-1 ,ai-2+ki)
    * */
    public static int solution(int n, int arr[] ){
        int dp[] = new int[100];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        return dp[n-1];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a [] = new int[n];
        for (int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solution(n ,a));
    }
}
