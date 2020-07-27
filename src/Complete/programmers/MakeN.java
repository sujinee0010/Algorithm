package Complete.programmers;

import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
//프로그래머스 N으로 표현 
public class MakeN {
    static int count = 0;
    public static int solution(int N, int number) {
        String n = Integer.toString(N);
        int rN [] = new int[9];
        for(int i=1;i<=8;i++){
            String repeatedN = Stream.generate(() -> n ).limit(i).collect(joining());
            rN[i]= Integer.parseInt(repeatedN);
        }
        dfs(N,rN,number,0,  0);
        if(count==0)
            return -1;
        else
            return count;
    }
    private static void   dfs(int N, int[] rN, int number, int cnt, float result) {
        if(result == (float) number && cnt<=8) {
            if(count == 0) count = cnt;
            else count = Math.min(cnt,count);
        }
        else if(cnt<=8) {
            for (int i = 1; i < rN.length; i++) {
                dfs(N, rN, number, cnt + i,  result + rN[i]);
                dfs(N, rN, number, cnt + i, result - rN[i]);
                if(result!=0)
                dfs(N, rN, number, cnt + i, result / rN[i]);
                dfs(N, rN, number, cnt + i, result * rN[i]);
            }
        }

    }
}
