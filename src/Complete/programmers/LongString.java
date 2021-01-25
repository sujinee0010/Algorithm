package Complete.programmers;

public class LongString {
    // 큰거 부터 하면 효율성 줄여짐
    // substring 또는 reverse 하면 시간초과
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
}
