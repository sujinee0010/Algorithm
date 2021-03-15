package Complete.goorm;


import java.util.*;
import java.util.List;


public class Virus {
    static int[]dx = {-1 ,1 ,0 ,0};
    static int[]dy = { 0 ,0 ,-1,1};
    static int[] size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 2차원 배열 -> n * x + y 로 하면 1차원 배열로 치환 가능!   
        int parent[] = new int[(n*n)+n+1];
        int virus[][] = new int[n+1][n+1];
        size = new int[(n*n)+n+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                parent[n*i + j ] = n*i + j;
                virus[i][j] = 0;
                size[n*i + j] = 1;
            }
        }


        List<Integer> result = new ArrayList<>();

        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            virus[y][x]=1;

            // 상하 좌우
            for(int h=0;h<4;h++){
                int nx = x+dx[h];
                int ny = y+dy[h];

                if ( nx <= n && nx >= 1  && ny <= n && ny >= 1 && virus[ny][nx]==1) {
                    // 상하 좌우 좌표 중에 바이러스 있는게 있다면
                    // 부모를 연결한다
                    connect(parent  , n*x +y,nx*n+ ny);
                }

            }

            result.add(size[getParent(n*x +y,parent)]);

        }
        Iterator it = result.iterator();
        while(it.hasNext())
            System.out.println(it.next());

    }

    private static void connect(int[] parent, int i, int j) {
        i = getParent(i ,parent); // 2 - 4
        j = getParent(j ,parent); // 3 - 2
        // root 집합을 포합시켜준다
        if(i!=j){
            if(i < j ) {
                parent[j] = i;
                size[i] += size[j];
                size[j]=0;
            }
            else {
                parent[i] = j;
                size[j] += size[i];
                size[i]=0;
            }
        }

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
            return parent[number] = getParent(parent[number],parent);
        }
    }

}
