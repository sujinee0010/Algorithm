package Complete.baekjoon;

import java.util.Scanner;

public class p2138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        String d = sc.next(); // 000
        String state = sc.next(); // 010
        int ans=10000000;

        
        int first_cnt =1;
        // 첫번쨰 버튼 누른다
        String tmp = reverse(0,d);
        tmp = reverse(1,tmp);
        //System.out.println(tmp);
        for(int i=1;i<tmp.length();i++){
            char before = tmp.charAt(i-1);
            if(before != state.charAt(i-1)) {
                // 누른다
                first_cnt++;
                if(i<tmp.length()-1)
                    tmp = reverse(i+1 , tmp);
                tmp = reverse(i , tmp);
                tmp = reverse(i-1 , tmp);
                //System.out.println(tmp);
            }
        }
        if(tmp.equals(state))
            ans = Math.min(ans,first_cnt);


        // 안누른다
        int second_cnt =0;
        String tmp2 = d;

        for(int i=1;i<tmp2.length();i++){
            char before = tmp2.charAt(i-1);
            if(before != state.charAt(i-1)) {
                // 누른다
                second_cnt++;
                if(i<tmp2.length()-1)
                    tmp2 = reverse(i+1 , tmp2);
                tmp2 = reverse(i , tmp2);
                tmp2 = reverse(i-1 , tmp2);
                //System.out.println(tmp2);
            }
        }
        if(tmp2.equals(state))
            ans = Math.min(ans,second_cnt);

        if (ans==10000000)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    private static String reverse(int idx , String s){
        char ans;
        if (s.charAt(idx) =='0') ans='1';
        else ans ='0';
        if (idx==0){
            return ans + s.substring(1);
        }
        else if (idx == s.length()-1){
            return s.substring(0,idx)+ans;
        }else {
            return s.substring(0,idx)+ans+s.substring(idx+1);
        }
    }



}
