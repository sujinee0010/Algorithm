package Complete.baekjoon;

import java.util.Scanner;

public class p8980 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();

        int marr [][] = new int[n+1][n+1];

        for(int i=0;i<m;i++){
            marr[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }
        int weight=0;
        int sum=0 ;


        for(int j=1;j<marr.length;j++){
            for(int i=1;i<marr.length;i++){
                
                if(j<i){
                    weight -= marr[j][i];
                }
                else if (j>i) {
                    int box_w = marr[i][j];
                    if (box_w + weight <= c){
                        weight += box_w;
                        sum+=box_w;
                    }
                    else {
                        marr[i][j] = c - weight;
                        sum+=marr[i][j];
                        weight = c;
                    }
                }
            }
        }

        System.out.println(sum);

    }
}
