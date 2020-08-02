package Complete.goorm;

import java.util.Scanner;
import java.util.TreeSet;

// 구름 비타알고 비진수
public class CountNum {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int ans = limit;
        final String nums ="0123456789";// 10

        for(int i=1;i<=limit;i++){
            String num = Integer.toString(i);
//0123456789  11 2
            String tmp = "0123456789";
            tmp=tmp.replaceAll("[" + num + "]", "");
            if (nums.length()-tmp.length()>2){
                ans--;
            }

        }

    System.out.println(ans);
    }
}
