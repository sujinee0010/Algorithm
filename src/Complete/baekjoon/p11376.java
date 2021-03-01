package Complete.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p11376 {
    static boolean c[];
    static int d[];
    static ArrayList[] can;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사람
        int m = sc.nextInt(); // 일

        // 일 점유 여부  -> dfs 돌 때마다 갱신됨
        c = new boolean[m + 1];
        // 일 점유하고 있는 노드
        d = new int[m+1];
        can = new ArrayList[n+1];
        // 일 점유

        for(int i=1;i<=n;i++) {
            int cnt = sc.nextInt();
            can[i] = new ArrayList();
            for (int j = 0; j < cnt; j++)
                can[i].add(sc.nextInt());
        }


        int ans=0;
        for (int i=1;i<=n;i++)
        {
            for (int j=0;j<2;j++){
                Arrays.fill(c , false);
                if(dfs(i)) ans++;
            }
        }

        System.out.println(ans);


    }

    private static boolean dfs(int person) {
        for (int i=0;i<can[person].size();i++){
            int work = (int) can[person].get(i);

            if(c[work]) continue;
            c[work] = true;

            if( d[work] ==0 || dfs(d[work]))
            {
                d[work] =person;
                return true;
            }

        }
        return false;
    }
}
