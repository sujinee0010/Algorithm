package Complete.programmers;

import java.util.*;

public class MakdMaxNumber {
    public static String soltuion(int[] numbers){
        String ans="";
        String str_num[] = new String[numbers.length];
        for(int i=0;i<numbers.length;i++)
            str_num[i]=Integer.toString(numbers[i]);

        Arrays.sort(str_num , new Comparator<String>(){
            @Override
            public int compare(String s1 , String s2){
                String s13 ="";
                String s23 ="";

                for(int i=0;i<3;i++){
                    s13+=s1;
                    s23+=s2;
                }
                return s23.compareTo(s13); // 내림 차순
            }
        });


        for(int i=0;i<str_num.length;i++)
            ans+=str_num[i];

        if (ans.charAt(0)=='0')
            return "0";
        else
            return ans;
    }
    public static void main(String args[]){

        soltuion(new int[]{0, 5, 10, 15, 20});
        soltuion(new int[]{1000, 0, 5, 99, 100});

    }

}
