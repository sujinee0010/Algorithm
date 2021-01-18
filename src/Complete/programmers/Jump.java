package Complete.programmers;
/*
멀리 뛰기

- long 형 일 경우 조심 하자
- 구하는 값만 마지막에 디바이드 하는 게 아니라 디바이드 된 값으로 dp 배열 갱신
- 점화식 dp[n] = dp[i-2]+dp[i-1] // 현재 칸 뛰는 방법 = 2칸 뛰기 전 방법  +1칸 뛰기 전 방법

*/
public class Jump {
    public static long solution(int n) {
        long answer = 0;
        long[] dp = new long[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]= (dp[i-2]+dp[i-1]) % 1234567;
        }
        answer = dp[n]; 
        return answer;
    }
    public static void main(String args[]){
        System.out.println(solution(98));
    }
}
