package Complete.programmers;

import java.util.Arrays;
// 프로그래머스 징검다리 다시 풀어볼 것
public class Rocks {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int answer = 1;
        int start = 1;
        int end = distance;

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            int last = 0;
            for (int i = 0; i < rocks.length + 1; i++) {
                int gap = i != rocks.length ? rocks[i] - last : distance - rocks[i-1];
                if (gap < mid) {
                    cnt++;
                } else if(i != rocks.length) {
                    last = rocks[i];
                }
            }

            if (cnt > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }
}
