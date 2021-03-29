package Interview;

import java.util.HashMap;
import java.util.Map;

public class TEST04 {


    private static void mergeSortDevide(int[] arr, int left, int right) {

        /*원소의 수가 2개 이상일경우 실행*/
        if (left < right) {

            /*반으로 나누기 위한 변수*/
            int mid = (left + right) / 2;
            /*앞(왼쪽)부분 재귀 호출*/
            mergeSortDevide(arr, left, mid);
            /*뒤(오른쪽)부분 재귀 호출*/
            mergeSortDevide(arr, mid + 1, right);
            /*원소를 Merge하는 함수*/
            merge(arr, left, mid, right);
        }
    }


    private static void merge(int[] arr, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int temp_index = left;

        int[] temp = new int[arr.length];

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[temp_index++] = arr[i++];
            } else {
                temp[temp_index++] = arr[j++];
            }
        }

        /*앞(왼쪽)부분 배열에 원소가 남아있는 경우*/
        while (i <= mid) {
            temp[temp_index++] = arr[i++];
        }

        /*뒤(오른쪽)부분 배열에 원소가 남아있는 경우*/
        while (j <= right) {
            temp[temp_index++] = arr[j++];
        }

        for (int index = left; index < temp_index; index++) {
            arr[index] = temp[index];
        }
    }

    private static void output_merge_arr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    // 아나그램 - map
    public static boolean isAnagram(char [] s1 , char []s2){
        Map<Character,Integer> s1m = new HashMap<>();
        Map<Character,Integer> s2m = new HashMap<>();
        for (int i=0;i<3;i++){
            if (!s1m.isEmpty()&& s1m.containsKey(s1[i]))
                s1m.put(s1[i], s1m.get(s1[i])+1 );
            else
                s1m.put(s1[i], 1 );

            if (!s2m.isEmpty()&& s2m.containsKey(s2[i]))
                s2m.put(s2[i], s1m.get(s2[i])+1 );
            else
                s2m.put(s2[i], 1 );
        }

        if (s1m.equals(s2m))
            return true;
        else
            return false;
    }
    // 피보나치 - dp
    public static int fibo(int num){
        if (num==0)
            return 0;
        if (num==1)
            return 1;
        int n1 =1;
        int n2 =0;
        int result = 0;

        for(int i=2;i<=num;i++){
            result = n1+n2;
            n2 = n1;
            n1 = result;
            System.out.println(result);
        }

        return result;
    }

    // 패토리얼 - dp
    public static int factorial(int num){
        if (num<=0)
            return 0;
        if (num==1)
            return 1;

        int dp[] = new int[num+1];
        dp[0]=0; dp[1]=1;
        for(int i=2;i<=num;i++){
            dp[i] = i * dp[i-1];
            //System.out.println(dp[i]);
        }

        return dp[num];
    }

    // 팩토리얼 - 재귀
    public static int factorial2(int num){
        if (num==0) return 0;
        if (num==1) return 1;

        return num*factorial(num-1);
    }

    public static void main(String args[]){
        char s1[] = {'a','b','c'};
        char s2[] = {'c','b','a'};

        int n = (int) (Math.random()*10);

        //알파벳
        char uValue = (char)((Math.random()* 26) + 65);   // 대문자
        char lValue = (char)((Math.random() * 26) + 97); // 소문자


        //isAnagram(s1,s2);
        //System.out.println(fibo(7));
        //System.out.println(factorial(4));
        //System.out.println(Math.random()*10);



        int[] arr = { 10, 80, 91, 90, 70 };

        /*원소를 반으로 나누는 함수*/
        mergeSortDevide(arr, 0, arr.length - 1);

        /*합병 정렬된 배열을 출력하는 함수*/
        output_merge_arr(arr);





    }


}
