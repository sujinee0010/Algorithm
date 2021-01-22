package Complete.programmers;

import java.util.HashSet;
import java.util.Iterator;

public class FindPrimeNum {
    static HashSet<Integer> nums = new HashSet();
    static boolean isPrime (int num){
        if (num<=1) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        return true;
    }

    static void dfs(String numbers , int cnt , String mnum , boolean isused[]){
        if(cnt==numbers.length() && !mnum.equals("")){
            nums.add( Integer.parseInt(mnum));

        }else{
            for(int i=0;i<numbers.length();i++){
                if(isused[i]==false){
                    isused[i]=true;
                    dfs(numbers,cnt+1,mnum+numbers.charAt(i),isused);
                    isused[i]=false;
                }
            }
            if(!mnum.equals(""))
                nums.add( Integer.parseInt(mnum));

        }

    }

    public static int solution(String numbers) {
        int answer = 0;
        boolean isused[] = new boolean[numbers.length()];

        dfs(numbers,0,"",isused);
        Iterator it = nums.iterator();
        while(it.hasNext()){
            if (isPrime((int)it.next()))
                answer++;
        }
        return answer;
    }

    public static void main(String args[]){
        System.out.println(solution("011"));
    }
}
