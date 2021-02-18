package Complete.baekjoon;

import java.awt.*;
import java.util.*;

public class p11967 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int ans=1;
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean move[][] = new boolean[n+1][n+1];  // 이동 가능하냐
        boolean visited[][] = new boolean[n+1][n+1];  // 방문했냐
        boolean light[][] = new boolean[n+1][n+1]; // 불켜져있냐

        ArrayList<int[]> rooms_info[][]= new ArrayList[n+1][n+1];

        for(int i=0;i<m;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(rooms_info[x][y]==null)
                rooms_info[x][y] = new ArrayList<>();
            rooms_info[x][y].add(new int[]{a,b});

        }

        light[1][1] = true;
        visited[1][1] = true;
        move[1][1] =true;

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(1,1));
        int dx[] ={1,-1,0,0};
        int dy[] ={0,0,-1,1};

        System.out.println(1 + "," + 1);
        while(!queue.isEmpty()){
            // 방 이동
            Point room_xy =  queue.poll();
            int x = room_xy.x; int y = room_xy.y;
            System.out.println("방 이동" + ": " + x + "," + y);


            // 방 불켜기 - 이미 켠방은 안킨다
            if(rooms_info[x][y]!=null) {
                for (int i = 0; i < rooms_info[x][y].size(); i++) {
                    int possibles[] = rooms_info[x][y].get(i); // 킬수 있는 방들 좌표
                        System.out.println("방불 키기" + ": " + possibles[0] + "," + possibles[1]);
                        if(!light[possibles[0]][possibles[1]]){
                            light[possibles[0]][possibles[1]] = true; // 불킴
                            ans += 1;
                        }
                    }
            }

            // 상하좌우 방 이동 가능 처리
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                    move[nx][ny] = true;
                    System.out.println("이동할 수 있는 방 처리" + ": " + nx + "," + ny);
                }
            }

            // 이동가능 & 방불 켠 방 & 아직 방문 안한 방  큐에 넣기
            for (int j=1;j<n+1;j++){
                for (int h=1;h<n+1;h++){
                    if(!visited[j][h] && light[j][h] && move[j][h]){
                        System.out.println("적합한 방 큐에 삽입" + ": " + j + "," + h);
                        visited[j][h]=true; // 방문 처리
                        queue.add(new Point(j,h));
                    }
                }
            }


        }


        System.out.println(ans);

    }
}
