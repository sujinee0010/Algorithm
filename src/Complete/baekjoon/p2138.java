package Complete.baekjoon;

import java.util.Scanner;
/*
* 스트링을 너무 많이 생성한 코드- 메모리 초과 남
* */
public class p2138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        String now = sc.next(); // 000
        String expect = sc.next(); // 010
        int INF = 987654321 , first_cnt =1 , second_cnt =0;
        int[]first = new int[n];
        int[]second= new int[n];
        int[]ex = new int[n];

        for(int i=0;i<n;i++){
            first[i]=Character.getNumericValue(now.charAt(i));
            second[i]=Character.getNumericValue(now.charAt(i));
            ex[i]=Character.getNumericValue(expect.charAt(i));
        }
        // 전구 킨 거
        // 0 이면 1로
        first[0] = 1 - first[0];
        first[1] = 1 - first[1];

        for(int i=1;i<ex.length;i++){
            if(first[i-1] != ex[i-1]){
                first[i] = 1 - first[i];
                first[i-1] = 1 - first[i-1];

                if(i< ex.length-1)
                    first[i+1] = 1 - first[i+1];
                first_cnt++;
            }

            if(second[i-1] != ex[i-1]){
                second[i] = 1 - second[i];
                second[i-1] = 1 - second[i-1];

                if(i< ex.length-1)
                    second[i+1] = 1 - second[i+1];
                second_cnt++;
            }
        }


        for(int i=0;i<ex.length;i++){
            if(ex[i] != first[i] && first_cnt!=INF)
                first_cnt=INF;
            if(ex[i] != second[i] && second_cnt!=INF)
                second_cnt=INF;
        }

        int ans = Math.min(first_cnt,second_cnt);
        if(ans==INF) ans = -1;
        System.out.println(ans);


    }

}
