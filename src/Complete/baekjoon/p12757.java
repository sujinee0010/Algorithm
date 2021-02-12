package Complete.baekjoon;

import java.util.*;

public class p12757 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Map<Integer , Integer> numbers = new HashMap<>();
        ArrayList<String> printmsg = new ArrayList<>();
        int n = sc.nextInt();
        int order = sc.nextInt();
        int range = sc.nextInt();

        for(int i=0;i<n;i++)
            numbers.put(sc.nextInt(), sc.nextInt());


        for(int i=0;i<order;i++){
            int onum = sc.nextInt();
            if(onum==1){
                numbers.put(sc.nextInt(), sc.nextInt());
            }else if(onum==2){

                int key = sc.nextInt();
                int value = sc.nextInt();
                for(int j=0;j<=range;j++){
                    int fake_key1 = key+j;
                    int fake_key2 = key-j;

                    if( fake_key1 <= 1000000000 && numbers.containsKey(fake_key1)) {
                        numbers.put(fake_key1, value);
                        break;
                    }
                    if (fake_key2>=0 && numbers.containsKey(fake_key2)){
                        numbers.put(fake_key2, value);
                        break;
                    }
                }

            }else{
                int key = sc.nextInt();
                int result = -1;
                int cnt =0;

                for(int j=0;j<=range;j++){
                    int fake_key1 = key+j;
                    int fake_key2 = key-j;

                    if( fake_key1 <= 1000000000 && numbers.containsKey(fake_key1)) {
                        result = numbers.get(fake_key1);
                        cnt++;
                    }
                    if (fake_key2>=0 && numbers.containsKey(fake_key2)){
                        result = numbers.get(fake_key2);
                        cnt++;
                    }

                    if (result!=-1){
                        break;
                    }

                }

                if(result==-1 || cnt==1 )
                    printmsg.add(result+"");
                else if (cnt==2)
                    printmsg.add("?");


            }
        }

        Iterator<String> it = printmsg.iterator();
        while(it.hasNext())
            System.out.println(it.next());



    }
}
