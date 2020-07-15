package Complete.programmers;
// 프로그래머스 다리를 지나는 트럭
import java.util.Stack;
public class Truck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Stack<Integer> stack = new Stack<>();
        int endtimes[] = new int[truck_weights.length];
        int time=0,eidx=0,idx=0,pw=0;
        while( idx != truck_weights.length || !stack.isEmpty()){
            if(!stack.isEmpty()&& time == endtimes[eidx]) { //엔드타임 넘어가면
                pw -= stack.firstElement(); // 현재 무게에서 뺴줌
                stack.remove(stack.firstElement()); // 스택에서 뺴줌
                eidx++;
            }
            if(idx<truck_weights.length && pw + truck_weights[idx] <= weight) {
                stack.push(truck_weights[idx]);// 스택에 넣어줌
                pw += truck_weights[idx];//무게 넣기
                endtimes[idx++] = time + bridge_length; // 현재 시간 + 다리 길이 가 끝나는 시간
            }
            time++;
        }
        return time;
    }
}
