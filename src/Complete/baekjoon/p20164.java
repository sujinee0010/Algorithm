package Complete.baekjoon;

import java.util.Scanner;

public class p20164 {
    static int min_ans = -1;
    static int max_ans = -1;
    // 현재 수의 각 자리 중에서 홀수인 것은 카운팅한다.
    // 현재 수의 자릿수를 센다.
    // 1자리면 종료 한다, 최솟값 , 최대값 갱신한다
    // 2자리면 나누어서 더한다
    // 3자리 이상이면 3개로 나누고 더한다 -> 나누는 방법 i 와 j 위치를 조정해서 은 (0,i) (i,j) (j,n)

    public static int countOdd(String num){
        int ans=0;
        for(int i=0;i<num.length();i++){
            if (Character.getNumericValue(num.charAt(i))%2 !=0)
                ans++;
        }
        return ans;
    }

    public static void makeNumber(String num , int cnt){
        int ans = countOdd(num) + cnt;
        if (num.length()==1){
            if (min_ans==-1)min_ans = ans;
            if (max_ans==-1)max_ans = ans;
            min_ans = Math.min(min_ans,ans);
            max_ans = Math.max(max_ans,ans);
        }else if (num.length()==2){
            int num1 = Integer.parseInt(num.substring(0,1));
            int num2 = Integer.parseInt(num.substring(1,2));
            makeNumber(Integer.toString(num1+num2 ), ans);
        }else{
            // 0-i / i-j / j - n
            for(int i=1 ; i < num.length()-1;i++) {
                for(int j=2 ; j < num.length();j++) {
                    if(i<j) {
                        int num1 = Integer.parseInt(num.substring(0, i));
                        int num2 = Integer.parseInt(num.substring(i, j));
                        int num3 = Integer.parseInt(num.substring(j));
                        makeNumber(Integer.toString(num1+num2+num3 ), ans);
                    }
                }
            }
        }

    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        makeNumber(num,0);
        System.out.println(min_ans+" "+max_ans);

    }

}
