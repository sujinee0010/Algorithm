package Complete.programmers;
//프로그래머스 정수 삼각형
public class IntTriangle {
    public static int solution(int[][] triangle) {
        int answer = -1;

        int [][] dp = new int[triangle.length][];
        for(int i=0;i<dp.length;i++){
            dp[i]= new int [triangle[i].length];
        }

        for(int i=0;i<triangle.length-1;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(i==0) dp[0][0] = triangle[0][0];

                dp[i+1][j] = Math.max(dp[i+1][j],triangle[i+1][j] + dp[i][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1],triangle[i+1][j+1] + dp[i][j]);
                answer= Math.max(answer,Math.max(dp[i+1][j],dp[i+1][j+1]));
            }
        }
        return answer;
    }
}
