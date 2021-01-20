package Complete.programmers;

public class N_Queen {
    public static int solution(int n) {
        boolean arr[][] = new boolean[n][n]; // false 로 초기화 ?
        return dfs(0,arr);
    }

    static boolean isPossible(int x,int y, boolean arr[][]){
        for(int i=0;i<x;i++){
            // 대각선 체크
            // 세로 체크
            if(arr[i][y]) return false;
            if(y-(x-i)>=0) {
                if (arr[i][y - (x - i)]) return false;
            }
            if(y+(x-i)<arr.length) {
                if (arr[i][y + (x - i)]) return false;
            }
        }
        return true;
    }
    static int dfs(int num , boolean arr[][]){
        int answer = 0;
        if(num >= arr.length)
            return 1;
        else
        {
            for(int i=0;i<arr[num].length;i++){
                if(isPossible(num, i , arr)){
                    // 선택
                    arr[num][i] =true;
                    answer += dfs(num+1,arr);
                    // 선택 안한 경우 초기화
                    arr[num][i] =false;

                }
            }
        }
        return answer;
    }

    public static void main(String args[]){
        System.out.println(solution(4 ));
    }
}
