package BaekJoon;

import java.util.Scanner;

public class Down {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min_arr[] = new int[3];
        int max_arr[] = new int[3];
        int max_ans=0;
        int min_ans=0;

        for (int i=0;i<n;i++){
            int num0 = sc.nextInt();
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int n0  = num0 + Math.min(min_arr[0],min_arr[1]);
            int n1  = num1 + Math.min(Math.min(min_arr[0],min_arr[1]),min_arr[2]);
            int n2  = num2 + Math.min(min_arr[1],min_arr[2]);
            min_arr[0] = n0;
            min_arr[1] = n1;
            min_arr[2] = n2;

            n0  = num0 + Math.max(max_arr[0],max_arr[1]);
            n1  = num1 + Math.max(Math.max(max_arr[0],max_arr[1]),max_arr[2]);
            n2  = num2 + Math.max(max_arr[1],max_arr[2]);
            max_arr[0] = n0;
            max_arr[1] = n1;
            max_arr[2] = n2;

        }

        min_ans=Math.min(Math.min(min_arr[0],min_arr[1]),min_arr[2]);
        max_ans=Math.max(Math.max(max_arr[0],max_arr[1]),max_arr[2]);
        System.out.println(max_ans +" "+min_ans);

    }
}
