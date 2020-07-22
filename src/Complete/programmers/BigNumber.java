package Complete.programmers;

import java.util.*;
import java.util.stream.Collectors;
// 테케 일부 오류 ->수정 필요
public class BigNumber {
    public static class Number {
        private String number;
        Number(String number){
            this.number = number;
        }
        public int getNumFirst(){
            return Character.getNumericValue(number.charAt(0));
        }
        public int getNumSecond(){
            if(number.length()>=2) // 91
            {   if(Character.getNumericValue(number.charAt(1))==0)
                    return -1;
                else
                    return Character.getNumericValue(number.charAt(1));
            }
            else // 9
                return 0;
        }
        public int getNumThird(){
            if(number.length()>=3)
            {   if(Character.getNumericValue(number.charAt(2))==0)
                return -1;
            else
                return Character.getNumericValue(number.charAt(2));
            }

            else
                return 0;
        }
    }
    public static String solution(int[] numbers) {
        String answer = "";

       int len = (int) Arrays.stream(numbers).filter(x->x==0).count();
       if(len==numbers.length) return "0";
        ArrayList<Number> tnum = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            tnum.add(new Number(Integer.toString(numbers[i])));
        }

        ArrayList<Number> sorted = (ArrayList<Number>) tnum.stream().sorted(Comparator.comparing(Number::getNumFirst)
                .thenComparing(Number::getNumSecond)
                .thenComparing(Number::getNumThird).reversed()).collect(Collectors.toList());


        Iterator<Number> sit = sorted.iterator();
        while (sit.hasNext()){
            answer+= sit.next().number;
        }

        //System.out.println(answer);
        return answer;
    }

    public static void main(String args[]){
        int n[]={0,0,0,0};//3, 30, 34, 5, 9
        System.out.println(solution(n));
    }
}
