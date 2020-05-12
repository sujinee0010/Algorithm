package Complete.groom;

import java.io.*;
import java.util.*;

public class MakeGroup {
    //구름 : 그룹 지정
    static boolean used[] = new boolean[100000+1];
    static ArrayList<Integer> groups [];//= new ArrayList[100000+1];

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int relation = Integer.parseInt(st.nextToken());


        Arrays.fill(used,false);

        groups = new ArrayList[num+1];

        for(int i =0;i<groups.length;i++){
            groups[i]= new ArrayList<>();
        }


        for(int i=0;i<relation;i++){

            st = new StringTokenizer(br.readLine());
            int num1  = Integer.parseInt(st.nextToken());
            int num2  = Integer.parseInt(st.nextToken());

            groups[num1].add(num2);
            groups[num2].add(num1);

        }


        int ans =0;

        for(int i=1;i<groups.length;i++){

            if(!groups[i].isEmpty()){
                if(used[i]==false) //비어 있지 않음 근데 검사도 안하거면
                    ans+=bfs(i);
            }
            else
                ans++;

        }

        System.out.println(ans);

    }

    private static int bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){

            int node = q.poll(); // 제거하면서 숫자 반환

            for(int i=0; i<groups[node].size(); i++){
                int next = groups[node].get(i);

                if(used[next] == false){
                    q.add(next);
                    used[next]=true;
                }
            }
        }

        return 1;
    }


}

