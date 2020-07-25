package Complete.programmers;

import java.util.Arrays;
//프로그래머스 H-Index
public class H_Index {
    public int solution(int[] citations) {
        int answer = -1;
        Arrays.sort(citations);
        int len = citations.length;
        for(int i=0;i<citations.length;i++){
            if(len-i < citations[i]) {
                answer=Math.max(answer,len-i);
                break;
            }else
                answer=Math.max(answer,citations[i]);
        }
        return answer;
    }
}
