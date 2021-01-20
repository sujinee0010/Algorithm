package Complete.programmers;

import java.util.ArrayList;
/*
* 줄 서는 방법 - 구현할거 어느정도 정리하고 하기 ...
*
* num_list=[]
*
* while(true):
*
* 몫 = k / (n-i)!
* 나머지 = k % (n-i)!
*
* 나머지가 0인경우
*  ans[ai] = num_list[몫-1]
*  해당 숫자 리스트에서 삭제
*  나머지 ans 배열 num_list의 남은 숫자 내림차순으로 채우고 반복문 종료
* 나머지가 있는 경우
*  ans[ai] = num_list[몫+1-1]
*  해당 숫자 리스트에서 삭제
*  k를 나머지로 갱신
*  i 를 증가
*
* */
public class Line {
    public static void makeFacArr(long[] facarr) {
        long mult = 1;
        for(int i=1;i<facarr.length;i++){
            mult*=i;
            facarr[i] = mult;
        }
    }
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        int aidx =0 ;
        long[] facarr = new long[n+1];
        makeFacArr(facarr);
        int fidx = facarr.length -2 ;
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=1;i<=n;i++)
            nums.add(i);
        // 몫
        int mock, mod =0;
        while(true){
            mock = (int) (k / facarr[fidx]);
            mod = (int) (k % facarr[fidx]);
            if(mod==0){
                answer[aidx++] = nums.get(mock-1);
                nums.remove(mock-1);
                int sidx=nums.size()-1;
                for(int i=aidx ;i<answer.length;i++){
                    answer[i]= nums.get(sidx);
                    sidx--;
                }
                break;
            }
            else{
                answer[aidx++] = nums.get(mock);
                nums.remove(mock);
                k %= facarr[fidx--];
            }
        }
        return answer;
    }
    public static void main(String args[]){
        solution(4,6);
    }
}
