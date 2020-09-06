package Complete.programmers;

import java.util.*;
//우선순위 큐 ...
public class Overtime {
    public static long solution(int n, int[] works) {
        long answer= 0;
        PriorityQueue<Integer> pworks = new PriorityQueue(Comparator.reverseOrder());
        Arrays.stream(works).forEach(x-> pworks.add(x));
        while (n>0){
            int num = pworks.poll();
            if(num>0)
                num-=1;
            pworks.add(num);
            n--;
        }
        while (!pworks.isEmpty())
            answer+= Math.pow(pworks.poll(),2);
        return answer;
    }
    /*
    public static void main(String args[]){
        int n[] ={1,1};
        System.out.println(solution(3,n));

    }
     */
}
