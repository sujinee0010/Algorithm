package Complete.programmers;
import java.util.*;
import java.awt.*;
public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // yellow 약수 구하기
        ArrayList<Point> num_set = new ArrayList();
        for(int i=1;i<=yellow;i++){
            if(yellow%i==0)
                num_set.add(new Point(i,yellow/i));
        }
        // 약수 마다 brown계산
        Iterator it = num_set.iterator();
        while(it.hasNext()){
            Point nums = (Point)it.next();
            int r = nums.x;
            int c = nums.y;
            // 맞으면 yellow 약수 에다 +2 씩 한 값 리턴
            if(brown == r*2+c*2+4){
                answer[0]=r+2;
                answer[1]=c+2;
                break;
            }

        }
        if(answer[0]<answer[1]){
            int tmp = answer[0];
            answer[0]=answer[1];
            answer[1]=tmp;
        }

        return answer;
    }
}
