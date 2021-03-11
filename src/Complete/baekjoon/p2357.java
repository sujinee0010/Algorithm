package Complete.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2357 {
    static int numbers[];
    static int max_tree[];
    static int min_tree[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        numbers = new int[n+1];
        max_tree = new int[n*4]; // 왜일까
        min_tree = new int[n*4]; // 왜일까

        for (int i = 1; i < n + 1; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        init(0,n,1);

        String sb [] = new String[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int tmp[] = getMaxandMin(0,n,s,e,1);
            sb[i] = tmp[1]+" "+tmp[0];

        }
        for (int i = 0; i < m; i++)
            System.out.println(sb[i]);


    }

    private static int[] getMaxandMin(int start, int end, int left, int right, int node) {
        if(end < left || start > right)
            return new int[] {0,2147483647};
        if(left<=start && end <=right)
            return new int[]{ max_tree[node], min_tree[node] };

        int l [] = getMaxandMin(start,(start+end)/2,left,right,node*2);
        int r [] = getMaxandMin((start+end)/2+1,end,left,right,node*2+1);

        return  new int[]{ Math.max(l[0],r[0]) , Math.min(l[1],r[1])};

    }



    private static int[] init(int start, int end, int node) {
        if(start==end) {
            max_tree[node] = numbers[start];
            min_tree[node] = numbers[start];
        }
        else{
            int left [] = init(start,(start+end)/2,node*2);
            int right[] = init((start+end)/2+1,end,2*node+1);
            max_tree[node]= Math.max(left[0],right[0]);
            min_tree[node]= Math.min(left[1],right[1]);
        }
        return new int[]{ max_tree[node], min_tree[node] };
    }


}