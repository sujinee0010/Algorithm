package Complete.baekjoon;

import java.util.Scanner;

public class p5397 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans[] = new String[n];

        for(int i=0;i<n;i++){

            String origin = sc.next();
            StringBuilder pwd = new StringBuilder();
            int cusor = 0;

            for(int j=0;j<origin.length();j++){
                char txt = origin.charAt(j);

                if(txt=='<'){
                    if(cusor>0) {
                        cusor -= 1;
                    }
                }else if(txt=='>'){
                    if(cusor<pwd.length())
                        cusor+=1;
                }else if(txt=='-'){
                    if(!pwd.toString().equals("")){
                        pwd = new StringBuilder(pwd.substring(0, pwd.length() - 1));
                        cusor-=1;
                    }
                }else{
                    pwd = new StringBuilder(pwd.substring(0, cusor) + txt + pwd.substring(cusor));
                    cusor+=1;
                }
            }
            ans[i] = pwd.toString();
            //System.out.println(pwd);

        }

        for(int i=0;i<n;i++){
            System.out.println(ans[i]);
        }
    }
}
