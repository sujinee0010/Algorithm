package Complete.baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class p10655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();

        int total = 0;
        int sx =0 , sy =0;
        for(int i=0;i<n;i++){
            int x = sc.nextInt(); int y = sc.nextInt();
            points.add(new Point(x,y));
            if(points.size()>1)
                total += Math.abs(x - sx) +Math.abs(y - sy);
            sx = x;
            sy = y;

        }
        System.out.println(total);
        int skip =0;
        for (int i=1; i < n-1;i++){
            Point before = points.get(i-1);
            Point pre = points.get(i);
            Point after = points.get(i+1);

            skip = Math.max(skip ,(Math.abs(before.x- pre.x) + Math.abs(before.y- pre.y)+ Math.abs(pre.x- after.x)+Math.abs(pre.y- after.y))
                    -  (Math.abs(before.x- after.x) + Math.abs(before.y- after.y)));


        }
        System.out.println(total -skip);


    }
}
