package Complete.groom;

import java.util.*;
//구름 초대
public class Invite {
    static int n,k,max=-1;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        String phonenums []= new String[n];
        for(int i=0;i<n;i++){
            phonenums[i]=sc.next();
        }
        for(int i=0;i<(1<<10);i++){
            // 고른 숫자 담기
            List<Integer> numbers = new ArrayList<>();
            int ans = n;
            if(Integer.bitCount(i)==k){ //k개의 사용 가능 번호
                for(int j=0;j<10;j++){
                    if((1<<j&i)>0) numbers.add(j);
                }
                //전화 번호 검사
                for(int j=0;j<phonenums.length;j++){
                    String phone = phonenums[j];
                    for(int m=0;m<phone.length();m++){
                        int num = Integer.parseInt(phone.charAt(m)+"");
                        if(!numbers.contains(num)){
                            ans--;
                            break;
                        }
                    }
                }
                max = Math.max(max,ans);
            }
        }
        System.out.println(max);
    }
}
