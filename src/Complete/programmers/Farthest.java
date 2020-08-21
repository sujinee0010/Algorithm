package Complete.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// 프로그래머스 그래프  가장 먼 노드
public class Farthest {
    static ArrayList node[];
    static boolean visited[];
    static int len[];
    static int max;
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        node = new ArrayList[n+1];
        visited = new boolean[n+1];
        len = new int[n+1];

        for(int i=0;i<node.length;i++)
            node[i] = new ArrayList<Integer>();

        for (int i=0;i<edge.length;i++){
            int n1 = edge[i][0]; int n2 = edge[i][1];
            node[n1].add(n2);
            node[n2].add(n1);
        }
        bfs();
        answer = (int) Arrays.stream(len).filter(x->x==max).count();
        return answer;
    }

    private static void bfs() {
        Queue queue = new LinkedList();
        queue.add(1);
        visited[1]=true;
        len[0]=0; len[1]=1;
        max=1;
        while(!queue.isEmpty()){
            int n = (int) queue.poll();
            for(int i=0;i<node[n].size();i++){
                int next = (int) node[n].get(i);
                if(!visited[next]){
                    queue.add(next);
                    visited[next] =true;
                    len[next]=len[n]+1;
                    max = Math.max(max,len[next]);
                }
            }
        }

    }
}
