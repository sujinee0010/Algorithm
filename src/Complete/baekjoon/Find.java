package Complete.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//백준 찾기 1786 KMP
public class Find {
    public static int[] makeTable(String pattern)
    { int patternSize = pattern.length();
        int table[] = new int[patternSize];
        Arrays.fill(table,0);

        int j=0;
        for(int i=1;i<patternSize;i++){
            while(j>0 && pattern.charAt(i)!=pattern.charAt(j))
                j = table[j-1];
            if(pattern.charAt(i) == pattern.charAt(j))
                table[i]=++j;
        }
        return table;
    }

    public static List<Integer> KMP(String parent , String pattern){
        List<Integer> list = new ArrayList<>();
        int talble[] = makeTable(pattern);
        int parentSize = parent.length();
        int patternSize = pattern.length();
        int j =0;
        for(int i =0; i<parentSize;i++){
            while(j>0 && parent.charAt(i) !=pattern.charAt(j))
                j = talble[j-1];

            if(parent.charAt(i)==pattern.charAt(j)){
                if(j==patternSize -1) {
                    list.add(i-patternSize+2);
                    j = talble[j];
                }
                else j++;
            }
        }

        return list;
    }

    public static  void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String T = sc.nextLine();
        String P = sc.nextLine();

        List<Integer> list = KMP(T,P);

        System.out.println( list.size());
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));

    }
}
