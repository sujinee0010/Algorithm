package Complete.baekjoon;

import java.util.*;
import java.util.Scanner;

public class p1764 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int b = sc.nextInt();
        TreeSet<String> D = new TreeSet<>();
        TreeSet<String> B = new TreeSet<>();
        for (int i=0;i<d;i++){
            D.add(sc.next());
        }
        for (int i=0;i<b;i++){
            B.add(sc.next());
        }

        D.retainAll(B);
        System.out.println(D.size());
        Iterator<String> it = D.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }



    }
}
