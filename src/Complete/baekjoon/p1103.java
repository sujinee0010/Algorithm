package Complete.baekjoon;

import java.util.Scanner;

public class p1103 {
    static int dx[] ={-1,1,0,0};
    static int dy[] ={0,0,-1,1};
    static int row;
    static int col;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        row =sc.nextInt();
        col =sc.nextInt();
        Character nums[][] = new Character[row][col];
        int dp[][] = new int[row][col];

        for(int i=0;i<nums.length;i++){
            String S = sc.next();
            for(int j=0;j<S.length();j++){
                nums[i][j]=S.charAt(j);
                dp[i][j]=-1;
            }
        }

        dp[0][0]=1;
        int ans = dfs(dp , nums, 0 , 0 ,1);
        if(ans==987654321)
            ans=-1;
        System.out.println(ans);



    }

    private static int dfs(int[][] dp, Character[][] nums, int x, int y , int cnt ) {
        //System.out.println(cnt+","+nums[x][y]);
        int ans =  cnt;
        for(int i=0;i<4;i++){
            int nx = x+ dx[i]*Character.getNumericValue(nums[x][y]);
            int ny = y+ dy[i]*Character.getNumericValue(nums[x][y]);

            if(nx>=0 && nx<row && ny>=0 && ny<col){
                //System.out.println("--"+i+","+nx+","+ny);
                if(nums[nx][ny] == nums[x][y])
                    return 987654321;

                if(nums[nx][ny]!='H')
                    ans  = Math.max(ans,dfs(dp,nums,nx,ny,cnt+1));


//                dp[nx][ny] = dp[x][y]+1;
//                dfs(dp,nums,x,y);
            }
        }

        return ans;
    }


}
