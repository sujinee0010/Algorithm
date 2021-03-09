package Complete.baekjoon;

import java.util.*;

class Edge_ {
    int node[]= new int[2];
    int value;

    public Edge_(int n1, int n2 ,int value){
        this.node[0] =n1;
        this.node[1] =n2;
        this.value =value;
    }

}
public class p1197{
    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int sum =0;
        int parent[] = new int[v+1];
        for(int vidx=1; vidx<=v; vidx++){
            parent[vidx]=vidx;
        }
        List<Edge_> list = new ArrayList<>();

        for(int i=0; i<e;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int c = sc.nextInt();

            if(v1==v2)
                continue;
            list.add(new Edge_(v1,v2,c));
        }

        Collections.sort(list , (o1,o2) ->o1.value - o2.value);

        Iterator it = list.iterator();
        while(it.hasNext()){
            Edge_ edge = (Edge_) it.next();

            if(! isSame(edge.node[0] , edge.node[1] , parent)){
                unionParent(edge.node[0] , edge.node[1] , parent);
                sum += edge.value;
            }

        }

        System.out.println(sum);

    }

    public static void unionParent(int n1, int n2 ,int [] parent){
        n1 = getParent(n1, parent);
        n2 = getParent(n2, parent);

        if(n1<n2) parent[n2]=n1;
        else parent[n1]=n2;
    }

    public static int getParent(int n1, int [] parent){
        if(n1 == parent[n1])
            return n1;
        else
            return parent[n1] = getParent(parent[n1] ,parent);

    }

    public static boolean isSame(int n1, int n2 ,int [] parent){
        if(getParent(n1,parent) == getParent(n2,parent))
            return true;
        else
            return false;

    }

}