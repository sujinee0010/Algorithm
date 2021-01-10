package Complete.NDB;

public class Ice {

    public static int solution(int n , int m , int arr[][]){
        int answer =0;
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++){
                if (dfs(i, j, arr)) {
                    answer += 1;
                }
            }
        }
        return answer;
    }

    public static boolean dfs(int i , int j , int arr[][]){
    // 종료 조건이 뭔지, 리턴 값
        if(i >=0 && i < arr.length && j >=0 && j<arr[0].length) {
            if(arr[i][j]==0){
                arr[i][j]=1;
                //상
                dfs(i-1, j, arr);
                //하
                dfs(i+1, j, arr);
                //좌
                dfs(i, j-1, arr);
                //우
                dfs(i, j+1, arr);
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String args[]){
        int arr[][]={{0,0,1,1,0},{0,0,0,1,1},{1,1,1,1,1},{0,0,0,0,0}};
        System.out.println(solution(4,5,arr));
    }

}
