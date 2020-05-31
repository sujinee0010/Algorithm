package Complete.programmers;

import java.util.*;

public class Top {
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> place = new Stack<>();

        for(int i=0;i<heights.length;i++){
            int top = heights[i];
            if(stack.isEmpty()){
                stack.add(top);
                place.add(i+1);
                answer[i] = 0;
            }else{
                if(stack.peek() > top){
                    answer[i]= place.peek();
                    stack.push(top);
                    place.push(i+1);
                }
                else{
                    if(stack.firstElement()<= top){
                        stack.removeAllElements();
                        place.removeAllElements();
                        answer[i]=0;
                    }else {
                        while (stack.peek() <= top) {
                            stack.pop();
                            place.pop();
                        }
                        answer[i]= place.peek();
                    }
                   stack.push(top);
                   place.push(i+1);
                }
            }
        }
        return answer;
    }
}
