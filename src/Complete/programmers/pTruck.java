package Complete.programmers;

import java.util.Scanner;
import java.util.Stack;

public class pTruck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Stack<Integer> bridge = new Stack<>();
        int end[] = new int[truck_weights.length];
        int eidx = 0;
        int idx = 0;
        int time=1;
        int w =0; 
        while(idx < truck_weights.length || !bridge.isEmpty()){
            // 삭제
            if(!bridge.isEmpty() && eidx < truck_weights.length &&  time == end[eidx]){
                bridge.remove((Integer) truck_weights[eidx]);
                w-= truck_weights[eidx];
                eidx++;
            }
            // 삽입
            if (idx < truck_weights.length && w+truck_weights[idx] <= weight){
                bridge.push(truck_weights[idx]);
                w+= truck_weights[idx];
                end[idx++]=time+bridge_length;
            }

            time++;

        }
        return end[end.length-1];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        solution(2, 10 , new int[]{7,4,5,6});


    }
}
