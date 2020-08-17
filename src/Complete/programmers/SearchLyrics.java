package Complete.programmers;

import java.util.StringTokenizer;
//가사검색 , 시간 초과 
public class SearchLyrics {
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            String qr = queries[i];
            StringTokenizer st = new StringTokenizer(qr,"?");
            String sw = st.nextToken(); // 문자열 부분
            int sp = qr.indexOf(sw);// 문자열 시작 위치
            int ep = sp + sw.length()-1; // 문자열 종료 위치
            for(int j=0;j<words.length;j++){
                String w = words[j];
                if(w.length()==qr.length() &&
                w.substring(sp,ep+1).equals(sw))
                    answer[i]++;
            }
        }
        return answer;
    }
    public static void main(String args[]){
        String [] words ={"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String [] qrs = {"fro??", "????o", "fr???", "fro???", "pro?"};
        solution(words,qrs);
    }
}
