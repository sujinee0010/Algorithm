package Complete.programmers;

public class Skillcheck3_2 {
    public static int solution(int N, int number) {
        int answer = 0;
        int nums[] = new int[8];
        nums[0]=N;
        for(int i=1;i<nums.length;i++)
            nums[i] =  Integer.parseInt(Integer.toString(nums[i-1])+N);

        answer = makeNumber(8,nums,number,0,0," ");
        if(answer>8)
            answer=-1;

        return answer;
    }

    private static int makeNumber(int i, int[] nums, int number, int cnt, int sum , String msg) {
        int ans = 100000;

        if(i<=cnt || sum==number){
            if(sum==number)
                return cnt;
            else
                return 100000;
        }

        for(int j=0;j<nums.length;j++){
            ans= Math.min(ans,makeNumber(i,nums,number,cnt+j+1,sum+nums[j] ,msg+"+"+nums[j]));
            ans= Math.min(ans,makeNumber(i,nums,number,cnt+j+1,sum-nums[j],msg+"-"+nums[j]));
            ans= Math.min(ans,makeNumber(i,nums,number,cnt+j+1,sum/nums[j],msg+"/"+nums[j]));
            ans= Math.min(ans,makeNumber(i,nums,number,cnt+j+1,sum*nums[j],msg+"*"+nums[j]));
        }

        return ans;
    }

    public static void main(String args[]){
        System.out.println(solution(5, 12));
    }


}
