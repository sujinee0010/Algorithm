package Complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Door {
//4월 3주차 회문
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        StringTokenizer st;

        int number = Integer.parseInt(br.readLine());
        int result []= new int [number];

        for(int i=0;i<number;i++){

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            String subtext = text.substring(start-1,end);

            if(isSame(subtext))
                result[i]=1;
            else
                result[i]=0;


        }


        for(int i=0;i<number;i++){
            System.out.println(result[i]);
        }

    }

    private static boolean isSame(String subtext) {

        int mid = subtext.length()/2;

        for(int i=0,r=subtext.length()-1;i<mid;i++,r--){

            if(subtext.charAt(i)!= subtext.charAt(r))
                return false;


        }

        return true;

    }
}
