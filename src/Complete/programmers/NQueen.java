package Complete.programmers;

import java.util.Arrays;

//프로그래머스 스킬체크 체스판
public class NQueen {

    static int ans=0;
    public int solution(int n) {
        int answer = 0;

        int box[][]= new int[n][n];
        boolean visited[][]= new boolean[n][n];

        for(int i=0;i<visited.length;i++){
            Arrays.fill(visited[i],true);
        }

        sol(box ,0,visited);


        answer=ans;
        return answer;
    }


    private static void sol(int box[][], int i, boolean visited[][]){

        if(i<box.length) {
            for (int j = 0; j < box.length; j++) {

                if (visited[i][j] == true) {

                    boolean temp[][] = new boolean[box.length][box.length];
                    temp = copyArr(visited, temp);
                    makeX(temp,i,j);
                    sol(box, i + 1, temp);
                }
            }
        }

        else
            ans+=1;

    }



        private static boolean[][] copyArr(boolean[][] arr ,boolean[][] temp){
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                temp[i][j]=arr[i][j];
            }
        }
        return temp;
    }


    private static boolean[][] makeX(boolean visiteds[][],int i , int j){
        //해당 행 ,열   다 x
        for(int m=0;m<visiteds.length;m++){
            visiteds[i][m]=false;
            visiteds[m][j]=false;
        }
        // 아래 오른쪽
        for(int m=i+1, h=j+1;m<visiteds.length;m++,h++){
            if(h<visiteds.length){
                visiteds[m][h]=false;
            }
        }
        // 아래 왼
        for(int m=i+1, h=j-1;m<visiteds.length;m++,h--){
            if(h>= 0){
                visiteds[m][h]=false;
            }
        }
        // 위  오른쪽
        for(int m=i-1, h=j+1;m>=0;m--,h++){
            if(h<visiteds.length){
                visiteds[m][h]=false;
            }
        }
        // 위  왼
        for(int m=i-1,h=j-1;m>=0;m--,h--){
            if(h>= 0){
                visiteds[m][h]=false;
            }
        }


        return visiteds;
    }




}


