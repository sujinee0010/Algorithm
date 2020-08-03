package Complete.baekjoon;

import java.util.*;

public class Set {
    static int[] parent; // 부모 저장 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //7
        int m = sc.nextInt(); //8
        parent = new int[n + 1];
        List result = new ArrayList<String>();

        for(int i=0;i<parent.length;i++) {
            makeSet(i);
        }
        for(int i=0;i<m;i++){
            int flag = sc.nextInt();
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if(flag==0)
                union(num1,num2);
            else{
                if (parent[num1]==parent[num2])
                    result.add("YES");
                else
                    result.add("NO");
            }
        }
        Iterator it = result.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void makeSet(int x){
        parent[x] = x;
    }
    public static int findSet(int x){
        if(x == parent[x])
            return x;
        else
            return parent[x] = findSet(parent[x]);
    }
    public static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (px != py)
            parent[py] = px;
    }
}
