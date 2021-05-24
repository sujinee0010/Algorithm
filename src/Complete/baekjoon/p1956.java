package Complete.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p1956 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int ans = 987654321;
        int arr[][] = new int[v+1][v+1];

        for(int i=0;i<arr.length;i++)
            Arrays.fill(arr[i],987654321);

        for(int i=0;i<e;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            arr[a][b] = c;
        }



        for (int k=1;k<v+1;k++){
            for (int i=1;i<v+1;i++){
                for (int j=1;j<v+1;j++){
                    arr[i][j] = Math.min(arr[i][j] , arr[i][k]+arr[k][j]);
                }
            }
        }

        for (int i=1;i<v+1;i++){
            //System.out.println(arr[i][i]);
            if( arr[i][i] < 987654321)
                ans = Math.min(ans , arr[i][i]);
        }

        if (ans == 987654321)
            ans = -1;

        System.out.println(ans);

    }
}
