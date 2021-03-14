package Complete.goorm;

import java.awt.*;
import java.util.Scanner;

public class Virus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Point arr[][] = new Point[n+1][n+1];


        // ㅎㅐ당 좌표의 상하 좌우
        // 상하 좌우 랑 parent 연결함
        // 연결 parent 맵에 있는 지 카운팅 ..



        for(int i=0;i<m;i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            arr[y][x]= new Point(y,x);
        }



    }

    private static void connect(int[] parent, int i, int j) {

        i = getParent(i ,parent); // 2 - 4
        j = getParent(j ,parent); // 3 - 2

        System.out.println(i +","+j);
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
        else{
            int a = parent[number] = getParent(parent[number],parent);
            System.out.println(number +"a"+a);
            return a;
        }
    }

}
