package Complete.baekjoon;

import java.io.*;
import java.util.*;

public class p4358 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> trees = new HashMap<>();
        int cnt=0;
        String str = br.readLine();

        while(true) {
            trees.put(str, trees.getOrDefault(str,0)+1);
            cnt++;
            str = br.readLine();
            if(str == null || str.length() == 0) {
                break;
            }
        }


        // 키 오름차순 정렬
        Object sorted_tnames[] = trees.keySet().toArray();
        Arrays.sort(sorted_tnames);

        for(Object key : sorted_tnames){
            String tn = (String) key;
            double per = (trees.get(tn) * 100.0) / cnt;
            System.out.println(tn+" "+String.format("%.4f", per));

        }


    }

}

