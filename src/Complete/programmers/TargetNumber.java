package Complete.programmers;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers,0,0,target);
        return answer;
    }
    public int dfs(int[] numbers,int cnt , int sum,  int target){

        if(cnt >= numbers.length){
            if(sum==target)
                return 1;
            else
                return 0;
        }
        return dfs(numbers,cnt+1,sum+numbers[cnt],target)+dfs(numbers,cnt+1,sum-numbers[cnt],target);
    }
}
