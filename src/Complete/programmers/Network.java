package Complete.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Network {
    //프로그래머스 네트워크
    static ArrayList arr[] ;
    static boolean cheked[];
    public int solution(int n, int[][] computers) {
        int answer = 0;

        arr = new ArrayList[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = new ArrayList();
        }
        cheked = new boolean[n];

        for (int i=0;i<computers.length;i++) {
            for (int j=0;j<computers[i].length;j++){
                if(i==j) continue;

                if(computers[i][j] == 1)
                    arr[i].add(j);
            }
        }

        for(int i=0;i<arr.length;i++){
            if(cheked[i] == false){
                bfs(i);
                answer++;
            }
        }
        return answer;
    }

    private void bfs(int cnum) {

        Queue<Integer> q = new LinkedList<>();

        q.add(cnum);
        cheked[cnum] = true;

        while(!q.isEmpty()){

            int node = q.poll();

            for(int i=0;i<arr[node].size();i++){
                int next = (int)arr[node].get(i);
                if(cheked[next] == false){
                    q.add(next);
                    cheked[next] = true;
                }
            }
        }
    }

}
