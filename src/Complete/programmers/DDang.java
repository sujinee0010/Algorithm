package Complete.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DDang {
    int solution(int[][] land) {
        int answer = 0;
        int arr[][] = new int[land.length][4];
        for(int i=0;i<land[0].length;i++){
            arr[0][i]=land[0][i];
        }

        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){                                                  for(int h=0;h<4;h++){
                if (h==j) continue;
                arr[i][j] = Math.max(arr[i][j], land[i][j] + arr[i-1][h]);
            }
            }
        }

        for(int i=0;i<4;i++){
            answer = Math.max(answer , arr[land.length-1][i]);
        }

        return answer;
    }
}

