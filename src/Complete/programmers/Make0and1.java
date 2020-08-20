package Complete.programmers;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Make0and1 {
    static List list0 = new ArrayList<Point>(); // 기둥
    static List list1 = new ArrayList<Point>(); // 보
    static int[][] result ;
    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer ;
        for (int i = 0; i < build_frame.length; i++) {
            Point point = new Point(build_frame[i][0], build_frame[i][1]); // 좌표
            int type = build_frame[i][2];// 기둥 0 , 보 1
            int command = build_frame[i][3]; // 삭제 0 , 추가 1
            boolean flag; // 결과
            updateList(type,point,command); // 보나 기둥 리스트에 해당 좌표를  추가를 하거나 뺀다
            flag = checklist();// 리스트들의 조건을 검사한다
            if(!flag){
                if(command==0)command=1;
                else command=0;
                updateList(type,point,command);
            }
        }
        makeResultList();
        Arrays.sort(result, (r1, r2) -> {
            if (r1[0] == r2[0]) {
                if (r1[1] == r2[1]) return Integer.compare(r1[2], r2[2]);
                else return Integer.compare(r1[1], r2[1]);
            } else return Integer.compare(r1[0], r2[0]);
        });
        answer=result;
        return answer;
    }

    private static void makeResultList() {
        int idx=0;
        result = new int[list1.size()+list0.size()][3];
        Iterator<Point> iter0 = list0.iterator();Iterator<Point> iter1 = list1.iterator();
        while (iter0.hasNext()){
            Point p = iter0.next();
            result[idx][0]= p.x; result[idx][1]= p.y; result[idx++][2]= 0;
        }
        while (iter1.hasNext()){
            Point p = iter1.next();
            result[idx][0]= p.x; result[idx][1]= p.y; result[idx++][2]= 1;
        }
    }

    private static boolean checklist() {
        Iterator<Point> iterator0 = list0.iterator();
        Iterator<Point> iterator1 = list1.iterator();
        while(iterator0.hasNext()){
            if(!isaddable0(iterator0.next()))
                return false;
        }
        while(iterator1.hasNext()){
            if(!isaddable1(iterator1.next()))
                return false;
        }
        return true;
    }

    private static void updateList(int type, Point point, int command) {
        if(type==0){// 기둥
            if(command==0) list0.remove(point);
            else list0.add(point);
        }else {
            if(command==0) list1.remove(point);
            else list1.add(point);
        }
    }


    private static boolean isaddable1 (Point point){
            int x = point.x; int y = point.y;
            if (list0.contains(new Point(x, y - 1)) || list0.contains(new Point(x + 1, y - 1)))
                return true;
            else if (list1.contains(new Point(x - 1, y)) && list1.contains(new Point(x + 1, y)))
                return true;
            else
                return false;
    }
     private static boolean isaddable0 (Point point){
        int x = point.x; int y = point.y;
            if (y == 0) // 기둥이 바닥 위에 있는거면
                return true;
            else if (list1.contains(new Point(x - 1, y)) || list1.contains(new Point(x, y)))//보의 한쪽 끜부분 위에
                return true;
            else if (list0.contains(new Point(x, y - 1))) //밑에 기둥이 있으면
                return true;
            else
                return false;
        }

}