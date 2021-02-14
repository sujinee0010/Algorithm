package Complete.programmers;

import java.util.*;

public class Skillcheck3 {
    public int[] solution(String[] operations) {
        int[] answer;

        TreeMap<Integer,Integer> numbers = new TreeMap<>(Collections.reverseOrder());
        // 숫자 , 빈도수

        for(int i=0;i<operations.length;i++){
            String console[] = operations[i].split(" ");
            String c = console[0];
            int number = Integer.parseInt(console[1]);
            if(c.equals("I")){
                if(numbers.isEmpty() || !numbers.containsKey(number))
                    numbers.put(number,1);
                else
                    numbers.put(number,numbers.get(number)+1);
            }else if(!numbers.isEmpty()){
                if(number==1) {
                    if (numbers.get(numbers.firstKey()) == 1)
                        numbers.remove(numbers.firstKey());
                    else
                        numbers.put(numbers.firstKey(), numbers.get(numbers.firstKey()) - 1);
                }else{
                    if (numbers.get(numbers.lastKey()) == 1)
                        numbers.remove(numbers.lastKey());
                    else
                        numbers.put(numbers.lastKey(), numbers.get(numbers.lastKey()) - 1);
                }
            }

        }


        if(numbers.isEmpty())
            answer= new int[]{0, 0};
        else
            answer = new int[]{numbers.firstKey(),numbers.lastKey()};

        return answer;
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);







    }
}
