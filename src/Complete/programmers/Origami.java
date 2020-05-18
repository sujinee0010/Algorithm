package Complete.programmers;

public class Origami {
    //프로그래머스 종이접기
    static String dp[];
    public static int[] solution(int n) {
        int [] answer;
        dp = new String[n+1];
        dp[1]="0";
        for(int i=1;i<=n;i++){
            if(i==1) continue;
            dp[i]= dp[i-1]+"0"+convert(dp[i-1]);
        }

        answer = new int[dp[n].length()];

        for(int i=0;i<dp[n].length();i++){
            int num = Integer.parseInt(dp[n].charAt(i)+"");
            answer[i]= num;
        }
       return answer;
    }

    private static String convert(String s) {
        s = s.replaceAll("1","2");
        s = s.replaceAll("0","1");
        s = s.replaceAll("2","0");
        s = reverseStr(s);
        return s;
    }

    public static String reverseStr(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }

}
