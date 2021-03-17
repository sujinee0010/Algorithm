package Complete.baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p17255 {
    /*
    * 처음에 틀린 이유 : 808 같은경우 "08" 이 정수 변환시 8 이 되어서 틀림
    * string 값 자체로 dp 만들어주기 ( map 사용 ) -> 해결 ..
    * */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        Map<String,Integer> dp = new HashMap<>();
        make(number,Integer.parseInt(number) ,dp);

        System.out.println(dp.get(number));

    }

    private static String make(String number, int didx , Map<String,Integer> dp) {
        if(number.length()==1){
            dp.put(number,1);
            return number;
        }
        else
        {
            String ll = make(number.substring(0,number.length()-1),didx-1,dp);
            String rr = make(number.substring(1),didx-1,dp);

            if(!ll.equals(rr))
                dp.put( number, dp.get(ll) + dp.get(rr) );
            else
                dp.put( number, dp.get(ll));

            return number;
        }
    }
}
