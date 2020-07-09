package Complete.programmers;

import java.util.*;

public class Disk  {
    public static int solution(int[][] jobs) {
        int answer = 0 , time = 0, idx = 0;
        int len = jobs.length;
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); //작업시간 짧은 순으로
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));// 도착 시간 이른 순으로  job
        while (idx < len || !q.isEmpty()) {
            while (idx < len && jobs[idx][0] <= time)
                q.offer(jobs[idx++]);
            if (q.isEmpty())
                time = jobs[idx][0];
            else {
                int[] job = q.poll(); // 뽑아
                answer += time - job[0] + job[1];
                time += job[1]; // 추가
            }
        }
        return answer / len;
    }
/*
    public static void main(String args[]) {
        int a[][] = {{0, 3}, {1, 9}, {2, 6}};
        solution(a);
    }
*/
}

