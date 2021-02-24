package Complete.baekjoon;

import java.util.Scanner;

public class p14500 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int ans=0;
        // 1 -1
        for(int i=0;i<n;i++) {
            for (int j = 0; j + 3 < m; j++) {
                ans = Math.max(ans , arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3]);
            }
        }
        // 1 - 2
        for(int i=0;i<m;i++) {
            for (int j = 0; j + 3 < n; j++) {
                ans = Math.max(ans , arr[j][i]+arr[j+1][i]+arr[j+2][i]+arr[j+3][i]);
            }
        }
        //4-4 & 5-4 & 7 & 9   // 2 정사각형 3. ㅜ
        for(int i=0;i<n-1;i++){
            for(int j=0;j+2<m;j++){
                ans = Math.max(ans ,arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j+2]);
                ans = Math.max(ans ,arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j]);
                ans = Math.max(ans ,arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2]);
                ans = Math.max(ans ,arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+2]);
                ans = Math.max(ans , arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]);
            }
            for(int j=0;j<m-1;j++){
                ans = Math.max(ans , arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+1][j+1]);
            }
        }
        // 3. ㅗ  //4-3 // 5-1
        for(int i=1;i<n;i++){
            for(int j=0;j+2<m;j++){
                ans = Math.max(ans , arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i-1][j+1]);
                ans = Math.max(ans ,arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i-1][j+2]);
                ans = Math.max(ans ,arr[i][j]+arr[i][j+1]+arr[i-1][j+1]+arr[i-1][j+2]);
            }
        }

        // 5-2 & 3 & 8 &  3. ㅏ &  4-1
        for(int i=0;i+2<n;i++){
            for(int j=0;j<m-1;j++){
                ans = Math.max(ans ,arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j+1]);
                ans = Math.max(ans ,arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+2][j+1]);
                ans = Math.max(ans ,arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i][j+1]);
                ans = Math.max(ans ,arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j+1]);
                ans = Math.max(ans ,arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j+1]);
            }
            // 5- 6 // 4-2 // 3. ㅓ
            for(int j=1;j<m;j++){
                ans = Math.max(ans ,arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j-1]);
                ans = Math.max(ans , arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j-1]);
                ans = Math.max(ans ,arr[i][j]+arr[i+1][j]+arr[i+1][j-1]+arr[i+2][j-1]);

            }
        }

        System.out.println(ans);
    }
}
