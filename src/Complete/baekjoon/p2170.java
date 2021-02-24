package Complete.baekjoon;

import java.awt.*;
import java.io.*;
import java.util.*;
// 라인스위핑 - 정렬 잊지말기 ! / o(n) 인데 시간초과 뜨면 버퍼리더
public class p2170 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum=0;


      Stack<Integer> stack = new Stack<>();

        // 선 (x,y)쌍 입력
        ArrayList<Point> lines = new ArrayList<>();
        for(int i=0;i<n;i++){
            String line[] = br.readLine().split(" ");
            int first = Integer.parseInt(line[0]);
            int second = Integer.parseInt(line[1]);
            lines.add(new Point(first,second));
        }

        // x 오름차순 , x 같으면 y 오름차순 정렬
        Collections.sort(lines, (o1, o2) -> {
            if(o1.x == o2.x)
                return o1.y-o2.y;
            return o1.x - o2.x;
        });


        //각 선분 x, y 값 이전 선분과 비교 하면서 sum 값 누적
        stack.push(lines.get(0).x);
        stack.push(lines.get(0).y);

      for(int i=1;i<lines.size();i++){
          int start = lines.get(i).x;
          int end = lines.get(i).y;

          if(stack.peek()>=start){
              if(stack.peek() < end){
                stack.pop();
                stack.push(end);
              }
          }else {
              sum+= stack.pop() - stack.pop();
              stack.push(start);
              stack.push(end);
          }
      }

      if(!stack.isEmpty())
          sum+= stack.pop() - stack.pop();

        System.out.println(sum);
    }
}
