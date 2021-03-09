package Complete.baekjoon;

import java.util.*;

class Edge{

    int node[] = new int[2];
    int value;

    Edge(int n1 , int n2, int value){
        this.node[0]=n1;
        this.node[1] =n2;
        this.value = value;
    }

}


public class p1922{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int parent [] = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
        }

        int line = sc.nextInt();
        List<Edge> list = new ArrayList<>();

        for(int i=0;i<line;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int value = sc.nextInt();

            if(n1==n2)
                continue;

            list.add(new Edge(n1,n2,value));

        }

        Collections.sort(list, Comparator.comparingInt(e -> e.value));

        int ans=0;
        Iterator it = list.iterator();


        while(it.hasNext()){

            Edge e = (Edge)it.next();
            if( ! isSame(e.node[0] , e.node[1], parent))
            {
                unionParent(e.node[0] , e.node[1], parent);
                ans += e.value;
            }

        }

        System.out.println(ans);


    }

    // 유니온
    public static void unionParent(int n1 , int n2,int []parent){

        n1 = getParent(n1,parent);
        n2 = getParent(n2,parent);
        if(n1 < n2) parent[n2] = n1;
        else parent[n1]=n2;
    }



    // 같은 부모냐
    public static boolean isSame(int n1 , int n2, int [] parent){
        if(getParent(n1,parent)==getParent(n2,parent))
            return true;
        else
            return false;

    }



    // 부모 찾기
    public static int getParent(int number , int[] parent){
        if(number == parent[number])
            return number;
        else
            return parent[number]=getParent(parent[number],parent);

    }




}