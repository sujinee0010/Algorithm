package Complete.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//프로그래머스 위장
public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String , List<String>> map = new HashMap<>();

        for(int i=0;i<clothes.length;i++){
            String cname = clothes[i][0]; // 옷 이름
            String ckind = clothes[i][1]; // 옷 종류

           if(!map.containsKey(ckind))
               map.put(ckind,new ArrayList<>());

           map.get(ckind).add(cname);
        }
        for(String key : map.keySet())
            answer*=(map.get(key).size()+1);
        answer-=1;

        return answer;
    }
}
