package Complete.groom;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MakeWater {
    // 비타 알고 4월 1주차 물약제조
    static  int  a ,b,a_goal,b_goal;

    static  int arr[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         a = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());


         arr = new int [a+1][b+1];

         for(int i=0;i<arr.length;i++){
             Arrays.fill(arr[i],0);
         }

        st = new StringTokenizer(br.readLine());

        a_goal = Integer.parseInt(st.nextToken());
        b_goal = Integer.parseInt(st.nextToken());


        bfs();

    }

    private static void bfs() {

        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0,0));
        arr[0][0]=1;

        while(!q.isEmpty()){

            Point node = q.poll();

           final int x = node.x;
           final int y = node.y;
           final int dep = arr[x][y];

            if( x == a_goal && y == b_goal){
                System.out.println(arr[x][y]);
                return;
            }

            // 액체 다버리기
            if(arr[0][y]== 0) {
                q.add(new Point(0, y));
                arr[0][y]=dep+1;
            }
            if(arr[x][0]== 0) {
                q.add(new Point(x, 0));
                arr[x][0]=dep+1;
            }
            // 액체 가득 채우기
            if(arr[a][y]== 0) {
                q.add(new Point(a, y));
                arr[a][y]=dep+1;
            }
            if(arr[x][b]== 0){
                q.add(new Point(x, b));
                arr[x][b]=dep+1;
            }

            // 액체 옮기기

          if(x+y<=b && arr[0][x+y]==0) {
              q.add(new Point(0, x + y));
              arr[0][x+y]=dep+1;
          }
          else  if(x+y > b && arr[x - (b - y)][b] == 0) {
              q.add(new Point(x - (b - y), b));
              arr[x - (b - y)][b]=dep+1;
          }

          if(x+y<=a && arr[x+y][0]==0) {
              q.add(new Point(x + y, 0));
              arr[x+y][0]=dep+1;
          }
          else if(x+y>a && arr[a][y - (a - x)]==0) {
              q.add(new Point(a, y - (a - x)));
              arr[a][y - (a - x)]=dep+1;
          }



        }

        //방문한 노드는 안방문하게 해야지 최소 길이 구할 수 있고 ,큐가 끊김
        // 방문 노드 기록, 과최소 경로 를 동시에 기록
        // -1이나 0 으로 초기화 하고  초기화 생타인 것들은 아직 방문한게 아니기 떄문에
        // 이런식으로 방문 노드기록 + 최소 경로 체크
        System.out.println(-1);

    }
}
