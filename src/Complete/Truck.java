package Complete;

import java.util.ArrayList;
import java.util.List;

//프머스 스택 트럭
public class Truck {
    static List list = new ArrayList();
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        list.add(0,0);

        for(int i=0;i<truck_weights.length;i++){
             addTruck(i+1,truck_weights[i] ,bridge_length,weight);
        }
        answer=list.size();

        return answer;
    }

    private static void addTruck(int start ,int truck_weight,int bridge_length,int weight) {
        while(bridge_length>0){

            if(start>=list.size()){
                list.add(start,truck_weight);
                start++;
                bridge_length--;
            }
            else{
                if((int)list.get(start)+truck_weight <= weight){
                    list.add(start,(int)list.get(start) + truck_weight);
                    start++;
                    bridge_length--;
                }
                else
                    start++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //int s[]={2,1,3,2};
        int s[]={10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(100,100,s));
    }
}
