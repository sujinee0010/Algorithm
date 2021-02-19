package Complete.baekjoon;

import java.util.Scanner;

/*
점수가 아니라 순위 -- 1위는 무조건 채용
* */
public class p1946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] reuslt = new int[T];
        for (int i=0;i<T;i++){
            int n = sc.nextInt();
            int scores[] = new int[n+1];

            for (int j=1;j<scores.length;j++){
                scores[sc.nextInt()]=sc.nextInt();
            }

            int s = scores[1];
            int ans=1;


            for (int j = 2; j < scores.length; j++) {
                if(s > scores[j]) {
                        ans++;
                        s = scores[j];
                }
            }
            reuslt[i] = ans;

        }


        for (int i=0;i<reuslt.length;i++){
            System.out.println(reuslt[i]);
        }
    }
}
