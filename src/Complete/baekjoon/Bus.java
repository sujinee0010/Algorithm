package Complete.baekjoon;

import java.util.*;
public class Bus {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 5
        int b = sc.nextInt(); // 8
        ArrayList<int[]>[] arr = new ArrayList[n+1];
        for (int i=0;i<arr.length;i++){
            arr[i] = new ArrayList();
        }

        for(int i=0;i<b;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int val = sc.nextInt();
            arr[start].add(new int[]{end,val});
        }

        int s = sc.nextInt();
        int e = sc.nextInt();

        int [] distance = new int[n+1];
        for(int i=0;i<distance.length;i++){
            distance[i]=987654321;
        }

        distance[s] = 0 ;



        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o->o[1]));
        queue.add(new int[]{s,0});

        while (!queue.isEmpty()){
            // 시작점 1,0 (비용)
           int num_distance[] = queue.poll();
           // 연결된 점
           for (int i=0;i<arr[num_distance[0]].size();i++){
               // 2 , 비용
               int next_distance[] = arr[num_distance[0]].get(i);
               // 이미 기록된 다음 거리 비용 >시작 거리 비용 + 연결된 점 거리 비용
               if(distance[next_distance[0]] > num_distance[1] + next_distance[1]){
                   distance[next_distance[0]] = num_distance[1] + next_distance[1];

                   queue.add(new int[]{next_distance[0] , distance[next_distance[0]] });
               }
           }

        }


        System.out.println(distance[e]);

    }


}
