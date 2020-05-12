package Complete.groom;

import java.util.*;

//구름 3주차 제습제
public class MakeAllZero {

    public static void findZero(int arr[][],boolean isZero[][]){
        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                if(arr[i][j]==0)
                    isZero[i][j]=true;
            }
        }
    }

    private static void makeZero(int[][] arr, boolean[][] isZero) {
        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++) {
                if(isZero[i][j])
                {
                    //왼
                    if(j-1>=0)
                        arr[i][j-1]=0;
                    //오
                    if(j+1<arr.length)
                        arr[i][j+1]=0;
                    //위
                    if(i-1>=0)
                        arr[i-1][j]=0;
                    //아래
                    if(i+1<arr.length)
                        arr[i+1][j]=0;

                }

            }
        }

    }

    private static int dfs(int[][] arr, boolean[][] isZero, int[][] zeroarr) {

        int cnt=1;

        findZero(arr, isZero);
        makeZero(arr, isZero);

        if(!Objects.deepEquals(arr,zeroarr)) {
            cnt+= dfs(arr,isZero,zeroarr);
        }

        return cnt;

    }

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int arr[][] = new int[n][n];

    int zeroarr[][] = new int[n][n];
    int allonearr[][] = new int[n][n];

    //제로인 배열
    for(int i=0;i<arr.length;i++) {
        Arrays.fill(zeroarr[i], 0);
    }

        //1 인 배열
        for(int i=0;i<arr.length;i++) {
            Arrays.fill(allonearr[i], 1);
        }

    boolean isZero[][]= new boolean[n][n];


    for(int i=0;i<arr.length;i++) {
        Arrays.fill(isZero[i], false);
    }

    for(int i=0;i<arr.length;i++){
        for(int j = 0;j<arr[i].length;j++) {
            arr[i][j] = sc.nextInt();
        }
    }


     int answer =-1;

        if(!Objects.deepEquals(arr,zeroarr)&&(!Objects.deepEquals(arr,allonearr)) ) {
            answer = dfs(arr, isZero, zeroarr);
        }

    System.out.println(answer);





    }




}
