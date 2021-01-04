package Complete.programmers;

import java.util.Arrays;

public class SearchCam {
    public static int solution(int[][] routes) {
        int answer = 0; // 카메라의 갯수
        int camera = -30001; // 카메라의 위치
        Arrays.sort(routes,(a,b) -> Integer.compare(a[1],b[1]));
        for(int[] route: routes){
            if (camera < route[0]){
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
    
    public static void main(String args[]){
        int c[][]= {{-20,15}, {-14,-5}, {-18,-13},{-5,-3}};
        System.out.println(solution(c));
    }

}
