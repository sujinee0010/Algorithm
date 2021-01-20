package Complete.programmers;
import java.util.*;
/*
* 숫자 게임
* */
public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int aidx=0; int bidx=0;

        while(aidx<A.length && bidx<B.length){
            if(A[aidx] < B[bidx]){
                answer++;
                aidx++; bidx++;
            }else{
                bidx++;
            }

        }
        return answer;
    }
}

