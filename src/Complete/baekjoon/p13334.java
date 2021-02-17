package Complete.baekjoon;

import java.util.*;

public class p13334 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<int[]> queue =new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        PriorityQueue<Integer> starts = new PriorityQueue<>();
        for (int i=0;i<n;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            queue.add(new int[]{Math.min(s,e),Math.max(s,e)});
        }
        int limit = sc.nextInt();
        int ans=0;
        while (!queue.isEmpty()){
            int line[] = queue.poll();
            if(line[1]-line[0]<=limit){
                starts.add(line[0]);

                while(starts.peek() < line[1]-limit){
                        starts.poll();
                }
                ans = Math.max(ans,starts.size());
            }

        }

        System.out.println(ans);

    }
}
