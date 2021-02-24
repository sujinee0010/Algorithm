package Complete.baekjoon;

import java.awt.*;
import java.io.*;
import java.util.*;
// 디테일 한 부분을 놓친다..
public class p2836 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nm[] = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        ArrayList<Point> houses = new ArrayList<>();
        for(int i=0;i<n;i++){
            String house[] = br.readLine().split(" ");
            int first = Integer.parseInt(house[0]);
            int second = Integer.parseInt(house[1]);
            houses.add(new Point(first,second));
        }

        // 8 3 , 6 2
        Collections.sort(houses, (o1, o2) -> {
            if(o2.x == o1.x)
                return o1.y-o2.y;
            return o2.x - o1.x;
        });


        int start =0;
        int end = 0;
        long ans=m;
        for(int i=0;i<houses.size();i++){

            int s = houses.get(i).x;
            int e = houses.get(i).y;

            // 감소 추세
            if(s-e>0) {
                if(start==0&&end==0)
                {
                    start = s; // 6
                    end = e; // 4
                }
                else{
                    if(s >= end)
                        end = Math.min(end,e);
                    else{
                        ans+= 2*(start-end);
                        start = s;
                        end =e;
                    }
                }

            }
        }

        ans+= 2*(start-end);
        System.out.println(ans);

    }
}
