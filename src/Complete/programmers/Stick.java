package Complete.programmers;

import java.util.HashMap;
import java.util.Map;
//프로그래머스 조이스틱 실패 
public class Stick {
    public int moveRight(int start , int target, int limit){
        int cnt=0;
        if(start==target) return 0;
        while(true){
            start+=1;
            cnt++;
            if(start==limit)
                start=0;
            if(start==target) break;
        }
        return cnt;
    }
    public int moveLeft(int start , int target, int limit){
        int cnt=0;
        if(start==target) return 0;
        while(true){
            start-=1; // -1
            cnt++; // 1

            if(start==-1) //
                start=limit-1; // z

            if(start==target) break;
        }
        return cnt;
    }
    public int solution(String name) {
        int answer = 0;
       Map map = new HashMap<Character,Integer>();
       for(int i='A',j=0;i<='Z';i++,j++){
           map.put((char)(i),j); // A 0 B 1
       }

        int idx=0;
        int p=0; // 지금 커서

        while(idx<name.length()){

            if(name.charAt(idx)!='A'){
                //a 인 경우는 무시
                int left = moveLeft(p,idx,name.length());
                int right =moveRight(p, idx ,name.length());
                if(left!=right)
                    answer+= Math.min( left, right);
                else answer+=right;
                // 알파벳 바꾸기
                int target = (int) map.get(name.charAt(idx));
                int lefta = moveLeft(0, target, 26 );
                int righta =moveRight(0, target,26);
                if(lefta!=righta)
                    answer+= Math.min( lefta, righta);
                else answer+=righta;
                p=idx;
            }
            idx++;
        }

        return answer;
    }
}
