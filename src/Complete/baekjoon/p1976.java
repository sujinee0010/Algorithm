package Complete.baekjoon;

import java.util.Scanner;

public class p1976 {
    //union된 친구들이라고 해도 모두 parent에 같은 값이 들어있지는 않습니다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int parent [] = new int[n+1];

        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }
        int info[][] = new int[n+1][n+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                info[i][j]=sc.nextInt();
            }
        }

        int trip [] = new int[m];
        for(int i=0;i<m;i++){
            trip[i] = sc.nextInt();
        }


        // 부모노드 합치기
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){

                if(info[i][j]==1)
                    connect(parent,i,j);
            }
        }


        String ans ="YES";
        for (int i=0;i<trip.length-1;i++) {
            if(!isSame(trip[i],trip[i+1],parent)){
                ans ="NO";
            }
        }

        System.out.println(ans);
    }

    private static void connect(int[] parent, int i, int j) {

            i = getParent(i ,parent); // 2 - 4
            j = getParent(j ,parent); // 3 - 2

            if(i < j ) parent[j] = i;
            else parent[i] = j;

    }

    // 부모가 같은지 확인
    public static boolean isSame(int x, int y,int [] parent){
        if(getParent(x,parent) == getParent(y,parent))
            return true;
        else
            return false;
    }

    // 부모노드를 찾는다
    public static int getParent(int number,int [] parent){
        if(parent[number]==number)
            return number;
        else
            return parent[number] = getParent(parent[number],parent);
    }


}
