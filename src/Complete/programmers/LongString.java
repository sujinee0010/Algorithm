package Complete.programmers;

public class LongString {
    // DP로 재풀이 
    public int solution(String s)
    {
        int answer = 0;

        int dp[][] = new int[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            dp[i][i] = 1;
            answer = Math.max(answer,dp[i][i]);
            if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 2;
                answer = Math.max(answer,dp[i][i+1]);
            }

        }

        //3자리 부터 n자리까지 dp
        for(int i=2;i<=s.length();i++){
            for(int j=0;j<s.length()-i;j++){
                if(s.charAt(j)==s.charAt(j+i) && dp[j+1][j+i-1]!=0){
                    dp[j][j+i] =  dp[j+1][j+i-1]+2;
                    answer = Math.max(answer,dp[j][j+i]);
                }
            }
        }
        return answer;
    }
    // 큰거 부터 하면 효율성 줄여짐
    // substring 또는 reverse 하면 시간초과
    /*
    public int solution(String s)
    {
        int answer = 1;

        // n 자리수
        for(int i=s.length() ;i>1;i--){
            for(int j=0; j+i<= s.length(); j++){

                boolean flag = true;
                for(int h=0;h<i/2;h++){
                    if (s.charAt(j+h)!=s.charAt(j+i-1-h)){
                        flag = false;
                        break;
                    }
                }

                if(flag)
                    return i;

            }

        }


        return answer;
    }
     */
}
