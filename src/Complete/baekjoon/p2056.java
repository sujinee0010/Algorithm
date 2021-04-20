package Complete.baekjoon;
import java.awt.*;
import java.util.*;

public class p2056 {
    public static int work(ArrayList graph[] , int input[] , int time[]){
        int ans = 0 ;
        // 진입차수 0 인거 큐에 넣기
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.y));
        for(int i =1 ;i<input.length;i++){
            if(input[i]==0)
                queue.add(new Point(i , time[i]));
        }

        while(!queue.isEmpty()){
            Point wt = queue.poll();
            int w = wt.x;
            int t = wt.y; //time[w]; // 시간

            ans = Math.max(ans,t);

            for(int i=0;i<graph[w].size();i++){
                int nxt = (int) graph[w].get(i);
                input[nxt]-=1;

                if (input[nxt]==0) {
                    time[nxt] += t;
                    queue.add(new Point(nxt,time[nxt]));

                }
            }
        }


        System.out.println(ans);
        return ans;
    }


    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList graph[] = new ArrayList[n+1];
        int input[] = new int[n+1];
        int time[] = new int[n+1];

        for(int i=1;i<n+1;i++){
            graph[i] = new ArrayList();
            time[i] = sc.nextInt();
            int ncnt = sc.nextInt();
            input[i] = ncnt;
            for(int j=0;j<ncnt;j++){
                graph[sc.nextInt()].add(i);
            }
        }

        work(graph,input,time);
    }
}
