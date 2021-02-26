package Complete.baekjoon;

import java.util.Scanner;

public class p14888 {
    static int numbers[];
    static int operator[];
    static int max = -1000000000;
    static int min = 1000000000;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        numbers = new int[n];
        operator = new int[4];
        for(int i=0;i<n;i++){
            numbers[i] = sc.nextInt();
        }
        for(int i=0;i<4;i++)
            operator[i] = sc.nextInt();


        dfs(1,numbers[0],operator);

        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int idx, int number, int[] operator) {
        if(idx>=numbers.length){
            max = Math.max(max,number);
            min = Math.min(min,number);
        }else{
            //+
            if(operator[0]>0){
                operator[0]-=1;
                dfs(idx+1 ,number+numbers[idx] ,operator);
                operator[0]+=1;
            }
            //-
            if(operator[1]>0){
                operator[1]-=1;
                dfs(idx+1 ,number-numbers[idx] ,operator);
                operator[1]+=1;
            }

            //*
            if(operator[2]>0){
                operator[2]-=1;
                dfs(idx+1 ,number*numbers[idx] ,operator);
                operator[2]+=1;
            }


            // /
            if(operator[3]>0){
                operator[3]-=1;
                int mock = Math.abs(number) / numbers[idx];
                if(number<0)
                    mock *= -1;

                dfs(idx+1 ,mock ,operator);
                operator[3]+=1;
            }

        }
    }
}
