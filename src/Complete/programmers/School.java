package Complete.programmers;
//최단거리 수 , 대각선의 합 , DP,  프로그래머스 등굣길
public class School {
    public static int solution(int m, int n, int[][] puddles) { // m이 행  n이 열 , 퍼들은 웅덩이 좌표
      int dp[][] = new int[m+1][n+1];
      for(int i=0;i<puddles.length;i++) // 웅덩이 0
          dp[puddles[i][0]][puddles[i][1]] = -1;
      dp[1][1]=1;
      for(int i=1;i<dp.length;i++){
          for(int j=1;j<dp[i].length;j++){
              if(dp[i][j]==-1){
                  dp[i][j] =0;
              }else{
                  if(i==1) {//끝쪽
                    dp[i][j] += dp[i][j-1];
                  }else{
                      dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                  }
              }
          }
      }
      return dp[m][n];
    }
}
