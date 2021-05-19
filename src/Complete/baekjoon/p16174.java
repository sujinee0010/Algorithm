package Complete.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


/*
* visited[][] -> false로 하는 거 없애니까 시간초과 해결됌
* 의문점 ... 이미 가다가 실패한 경로의 일부분을 건너야만 성공할 경로가 나올수도 있지 않나 ..
* 정답은 오, 아 로 만 가면되어서 .. 굳이 체크할 필요없다 ... 일단 도착하기만 하면 되어서.. 그런 듯
* */
public class p16174 {
    public static int dfs(int n, int i, int j, int[][] arr, boolean visited[][]){
        int ans = 0;
        if(i==n-1 && j==n-1){
            return 1;
        }else{

            int go_Cnt = arr[i][j];
            // 오
            if (i < n  && j+go_Cnt <n && !visited[i][j+go_Cnt]){
                visited[i][j+go_Cnt] = true;
                ans += dfs(n, i ,j+go_Cnt,arr,visited);
                //visited[i][j+go_Cnt] = false;
            }
            // 아래
            if (i+go_Cnt < n  && j <n && !visited[i+go_Cnt][j]){
                visited[i+go_Cnt][j] = true;
                ans += dfs(n, i+go_Cnt ,j,arr,visited);
                //visited[i+go_Cnt][j] = false;
            }
        }

        return ans;
    }


    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][n];
        boolean visited[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        if (dfs(n,0,0,arr,visited)==0)
            System.out.println("Hing");
        else
            System.out.println("HaruHaru");


    }
}
