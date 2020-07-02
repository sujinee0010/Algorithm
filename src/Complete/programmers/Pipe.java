package Complete.programmers;

import java.util.Stack;
//프로그래머스 쇠막대기
public class Pipe {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arrangement.length();i++){
            if(arrangement.charAt(i)=='(')
                stack.push(i);
            else if(arrangement.charAt(i)==')'){
                if(stack.peek()+1 == i ){
                    stack.pop();
                    answer+=stack.size();
                }else{
                    stack.pop();
                    answer+=1;
                }
            }
        }
        return answer;
    }

   /*
   *  public int solution(String arrangement) {
        int answer = 0;
        //replaceall은 정규식
        arrangement= arrangement.replace("()","0");
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<arrangement.length();i++){
            char c = arrangement.charAt(i);
            stack.push(c);
            if(c==')'){
                stack.pop(); // ) 제거
                int cpnt=0;
                for(int j=stack.size()-1;j>=0;j--){
                    char c1 = stack.get(j);
                    if(c1=='0') cpnt++;

                    else if(c1=='('){
                        answer += cpnt+1; // 자름
                        stack.remove(j); // 괄호 삭제
                        break;
                    }
                }
            }
        }
        return answer;
    }*/
}
