package Complete.groom;
import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Rock {
    //구름: 징검다리 건너기
    static long arr[];
    static long dp[];

    public static void main (String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new long[n+2]; // 9
        dp = new long[n+2];  // 9

        arr[0]=0;
        arr[n+1]=0;


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=n;i++){
            arr[i]= Long.parseLong(st.nextToken());
        }

        dp(n+1);
        System.out.println(dp[n+1]);


    }



    private static void dp(int num) {

        for(int i=0;i<=num;i++){
            if(i==2) {
                dp[i]= Math.min(dp[1]+arr[2],dp[0]+arr[2]);
                continue;
            }
            if(i==1) {
                dp[i]= dp[0]+arr[1];
                continue;
            }
            if(i==0) {
                dp[i]= 0;
                continue;
            }

            long n1 = dp[i - 1] + arr[i];

            long n2 = dp[i - 2] + arr[i];

            long n3 = dp[i - 3] + arr[i];

            dp[i] = Math.min(n1, Math.min(n2, n3));

        }


    }


}