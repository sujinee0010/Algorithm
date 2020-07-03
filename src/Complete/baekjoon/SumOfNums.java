package Complete.baekjoon;

import java.util.Scanner;
//백준 2003 수들의합2, 투 포인터
public class SumOfNums {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int result = 0, sum = 0, lo = 0, hi = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        while(true){
            if(sum >= m) sum -= arr[lo++];
            else if(hi == n) break;
            else sum += arr[hi++];
            if(sum == m) result++;
        }
        System.out.println(result);

    }
}
