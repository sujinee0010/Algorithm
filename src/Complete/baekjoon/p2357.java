package Complete.baekjoon;

import java.util.*;

public class p2357 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder[] sb = new StringBuilder[m];

        int min[] = new int[n + 1];
        int max[] = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            int number = sc.nextInt();
            if (i == 1) {
                min[i] = number;
                max[i] = number;
            }else {
                min[i] = Math.min(number, min[i - 1]);
                max[i] = Math.max(number, max[i - 1]);
            }

        }
        for (int i = 1; i < n+1; i++) {
            System.out.println(min[i] +","+max[i] );
        }

        for (int i = 0; i < m; i++) {

            int s = sc.nextInt();
            int e = sc.nextInt();
            //System.out.println(min[e] +","+max[e] );
            sb[i].append(min[e]).append(" ").append(max[e]);

        }

        for (int i = 0; i < m; i++) {
            System.out.println(sb[i]);
        }


    }
}