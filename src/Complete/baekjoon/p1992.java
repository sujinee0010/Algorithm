package Complete.baekjoon;

import java.util.Scanner;

public class p1992 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++){
            String line = sc.next();
            for(int j=0;j<line.length();j++){
                arr[i][j]=Character.getNumericValue(line.charAt(j));
            }
        }
        String ans = makeTreeLine(arr,n,0,n-1,0,n-1);
        System.out.println(ans);

    }

    private static String makeTreeLine(int[][] arr, int n, int istart, int iend, int jstart, int jend) {
        String ans ="(";
        if(istart==iend){
            return arr[istart][jstart]+"";
        }else{
            //왼 위
            ans+=makeTreeLine(arr,n,istart,(istart+iend)/2,jstart,(jstart+jend)/2);
            // 오 위
            ans+=makeTreeLine(arr,n,istart,(istart+iend)/2,(jstart+jend)/2+1,jend);
            // 왼 아
            ans+=makeTreeLine(arr,n,(istart+iend)/2+1,iend,jstart,(jstart+jend)/2);
            // 오 아
            ans+=makeTreeLine(arr,n,(istart+iend)/2+1,iend,(jstart+jend)/2+1,jend)+")";
            // 같으면
            if (ans.equals("(0000)") || ans.equals("(1111)"))
                return ans.charAt(2)+"";
            else
                return ans;
        }

    }


}
