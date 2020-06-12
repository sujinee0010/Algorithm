package Complete.baekjoon;

import java.util.Arrays;
import java.util.Scanner;
// 백준 일곱난쟁이
public class Dwarf7 {
    static int dwarfs[];
    static int sum=0,sub=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dwarfs = new int[9];
        for(int i=0;i<9;i++) {
            dwarfs[i] = sc.nextInt();
            sum+=dwarfs[i];
        }
        Arrays.sort(dwarfs);
        int sub = sum-100;

        for(int i=0;i<(1<<9);i++){
            int sum=0;
            if(Integer.bitCount(i)==2){
                for(int j=0;j<9;j++)
                    if((1<<j&i)>0) sum+= dwarfs[j];
            }
            if(sum == sub){
                for(int j=0;j<9;j++)
                    if((1<<j&i)==0)  System.out.println(dwarfs[j]);
                break;
            }
        }
    }
}
