package Complete.programmers;

import java.awt.*;
import java.util.*;
import java.util.List;
//프로그래머스 베스트앨범
public class BestAlbum {
    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList();
        Map<String, List<Point>> map = new HashMap();

        for(int i=0;i<genres.length;i++){
            if(!map.containsKey(genres[i]))
                map.put(genres[i],new ArrayList<>());
            map.get(genres[i]).add(new Point(i,plays[i]));
        }

        List<String> keySetList = new ArrayList(map.keySet()); // 키 집합 리스트 ,키 셋 반환 Set
       for(int i=0;i<keySetList.size();i++){
           System.out.println(keySetList.get(i));
       }

        //맵에 있는 밸류 값을 비교 해서 키 정렬한 키값을 키셋리스트에 담는다  (map  순서가 바뀐게 아님 )
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).stream().map(Point::getY).reduce(Double::sum).get().
                compareTo(map.get(o1).stream().map(Point::getY).reduce(Double::sum).get())));

        for(String key : keySetList){
            List<Point> list = map.get(key);
            list.sort(Comparator.comparing(Point::getY).reversed().thenComparing(Point::getX));
            if(list.size()<2)
                answer.add(list.get(0).x);
            else {
                for (int i = 0; i < 2; i++)
                        answer.add(list.get(i).x);
                }
            }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
