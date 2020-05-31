package Complete.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DevelopFunction {
    //프머스 스택 : 기능개발
    public static int[] solution(int[] progresses, int[] speeds) {

        Stack<Integer> stack = new Stack();
        List<Integer>ans = new ArrayList();

        for(int i=0;i<progresses.length;i++){
            int rest = 100- progresses[i];
            int days = (int)(Math.ceil((double)rest/(double)speeds[i]));

            // 7 3 4 9
            if(stack.isEmpty())
                stack.push(days);

            else{
                if(stack.firstElement()>=days)
                    stack.push(days);
                else{
                    ans.add(stack.size());
                    stack.removeAllElements();
                    stack.push(days);
                }
            }
        }
        if(!stack.isEmpty()) ans.add(stack.size());

        int[] answer = ans.stream().mapToInt(i->i).toArray();

       return answer;
    }
}
