package Complete.programmers;

import java.util.*;

public class pdisck {
    public static int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        PriorityQueue<int[]> working = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int time = 0;
        int cnt = 0;
        int sum = 0;

        while (cnt < jobs.length){
            // 도착했을떄 큐에 넣는다
            for(int i=0;i<jobs.length;i++){
                int start = jobs[i][0]; // 요청 시간
                int end = jobs[i][1]; // 소요시간
                if(time == start){
                    pq.add(new int[]{start , end});
                }
            }

            // 끝날 시간이 다 되었으면 꺼내준다
            if(!working.isEmpty() && working.peek()[1] == time){
                int tmp [] = working.poll();
                sum += tmp[1] - tmp[0];
                cnt++;
                System.out.println(tmp[1]);
            }

            // 지금 실행중인 게 없으면 실행한다
            if (working.isEmpty() && !pq.isEmpty()){
                int w[]= pq.poll();
                // 요청 시간 , 작업 끝날 시간
                working.add(new int[]{w[0] , time+w[1] });
            }



            time++;
        }

        return  sum / jobs.length;

    }

    //import java.util.*;
    class Solution2 {
        public int solution(int[][] jobs) {
            int answer = 0 , time = 0, idx = 0;
            int len = jobs.length;
            Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); //작업시간 짧은 순으로
            Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));// 도착 시간 이른 순으로  job

            while (idx < len || !q.isEmpty()) {
                while (idx < len && jobs[idx][0] <= time)
                    q.offer(jobs[idx++]);


                int[] job = q.poll(); // 뽑아
                answer += time - job[0] + job[1];
                time += job[1]; // 추가

            }
            return answer / len;
        }
    }
    public static void main(String args[]){
        int t [][] ={{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(t));
    }
}
