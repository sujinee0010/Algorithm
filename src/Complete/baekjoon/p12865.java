package Complete.baekjoon;

import java.util.*;
import java.io.*;

public class p12865 {
    static int weight = 0;
    static int N = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        weight = Integer.parseInt(str.nextToken());

        int dp[][] = new int[N+1][weight+1];

        for (int i=1;i<=N;i++){
            str = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(str.nextToken());
            int val = Integer.parseInt(str.nextToken());

            // 현재 배낭을 맨다 , 안맨다
            for(int j=1;j<=weight;j++){
                dp[i][j] = dp[i-1][j];
                if(j-w>=0)
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-w]+val);
            }

        }







//        //메모이제이션용 2차원 배열
//        for(int i=1; i<=N; i++) {
//            str = new StringTokenizer(br.readLine());
//            int inputWeight = Integer.parseInt(str.nextToken());
//            int value= Integer.parseInt(str.nextToken());
//
//            for(int j=1; j<=weight; j++){ // 1부터 7 끼지
//                dp[i][j] = dp[i-1][j];
//                //먼저 기존 값을 넣는다.
//                if(j-inputWeight>=0){
//                    // 해당차례 물건을 않담는 경우 & 해당 차례 물건을 담는 경우
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-inputWeight]+value);
//                    // 기존 값과 value를 더한 새로운 값 중 큰 것을 dp배열에 넣기
//                }
//            }
//        }

        System.out.print(dp[N][weight]);
    }
}
