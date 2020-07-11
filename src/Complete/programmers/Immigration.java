package Complete.programmers;
//프로그래머스 입국심사
import java.util.*;
public class Immigration {
    public static long solution(int n, int[] times) {
        long answer = 0;
        int s = times.length;
        Arrays.sort(times);
        long min =1;
        long max = (long) times[s-1]*n;
        answer = max;

        while(min<=max){
            long mid = (min+max)/2;
            long sum =0;
            for(int i=0;i<s;i++)
                sum += mid / times[i];
            if(n>sum)
                min = mid + 1; // 찾고자 하는 값이 n 인거  n기준 sum이 작으면  최소 값을 올려줌
            else {
                if(mid <= answer)
                    answer = mid;//정답 갱신
                max = mid-1; // sum이 크면  최대 값을 줄여줌
            }
        }
        return answer;
    }
}
