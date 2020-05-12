package Complete.groom;

import java.util.Scanner;

public class Bus {
    //구름 소희와 버스
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);


        int n= sc.nextInt();
        int time= sc.nextInt();

        int bus [][]= new int [n][2];
        int result[]= new int [n];

        for(int i=0;i<bus.length;i++){
            bus[i][0]=sc.nextInt();
            bus[i][1]=sc.nextInt();
        }


        int min=0;

        for(int i=0;i<bus.length;i++){


            if(bus[i][0]>=time)
                result[i]=bus[i][0];

            else {
                while(bus[i][0]<time) {
                    bus[i][0] += bus[i][1];
                }
                result[i]=bus[i][0];
            }


            if(i==0)
                min=result[i];
            else{
                min=Math.min(min,result[i]);
            }


        }

        int busnum = n+1 ;

        for(int i=0;i<result.length;i++){

            if(result[i]==min)
                busnum=Math.min(busnum,i+1);
        }

        System.out.println(busnum);

    }

}

