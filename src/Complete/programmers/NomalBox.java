package Complete.programmers;

public class NomalBox {
    //프로그래머스 멀쩡한 사각형 : 1차 함수 그래프로 생각해서 구현
    public static long solution(int w, int h) {
        long answer = 0;
        for(int i = 0; i < w; i++) {
            answer += ((long) h * i) / (long) w;
            System.out.println(answer);
        }
        return answer * 2;
    }
}
