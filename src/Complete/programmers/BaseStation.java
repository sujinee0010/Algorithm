package Complete.programmers;
// 프로그래머스 기지국 완전탐색
public class BaseStation {
    public static int solution(int n, int[] stations, int w) {
        int answer =0;
        int position =0;
        int si=0;

       while(position<n){
           if( si <stations.length && position+1 >= stations[si] - w ) {
               position = stations[si] + w ;
               si++;
           }
           else {
               position += 2 * w + 1;
               answer++;
           }
       }
       System.out.println(answer);
       return answer;
    }
}
