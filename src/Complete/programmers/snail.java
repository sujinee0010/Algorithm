package Complete.programmers;

public class snail {
    public static int[] solution(int n) {
        int[][] num_arr = new int[n+1][n+1];
        int[]ans = new int[(n*(n+1)/2)];
        int x=0, y=0; //행, 열 좌표
        int num = 1; // 기록할 숫자
        for(int i=0;i<n;i++){
            for(int j=n-i;j>=1;j--) {
                //down
                if (i % 3 == 0)
                    x++;
                //left
                else if (i % 3 == 1)
                    y++;
                //up
                else if (i % 3 == 2) {
                        x--;
                        y--;
                }
                num_arr[x][y] = num++;
            }
        }
        int idx=0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++) {
                if (num_arr[i][j]==0)break;
                ans[idx++] = num_arr[i][j];
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        solution(6);
    }
}
