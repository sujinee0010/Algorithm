package Complete.baekjoon;

import java.awt.*;
import java.util.*;

public class LAB  {

    //백준 연구소

    static int n, m ,count=0,max=-1;
    static int arr[][];
    static Queue<Point> q  = new LinkedList<>();

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();


        arr = new int[n][m];


        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==2) {
                    q.add(new Point(i, j));
                }
            }
        }

        dfs(0);

        System.out.println(max);


    }


    private static void dfs(int change) {

        if(change<3) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 0) {

                        //바꾸고
                        arr[i][j] = 1;
                        dfs(change + 1);

                        //안바꾸고
                        arr[i][j] = 0;

                    }
                }
            }
        }
        else{

            int arr3 [][]= new int [n][m];

           // 데이터타입[] 복사받을배열명 = Arrays.copyOf(복사할배열, 배열 길이);
            for (int i = 0; i < arr.length; i++) {
                arr3[i] = Arrays.copyOf(arr[i], m);
            }


            bfs(arr3);
            count = countZero(arr3);



            if(max==-1) max=count;
            else{
                max = Math.max(max,count);
            }

        }


    }


    private static void bfs(int arr3[][]) {

        Queue<Point> qs  =  new LinkedList<>();

        for(Point p : q) {
            qs.add(p);
        }

        while(!qs.isEmpty()) {
            Point node = qs.poll();


            int x = node.x;
            int y = node.y;


          if(x!=0 && arr3[x-1][y]== 0) {
              arr3[x-1][y]=2;
              qs.add(new Point(x-1,y));
          }

          if(x!=n-1 && arr3[x+1][y]== 0) {
                arr3[x+1][y]=2;
                qs.add(new Point(x+1,y));
          }

          if(y!=0 && arr3[x][y-1]== 0) {
                arr3[x][y-1]=2;
                qs.add(new Point(x,y-1));
          }

            if(y!=m-1 && arr3[x][y+1]== 0) {
                arr3[x][y+1]=2;
                qs.add(new Point(x,y+1));
            }

        }

    }


    private static int countZero(int arr3[][]) {
        int ans =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr3[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
