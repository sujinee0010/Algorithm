package Complete.programmers;
/*
* 첫집 포함 경우 or 막집 포함 경우 
* */
public class Theif {
    public int solution(int[] money) {
        int dp1[] = new int[money.length-1];
        int dp2[] = new int[money.length-1];
        dp1[0]= money[0];
        dp1[1]= Math.max(money[0],money[1]);

        dp2[0]= money[1];
        dp2[1]= Math.max(money[1],money[2]);

        for(int i=2;i<dp1.length;i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+money[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i+1]);
        }

        return Math.max(dp1[money.length-2],dp2[money.length-2]);
    }
}
