package Complete.programmers;

import java.util.*;
//프로그래머스 보석쇼핑
public class JewelryShopping {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int n = (int) Arrays.stream(gems).distinct().count();
        Map<String,Integer> map = new HashMap<>();
        int term=-1,start=-1,end=-1;
        int l=0,r=0;
        while(true){
            if(map.size()==n){
                int tstart = l; int tterm = (r-1)-l ; int tend = r-1;
                if((term == -1) ||(tterm<term)||(tterm==term && tstart<start)) {
                    term=tterm; start=tstart; end =tend;
                }
                if(map.get(gems[l])==1) map.remove(gems[l]);
                else map.computeIfPresent(gems[l], (k, v) -> v-1);
                l++;

            }else if(l==gems.length || r==gems.length) break; // **
             else{
                map.computeIfPresent(gems[r], (k, v) -> v+1);
                map.putIfAbsent(gems[r],1);
                r++; //인덱스 자체에서 ++하면 증가 2번 됨
            }
        }
        answer[0]=start+1;
        answer[1]=end+1;
        return answer;
    }
}
/*
 public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        //보석 개수
        int n = (int) Arrays.stream(gems).distinct().count();
        Map<String,Integer> map = new HashMap<>();
        int term=0,start=0,end=0;
        int l=0,r=0;

        while(true){
            if(map.size()==n){
                int tstart = l; // 구간 시작
                int tterm = (r-1)-l ; // 구간 길이
                int tend = r-1;
                //정답 기록
                if(term == 0){
                    term=tterm; start=tstart; end =tend;
                }else{
                    if(tterm<term){
                        term = tterm; start = tstart; end =tend;
                    }
                    else if(tterm==term && tstart<start){
                        term =tterm; start =tstart; end =tend;
                    }
                }
                // map에서 제거
                if(map.get(gems[l])==1)
                    map.remove(gems[l]);
                else
                    map.computeIfPresent(gems[l], (k, v) -> v-1);
                l++;

            }else if(l==gems.length || r==gems.length) break;
            else{
                map.computeIfPresent(gems[r], (k, v) -> v+1); map.putIfAbsent(gems[r],1);
                r++;
            }
        }
        answer[0]=start+1;
        answer[1]=end+1;
        return answer;
    }
*/