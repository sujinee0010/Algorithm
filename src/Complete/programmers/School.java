package Complete.programmers;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class School {
    static int road[][];  static boolean visited[][];
    static int N,M , min;
    static Point minp = new Point(0,0);
    static ArrayList plist;
    //static ArrayList lcntList = new ArrayList<Point>();
    //static ArrayList llist = new ArrayList<Integer>();
    static int dx[] ={-1,1,0,0}; static int dy[] ={0,0,-1,1};
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        N = n; M = m;
        // 제외 할 것 : 시작 , 웅덩이
        road  = new int[m][n];
        visited  = new boolean[m][n];
        plist = new ArrayList<Point>();


        for (int i=0;i<puddles.length;i++){
          plist.add(new Point(puddles[i][0],puddles[i][1]));
        }

        // 현재 위치 , 상하 좌우 이동 , 최소 값 찍기 ,  간거 찍기 , 퍼들 아닌거


        dp(0,0 , visited,0);


       lcntList.sort(Comparator.comparing(Point::getX));






        return answer;
    }

    private void dp(int x , int y ,boolean visited[][], int len) {

        if(x == M-1 && y == N-1){
            if(llist.contains(len-1)){

            }else {
                Point rp = new Point(len-1,1); // 새 경로
                llist.add(len-1);
                lcntList.add(rp);
            }
//            if(min==0) min =len-1;
//            else min = Math.min(min,len-1);
        }
        else{
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x; int ny = dy[i] + y;
                Point np = new Point(nx,ny);
                if (nx < M && nx >= 0 && ny < N && ny >= 0 && !visited[nx][ny] && !plist.contains(np)) {
                    visited[nx][ny] = true;
                    dp(nx, ny, visited ,len+1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
