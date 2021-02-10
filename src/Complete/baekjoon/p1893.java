package Complete.baekjoon;



import java.util.*;

public class p1893 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();
        ArrayList<Integer>[] result = new ArrayList[T];
        //Arrays.fill(result, new ArrayList()); --> 이거 모든 배열 값을 똑같이 만들음 ;;;

        for(int i=0;i<T;i++){
            String A = sc.next();
            String W = sc.next();
            String S = sc.next();
            result[i] = new ArrayList<>();
            Map<String,String> alpa = new HashMap<>();

            for(int c=0;c<A.length();c++){
                for(int j =0;j<A.length();j++){
                    String next;
                    if(c+j>=A.length())
                        next = A.charAt(c+j - A.length())+"";
                    else
                        next = A.charAt(c+j)+"";
                    alpa.put(A.charAt(c)+Integer.toString(j) ,next);
                }
            }



            for(int c=0;c<A.length();c++){
                String txt ="";
                for(int j =0;j<W.length();j++){
                    txt+=alpa.get(W.charAt(j)+Integer.toString(c));
                }
                //System.out.println("TXT: "+txt);
                //TXT가 원본 문자열에 몇번 있냐
                if(S.contains(txt)){
                    //System.out.println("contain");
                     String tmp = S.replaceFirst(txt , "0");
                    //System.out.println("한번 삭제한 문자열 : "+tmp);
                    if (!tmp.contains(txt)){
                        //System.out.println("삭제하고 없는 경우-->"+ c );
                        result[i].add(c);
                    }
                }
            }



        }



        for(int i=0;i<result.length;i++){
            if (result[i].isEmpty())
                System.out.println("no solution");
            else if (result[i].size()==1)
                System.out.println("unique: "+result[i].get(0));
            else{
                String msg = "ambiguous: ";
                for (int j =0;j<result[i].size();j++){

                    msg+= result[i].get(j) +" ";
                }
                System.out.println(msg);
            }

        }



    }

}
