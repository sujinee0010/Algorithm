package Complete.baekjoon;

import java.awt.*;
import java.util.*;

public class p1202 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 보석 개수
        int k = sc.nextInt(); // 가방 개수
        long ans =0;

        PriorityQueue<Integer> bag = new PriorityQueue<>(); // 가방

        PriorityQueue<Point> jws= new PriorityQueue<>(Comparator.comparingInt(o -> o.x)); // 무게 순
        PriorityQueue<Integer> weights = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i<n;i++){
            int weight = sc.nextInt();
            int price = sc.nextInt();
            jws.add(new Point(weight,price)); // 무게 , 가격
        }

        for (int i=0;i<k;i++){
            bag.add(sc.nextInt());
        }



        while(!bag.isEmpty()){
            int bag_w = bag.poll();
            System.out.println(bag_w);

            while(!jws.isEmpty() && jws.peek().x  <= bag_w){
                  Point select = jws.poll();
                  weights.add(select.y);
            }

            if (!weights.isEmpty()) {
                ans += weights.poll();
            }

        }


        System.out.println(ans);


    }
}
