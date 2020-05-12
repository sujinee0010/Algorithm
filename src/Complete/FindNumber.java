package Complete;

import java.util.*;

// 프로그래머스 고득점키트>완전탐색>소수 찾기

public class FindNumber {

    //숫자 조함 리스트
    static List<Integer> list = new ArrayList<Integer>();

    public static int solution(String numbers) {
        int answer=0;

        boolean visited[] = new boolean[numbers.length()];
        Arrays.fill(visited, false);

        //숫자 조함 생성 (빈 값,0값 제외)
        list= makeNumbers(numbers,"",0,visited);

        //리스트 내의숫자 중복 검사
        TreeSet<Integer> treeSet = new TreeSet<Integer>(list);
        List<Integer> numList = new ArrayList<Integer>(treeSet);

        for(int i=0;i<numList.size();i++){
            System.out.println(numList.get(i));
        }


        //소수 판별
        for(int i=0;i<numList.size();i++){
            //System.out.println(numList.get(i));
            if(isPrime(numList.get(i)))
                answer++;
        }


      return answer;
    }


    public static List<Integer> makeNumbers(String numbers,String number,int node,boolean visited[]) {

        //노드 탐색 횟수는 주어진 스트링 만큼만
        if(node<numbers.length()) {
            for(int i=0;i<numbers.length();i++) {

                //이미 탐색한 노드는 탐색 안함
                if (visited[i] == false) {
                    //포함
                    visited[i] = true;
                    makeNumbers(numbers, number + numbers.charAt(i),node + 1, visited);

                    //포함 안함 (다시 초기화)
                    visited[i] = false;
                    makeNumbers(numbers, number,node + 1, visited);
                }

            }

        }

        //노드 모두 탐색하고 널값,0 값 처리 주의
        if(node==numbers.length() && !number.equals("") ) {
            list.add(Integer.parseInt(number));

        }
        return list;
    }



    private static boolean isPrime(int n) {

        if (n == 1|| n==0 ) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


    public static void main(String args[]) {

        String numbers = "011";
        System.out.println(solution(numbers));

    }


}
