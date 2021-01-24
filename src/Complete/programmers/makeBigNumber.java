package Complete.programmers;

public class makeBigNumber {
    public String solution(String number, int k) {
        String answer = "";
        int mdx =0;
        for(int i =k ;i<number.length();i++) {
            char max ='0';
            // max 다음 인덱스
            for(int j =mdx; j<=i;j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    mdx = j+1;
                }
            }
            answer+=max;

        }
        return answer;
    }
}
