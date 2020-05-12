package Complete.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TOFU {

    //두부 자르기
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans=0;
        int n = Integer.parseInt(br.readLine());

        boolean used[] = new boolean[n+1];
        Arrays.fill(used,false);


        for(int i=1;i<=n;i++){
            int val = n/i ;

            if(used[val]==false){
                ans++;
                used[val]=true;
            }

        }




        System.out.println(ans);
    }



}
