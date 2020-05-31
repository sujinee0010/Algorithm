package Complete.programmers;

import java.awt.*;
import java.util.Stack;
//프로그래머스 프린터
public class Printer {
    static Stack<Point> stack = new Stack<>();
    public static int solution(int[] priorities, int location) {
        int answer = 1;

        for(int i=0;i<priorities.length;i++){
            stack.push(new Point(priorities[i],i));
        }

        while(!stack.isEmpty()) {
            Point docx = stack.firstElement();
            if(isMax(docx)){
              if(docx.y == location)
                  return answer;

              stack.remove(stack.firstElement());
              answer++;
            }
            else{
              stack.push(docx); // 앞에꺼 뒤에 넣기
              stack.remove(stack.firstElement()); // 앞에꺼 삭제
            }
        }
        return answer;
    }

    private static boolean isMax(Point firstElement) {
        for(int i=0;i<stack.size();i++){
            Point page = stack.get(i);
            int pagePri = page.x;
            if(!page.equals(firstElement)&&(pagePri>firstElement.x))
                return false;
        }
        return true;
    }
}
