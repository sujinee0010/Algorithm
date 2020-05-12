package Complete;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AddSum {

    //백준 연속합
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int[] arr = new int[N];
        int[] dp = new int[N];

        int max;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }


        dp[0] = arr[0];
        max = arr[0];

        for(int i=1; i<N; i++){

            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);

            System.out.println(dp[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }

/*
    private static int arr[];
    private static int result[];
    private static int max=1001;
    public static void main(String args[]) throws Exception {

      //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        result = new int[n];

        for(int i =0; i< n; i++){

            int num = sc.nextInt();
            arr[i] = num;

        }

        dp();
        System.out.println(max);


    }

    private static void dp() {

        // 누적합 구한다
       // int max=1001;

        // 젤 큰 수
        for(int i=0;i<arr.length;i++){

            int sum=0;
            for(int j=i;j<arr.length;j++){

                sum+=arr[j];

                if(max==1001)max=sum;
                else max = Math.max(max,sum);


            }
        }
    }

*/
}
