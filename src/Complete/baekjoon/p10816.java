package Complete.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String ns[] = br.readLine().split(" ");

        int[] numbers = new int[n];
        for(int i=0;i<ns.length;i++){
            numbers[i] = Integer.parseInt(ns[i]);
        }

        Arrays.sort(numbers);



        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> results = new ArrayList<>();
        String r[] = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<r.length;i++){
            int number = Integer.parseInt(r[i]);


            int start = lower_bound(number,numbers);
            int end = upper_bound(number,numbers);


            sb.append(end-start).append(" ");

        }

        System.out.println(sb);


    }
    // 특정 수 이상 최초 인덱스
    private static int lower_bound(int target, int[] numbers) {
        int mid , start , end;
        start =0; end = numbers.length;
        while(end>start){
            mid = (start+end)/2;

            if(numbers[mid]>=target)
                end = mid;
            else
                start =mid+1;

        }
        return end;
    }

    // 특정 수 를 초과하는 수 최초 인덱스
    private static int upper_bound(int target, int[] numbers) {

        int mid , start , end ;
        start =0; end = numbers.length;

        while(end>start){
            mid = (end+start)/2;
            if (numbers[mid] > target)
                end = mid;
            else
                start = mid+1;
        }
        return end;

    }


}
