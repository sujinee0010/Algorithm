package Complete.baekjoon;

import java.awt.*;
import java.util.*;

public class p11967 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int ans=1;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int room[][] = new int[n+1][n+1];

        ArrayList<int[]> rooms_info[][]= new ArrayList[n+1][n+1];

        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(rooms_info[x][y]==null)
                rooms_info[x][y] = new ArrayList<>();
            rooms_info[x][y].add(new int[]{a,b});

        }


        PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> room[o2.x][o2.y] - room[o1.x][o1.y]);

        queue.add(new Point(1,1));
        room[1][1]= 1;
        int dx[] ={1,-1,0,0};
        int dy[] ={0,0,-1,1};

        while(!queue.isEmpty()){
            Point room_xy = (Point)queue.poll();

            System.out.println(room_xy.x + "," + room_xy.y);

            // 켜진 방이냐 1
            if(room[room_xy.x][room_xy.y]==1) {
                // 해당 방 방문 처리
                room[room_xy.x][room_xy.y] = 10;

                // 킬수 있는 방을 킨다
                if(rooms_info[room_xy.x][room_xy.y]!=null) {
                    for (int i = 0; i < rooms_info[room_xy.x][room_xy.y].size(); i++) {
                        int possibles[] = rooms_info[room_xy.x][room_xy.y].get(i); // 킬수 있는 방들 좌표
                        if (room[possibles[0]][possibles[1]] == 0) { // 불 안킨 방 (0) 일 경우에 만 카운팅
                            System.out.println("방불 키기" + ": " + possibles[0] + "," + possibles[1]);
                            room[possibles[0]][possibles[1]] = 1; // 불킴 (1)
                            ans += 1;
                        }
                    }
                }
                // 주변 방을 큐에 넣는다
                for (int i = 0; i < 4; i++) {
                    int nx = room_xy.x + dx[i];
                    int ny = room_xy.y + dy[i];
                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && room[nx][ny]!=10 ) { // 방문 안한 방만
                        Point tmp = new Point(nx, ny);

                        if(queue.contains(tmp)) {
                            System.out.println("삭제");
                            queue.remove(tmp);
                        }


                        System.out.println("방 추가" + ": " + nx + "," + ny);
                        queue.add(tmp);
                    }
                }

            }
            else{

            }
        }


        System.out.println(ans);

    }
}
