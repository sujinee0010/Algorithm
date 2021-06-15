package Complete.baekjoon;

import java.util.*;

public class p2186 {
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int n , m , k ;
    static char arr[][];
    static int dp[][][];
    static String word;

    private static int dfs(int idx , int x , int y) {
        if (idx == word.length()-1) return dp[x][y][idx]=1;
        if (dp[x][y][idx] !=-1) return dp[x][y][idx];

        // 방문 처리
        dp[x][y][idx] = 0;

        for(int i=0;i<4;i++){
            for ( int j = 1; j<=k ;j++) {
                int nx = x + dx[i]*j;
                int ny = y + dy[i]*j;

                if(nx>=0&&nx<n&&ny>=0&&ny<m && arr[nx][ny]==word.charAt(idx+1)){
                        dp[x][y][idx] += dfs(idx+1,nx,ny);
                }
            }
        }

        return dp[x][y][idx];

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
        int ans = 0;

        arr = new char[n][m];
        for(int i=0;i<n;i++){
            arr[i] = sc.next().toCharArray();
        }
        word = sc.next();
        dp = new int[n][m][word.length()];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j] ,-1);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (arr[i][j] == word.charAt(0)) {
                    ans += dfs(0, i, j);
                }
            }
        }

        System.out.println(ans);

    }

}
