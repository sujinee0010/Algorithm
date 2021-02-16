package Complete.baekjoon;

import java.util.*;

public class p1202 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 보석 개수
        int k = sc.nextInt(); // 가방 개수
        int ans =0;
        PriorityQueue<Integer> bag = new PriorityQueue<>(); // 가방 -> 무게 순 오름차순

        PriorityQueue<int[]> jws = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]); // 보석 -> 가격 순 내림차순

        for(int i=0;i<n;i++){
            jws.add(new int[]{sc.nextInt(),sc.nextInt()}); // 무게 , 가격
        }

        for (int i=0;i<k;i++){
            bag.add(sc.nextInt());
        }

        while(!bag.isEmpty() && !jws.isEmpty()){
           int val = bag.poll(); // 가방을 꺼낸다
            boolean flag = false; // 가방에 담았다는 의미
            ArrayList<int[]> tmp = new ArrayList<>(); // 꺼냈던거 다시 담기

           while (!jws.isEmpty() && !flag) {
               int[] jw = jws.poll(); // 2 99

               if (val >= jw[0]) { // 가방에 담기
                   ans += jw[1];
                   flag = true; // 담은거 표시
               }else{
                   tmp.add(jw); //다시 넣어준다
               }
           }
            jws.addAll(tmp); // 다시 넣어준다

        }


        System.out.println(ans);


    }
}
