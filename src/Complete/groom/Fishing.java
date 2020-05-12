package Complete.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fishing {
    //구름 : 어부의 고기잡이
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int ans =0;
        int n = Integer.parseInt(st.nextToken());

        int sum = Integer.parseInt(st.nextToken());

        st  = new StringTokenizer(br.readLine());

        int fish[] = new int[n];
        for(int i=0;i<n;i++){
            fish[i]= Integer.parseInt(st.nextToken());
        }

        //연속 되어야 한다

        for(int i=0;i<fish.length;i++){
            int sums =0;
            for(int j=i;j<fish.length;j++){
                sums+=fish[j];
                if(sums==sum) {
                    ans++;
                    break;
                }
                else if (sums>sum){
                    break;
                }

            }
        }


        System.out.println(ans);
    }
}
