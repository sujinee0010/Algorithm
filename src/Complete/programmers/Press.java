package Complete.programmers;

import java.util.HashMap;
import java.util.Map;

public class Press {

    //프로그래머스 카카오2020 문자열 압축
    public static int solution(String s) {

        int min =0;

        for(int i = 1;i<=s.length();i++) {

            Map<String, Integer> map = new HashMap<>();
            // 압축 문자열 길이
            int len=0;

            //남은 문자열 길이
            int cnt=s.length();

            //이전 문자열 구간 기록
            String before="";

            for(int j = 0;j<s.length();j+=i) {

                //남은 문자열이 자르는 것보다 작은 크기일 떄 그대로 넣어주고 종료
                if(cnt<i){
                    len+=cnt;
                    break;
                }


                // 자른 구간
                String sub = s.substring(j,j+i);

                // 1. 연속 , 반복 되는 경우
                if(sub.equals(before)) {
                    map.computeIfPresent(sub, (k, v) -> v + 1);
                }
                else {
                    //2. 연속은 아닌데 이미 있는 문자열 일 경우
                    if(map.containsKey(sub)) {

                        String num = Integer.toString(map.get(sub));
                        //길이를 계산하고 삭제 후 다시 넣어준다
                        if(map.get(sub)>1) len+= sub.length() + num.length();//숫자
                        else len+= sub.length();

                        map.remove(sub);
                        map.put(sub, 1);


                    }
                    //3. 아예 처음 나온 문자일 경우
                    map.putIfAbsent(sub, 1);
                }

                // 현재 문자열을 이전으로 기록
                before = sub;

                // 남은 문자열 수 계산
                cnt-=i;

            }

            // 총 길이 계산

            for(String key : map.keySet()){
                if(map.get(key)>1){
                    String num = Integer.toString(map.get(key));
                    len+= key.length() + num.length();//숫자
                }else{
                    len+= key.length();
                }
            }

            // min값 찍기
            if(min==0)min=len;
            else min = Math.min(len,min);

        }

        return min;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution("xababcdcdababcdcd"));
    }
}
