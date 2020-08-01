package Complete.groom;

import java.util.*;
// 구름 소문 타임아웃 
public class Rumor {
    static int[] parent; // 부모 저장 배열
    static int[] sz;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //9
        int m = sc.nextInt(); //5
        parent = new int[n+1];
        sz = new int[n+1];
        for (int i = 0; i < parent.length; i++) {
            makeSet(i);
            sz[i]=1;
        }
        for(int i=0;i<m;i++){
            int cnt = sc.nextInt();
            if(cnt==0)continue;
            int first =-1;
            for(int j=0;j<cnt;j++){
                int num = sc.nextInt();
                if(j==0)first = num;
                if(first!=-1) union(first,num);

            }
        }
        Map<Integer,Integer> result = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            result.put(i,1);
        }
        for (int i = 1; i < parent.length; i++) {
            int setnum = parent[i];
            if(i!=setnum)
            result.computeIfPresent(setnum, (k,v)-> v+1);
        }
        for(int key : result.keySet()){
            System.out.print(result.get(parent[key])+" ");
        }

//        for (int i = 1; i <=n; i++) {
//           System.out.print(sz[findSet(i)]);
//        }

//        for (int i = 1; i < parent.length; i++) {
//            System.out.println("idx: "+i+" p: "+parent[i]+"  sz: " +sz[i]);
//        }


    }
    public static void makeSet(int x){
        parent[x] = x; // 부모 : 자신의 index로 표시
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
        if (px != py){
            parent[py] = px;
            //sz[y] = sz[x]+= sz[y];


        }
        //return sz[x];
    }
}



//
//public class Rumor {
//    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); //9
//        int m = sc.nextInt(); //5
//        ArrayList<Integer> arr[] = new ArrayList[m]; // 집합 5
//        TreeSet<Integer> treeSets[] = new TreeSet[n+1]; // 0, 1-9
//        for(int i=0;i<m;i++){
//            arr[i]= new ArrayList();
//            int cnt = sc.nextInt();
//            if(cnt==0)continue;
//            for(int j=0;j<cnt;j++)
//               arr[i].add(sc.nextInt());
//        }
//        for(int i=1;i<=n;i++){ // 1 - 9
//            treeSets[i] = new TreeSet<>();
//            for(int j=0;j<arr.length;j++){
//                if(!arr[j].isEmpty() && arr[j].contains(i))
//                   treeSets[i].addAll(arr[j]);
//            }
//        }
//        ArrayList<Integer> linked[] = new ArrayList[n+1];
//        for(int i=1;i<linked.length;i++){
//
//            linked[i] = new ArrayList<Integer>(treeSets[i]);
////
//////            if(treeSets[i].isEmpty())
//////                System.out.println(1);
//////            else
//////                System.out.println(treeSets[i].size());
////
////           System.out.println(treeSets[i]);
//        }
//
//
//        for(int i=1;i<=n;i++){
//          //  System.out.println("WH");
//            System.out.println(bfs(i,new boolean[n+1],linked));
//        }
//
//
//
//
//    }
//
//    private static int bfs(int num, boolean[] visited , ArrayList<Integer> linked[]) {
//        int len=1;
//        Queue<Integer> queue = new LinkedList<>();
//        if(linked[num].isEmpty()) return 1;
//
//        queue.addAll(linked[num]);
////        System.out.println(linked[num]);
//
//        visited[num] =true;
//
//        //len = queue.size();
//
//        while(!queue.isEmpty()){
//            int next = queue.poll();
////            System.out.println(next);
//
//
//            if( !linked[next].isEmpty()){
//                for(int i=0;i<linked[next].size();i++){
//                    int number = linked[next].get(i);
//                    if(!visited[number]){
//                        queue.add(number);
////                        System.out.println("추가 "+number);
//                        len++;
//                        visited[number] = true;
//                    }
//                }
//            }
//
//        }
//
//
//        return len;
//    }
//
//
//}
