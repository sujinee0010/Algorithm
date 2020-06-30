package Complete.programmers;
import java.util.*;
//프로그래머스 단어변환 
public class ChangeWord {
    static int answer = 100;
    public int solution(String begin, String target, String[] words) {
        boolean used [] = new boolean[words.length];
        if(!Arrays.stream(words).anyMatch(s ->s.equals(target))) return 0;
        dfs(begin,target,words,used,0);
        return answer;
    }

    private void dfs(String begin, String target, String[] words,boolean used [],int cnt){
        if(begin.equals(target)) {
            answer= Math.min(answer,cnt);return;
        }
        for(int i=0;i<words.length;i++){
            if(!used[i]){
                 if(compareCnt(begin,words[i])==1) {
                     used[i]=true;
                     dfs(words[i],target,words,used,cnt+1);
                     used[i]=false;
                 }
            }
        }
    }
    private int compareCnt(String s1 , String s2){
        int flag = 0;
        for(int i=0;i<s1.length();i++){
            String c1 = s1.charAt(i)+"";
            String c2 = s2.charAt(i)+"";
            if(!c1.equals(c2))flag++;
        }
        return flag;
    }
}

