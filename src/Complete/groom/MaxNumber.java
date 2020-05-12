package Complete.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxNumber {
    // 구름: 최대자리곱
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        long range =Long.parseLong(input);
        //10 미만 일 경우
        if(range<10) {
            System.out.println(range);
            return;
        }

        long len = input.length();

        double max = 0;
        long nums = 1;

        for(int i =0; i<len;i++){

            double mul = 1;

            int number = Integer.parseInt(input.charAt(i)+"");
            double restLen = len - (i+1);

            //0일 경우 ( 첫째자리는 아니고 n번쨰 자릿수 일경우 -> 이미 최대를 계산함 )
            if (number == 0) break;

            //첫짜리가 1일 경우 9999.. 가 최대
            if(number == 1 && i == 0){
                mul =  Math.pow(9,restLen);
            }

            else if (number == 1 && i != 0 && restLen !=0){
               continue;
            }

            else {
                //마지막 자릿수 일 때
                if(restLen ==0) {
                    mul = nums * number * Math.pow(9, restLen);
                }else {
                    mul = nums * (number - 1) * Math.pow(9, restLen);
                }
            }
            //최댓값 기록
            if(max == 0) max = mul;
            else{
                max = Math.max(mul,max);
            }
            //원래 자릿수 계속 곱하기
            nums *= number;

        }

        System.out.println((long) max);

    }
}
