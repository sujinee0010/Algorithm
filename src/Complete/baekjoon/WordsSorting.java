package Complete.baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class WordsSorting {
    public static void soltuion(ArrayList<String> words){
        PriorityQueue<String[]> pq = new PriorityQueue((Comparator<String[]>) (o1, o2) -> {
            if(o1[0].equals(o2[0]))
                return o1[1].compareTo(o2[1]);
            return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
        });

        for(int i=0;i<words.size();i++){
            pq.add(new String[]{Integer.toString(words.get(i).length()),words.get(i)});
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll()[1]);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> words =new ArrayList<>();
        for(int i=0;i<n;i++){
            String word = sc.next();
            if (words.isEmpty() || !words.contains(word))
                words.add(word);
        }

        soltuion(words);

    }

}
