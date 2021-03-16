package Complete.baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p16234 {
    static int[]dx = {-1 ,1 ,0 ,0};
    static int[]dy = { 0 ,0 ,-1,1};
    static int size [];
    static int sum [];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = sc.nextInt();
        int max = sc.nextInt();
        int contry [][] = new int[n][n];

        int parent [] = new int[n*n+n];
        size = new int[n*n+n];
        sum = new int[n*n+n];



        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                contry[i][j] = sc.nextInt();

            }
        }
        boolean flag = true;
        int cnt =0;
        Queue<Point> xy = new LinkedList<>();
        xy.add(new Point(0,0));

        while(flag){
            // 유니온 초기화
            flag = false;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    parent[n*i+j] = n*i+j;
                    size[n*i+j] =1;
                    sum[n*i+j] =contry[i][j];
                }
            }
            // 연합한다
            // 방문하고 안하고 .. 음 안따져도 되나
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    for (int d=0;d<4;d++){
                        int nx = i+dx[d];
                        int ny = j+dy[d];

                        if ( nx < n && nx >= 0  && ny < n && ny >= 0
                                && Math.abs(contry[nx][ny]-contry[i][j])>=min
                                && Math.abs(contry[nx][ny]-contry[i][j])<=max) {
                                connect(parent,n*i+j , n*nx+ny , contry[i][j] ,contry[nx][ny]);
                                flag=true;
                        }
                    }

                }
            }
            // 연합 시킨다
            // -> 할 필요 없으면 끝냄
            if(!flag) break;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    // 루트가 자기자신이 아닌 경우 또는 cnt 값이 1이상
                    if( n*i+j !=getParent(n*i+j,parent) || size[n*i+j]>1){
                        //System.out.println("SUM: "+sum[getParent(n*i+j,parent)]+" CNT: "+size[getParent(n*i+j,parent)]);
                        contry[i][j] = sum[getParent(n*i+j,parent)] / size[getParent(n*i+j,parent)];
                    }
                    // 아니면 sum[루트]/ size[루트] 값으로 갱신한다
                }
            }

            // 연합 다 했으면 총합 / 나라 갯수 값 구한다
            // 구한 값을 -1 한 곳에 넣는다
            cnt++;
            //System.out.println("----------arr--------------");
//            for(int i=0;i<n;i++){
//                for(int j=0;j<n;j++){
//                    System.out.print(contry[i][j]+" ");
//                }
//            System.out.println();
//            }

        }
        System.out.println(cnt);

    }

    private static void connect(int[] parent, int i, int j,int oi ,int oj) {
        i = getParent(i ,parent); // 2 - 4
        j = getParent(j ,parent); // 3 - 2
        // root 집합을 포합시켜준다
        if(i!=j){
            if(i < j ) {
                parent[j] = i;
                size[i] += size[j];
                size[j]=0;
                sum[i]+=oj;
                sum[j]=0;
            }
            else {
                parent[i] = j;
                size[j] += size[i];
                size[i]=0;
                sum[j]+=oi;
                sum[i]=0;
            }
        }

    }


    // 부모노드를 찾는다
    public static int getParent(int number,int [] parent){
        if(parent[number]==number)
            return number;
        else{
            return parent[number] = getParent(parent[number],parent);
        }
    }

}
