package Complete.programmers;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 네트워크 bfs
public class Network2021 {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean isVisited[] = new boolean[n];
        for (int i = 0; i < computers.length; i++) {
            if (!isVisited[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int row = q.poll();
                    isVisited[row] = true;
                    for (int j = 0; j < computers[row].length; j++) {
                        if (j == row) continue;
                        if (computers[row][j] == 1 && !isVisited[j]) {
                            q.add(j);
                        }
                    }
                }
                answer += 1;
            }
        }
        return answer;
    }

    public static void main(String args[]){
        int c[][]= {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(3,c));
    }

}
