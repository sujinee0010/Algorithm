package Complete.programmers;
//프로그래머스 더맵게 
import java.util.PriorityQueue;
public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();//숫자는 낮은 것이 우선순위를 높게
        for(int i=0;i<scoville.length;i++)
            priorityQueue.add(scoville[i]);
        if(priorityQueue.stream().allMatch(x->x==0)) return 0;
        while(!priorityQueue.isEmpty()){
            if(priorityQueue.stream().allMatch(x->x>=K)) return answer;
            if(priorityQueue.size()>=2) {
                int num1 = priorityQueue.poll();
                int num2 = priorityQueue.poll();
                int mixscore = num1 + (num2 * 2);
                priorityQueue.add(mixscore);
                answer++;
            }else{
                if(priorityQueue.stream().allMatch(x->x>=K)) return answer;
                else return -1;
            }
        }
        return answer;
    }
}
