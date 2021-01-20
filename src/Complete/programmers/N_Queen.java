package Complete.programmers;
/*
* 
* 대각선의 열 값은 은 증가율 만큼 빼면 됨!
* 사소한 실수 주의 (절댓값 붙일 때)
* */
public class N_Queen {
    public static int solution(int n) {
        int col [] = new int[n];
        return dfs(0,col);
    }
    static boolean isPossible(int x,int y, int col[]){
        for(int i=0;i<x;i++){
            // 세로 체크, 대각선 체크
            if((col[i]==y) || ( Math.abs(col[i] - y) == x-i)) return false;
        }
        return true;
    }
    static int dfs(int num , int col[]){
        int answer = 0;
        if(num == col.length)
            return 1;
        else
        {
            for(int i=0;i<col.length;i++){
                if(isPossible(num, i , col)){
                    // 선택
                    col[num] = i;
                    answer += dfs(num+1,col);
                    // 선택 안한 경우 초기화
                    col[num] =0;
                }
            }
        }
        return answer;
    }

    public static void main(String args[]){
        System.out.println(solution(4 ));
    }
}
