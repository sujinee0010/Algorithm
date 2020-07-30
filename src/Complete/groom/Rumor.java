package Complete.groom;

import java.util.ArrayList;
import java.util.Scanner;

public class Rumor {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //9
        int m = sc.nextInt(); //5

      //  int [] = new int[n+1];

        ArrayList<Integer> arr[] = new ArrayList[m];


        for(int i=0;i<m;i++){
            arr[i]= new ArrayList();
            int cnt = sc.nextInt();
            for(int j=0;j<cnt;j++){
               arr[i].add(sc.nextInt());
            }

        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=arr.length;j++){
                if(!arr[i].contains(i)){
                    
                }


            }
        }



    }
}
