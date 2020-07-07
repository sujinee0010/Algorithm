package Complete.programmers;

import java.util.*;
// 프로그래머스 라면 공장
public class RamenFactory  {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int idx=0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<k;i++){
            if(idx<dates.length && dates[idx]==i)
                q.add(supplies[idx++]);
            if(stock==0) {
                stock += q.poll();
                System.out.println(i);
                answer++;
            }
            stock-=1;
        }
        return answer;
    }
}
