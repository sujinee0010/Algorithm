package Complete;

import java.awt.*;
import java.util.*;

public class Cabbage {

    //백준 유기농 배추
    static int dx[] ={ 0,1,0,-1 }, dy[] = { 1,0,-1,0 };
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int result[] = new int[t];

        for(int T=0;T<t;T++) {

            int n = sc.nextInt(); // x
            int m = sc.nextInt(); // y
            int k = sc.nextInt();

            int ans = 0;
            Map<Point,Integer> cabbages = new HashMap<>();

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                cabbages.put(new Point(x, y), 0);
            }

            for (Point key : cabbages.keySet()) {
                if (cabbages.get(key) == 0) {
                    bfs(key,cabbages,n,m);
                    ans++;
                }
            }

            result[T] = ans;

        }

        for(int T=0;T<t;T++) {
            System.out.println(result[T]);
        }


    }

    private static void bfs( Point cabage ,Map<Point,Integer> cabbages ,int n , int m ) {

        Queue<Point> q = new LinkedList<>();

        q.add(cabage);
        cabbages.computeIfPresent(cabage, (c, v) -> v + 1);

        while (!q.isEmpty()){

            Point node = q.poll();
            int x= node.x;
            int y =node.y;

            for( int k=0;k<4;k++){

                int nx = x+dx[k]; int ny = y+dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    Point next = new Point(nx,ny);
                    if(cabbages.containsKey(next) && cabbages.get(next)== 0){
                        q.add(next);
                        cabbages.computeIfPresent(next, (c, v) -> v + 1);
                    }
                }
            }

        }

    }

}
