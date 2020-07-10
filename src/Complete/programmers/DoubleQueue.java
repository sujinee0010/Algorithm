package Complete.programmers;

import java.util.Collections;
import java.util.PriorityQueue;
// 프로그래머스 이중우선순위큐 
public class DoubleQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue q = new PriorityQueue(); // 작은 수
        PriorityQueue rq = new PriorityQueue(Collections.reverseOrder()); // 큰 수
        for(int i=0;i<operations.length;i++){
            String op = operations[i];
            int num;
            if(op.charAt(0)=='I'){
                if(op.charAt(2)=='-') num = Integer.parseInt(op.substring(3)) * -1;
                else num = Integer.parseInt(op.substring(2));
               q.add(num);
               rq.add(num);
            }else if(op.equals("D 1") && !q.isEmpty()){ // 최대
               num = (int) rq.poll();
               q.remove((Object)num);
            }else if(op.equals("D -1") && !q.isEmpty()){
                num = (int) q.poll();
                rq.remove((Object)num);
            }
        }
        if(q.isEmpty()) answer[1]=0;
        else answer[1]= (int) q.poll();
        if (rq.isEmpty()) answer[0]=0;
        else answer[0]= (int) rq.poll();
        return answer;
    }

}
