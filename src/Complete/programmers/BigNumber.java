package Complete.programmers;

import java.util.*;
//프로그래머스 가장 큰 수
public class BigNumber {
    public String solution(int[] numbers) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++)
            list.add(numbers[i]);
        //내립차순
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list)
            sb.append(i);
        answer = sb.toString();
        if(answer.charAt(0) == '0')
            return "0";
        else
            return answer;

    }
}
