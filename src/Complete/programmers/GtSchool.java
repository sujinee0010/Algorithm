package Complete.programmers;
/*
* 프로그래머스 등굣길 DP
* - 가장자리에도 웅덩이가 있을 수 있음을 주의 !
* */
public class GtSchool {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n+1][m+1];
        for(int i=0;i<puddles.length;i++){
            arr[puddles[i][1]][puddles[i][0]] = -1;
        }
        arr[1][1]=1;
        for(int i=1;i<arr.length;i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (i == 1 && j == 1) continue;
                if (arr[i][j] == -1)
                    arr[i][j] = 0;
                else
                    arr[i][j] = (arr[i][j - 1] + arr[i - 1][j]) % 1000000007;
            }
        }
        return arr[n][m];
    }
}
