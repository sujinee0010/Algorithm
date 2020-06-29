package Complete.programmers;
/*a.startWith(b) a가 b로 시작하는 string 값인지 여부
프로그래머스 전화번호 목록
*/
public class PnumList {
    boolean solution(String[] phoneBook) {
            for(int i=0; i<phoneBook.length-1; i++) {
                for(int j=i+1; j<phoneBook.length; j++) {
                    if(phoneBook[i].startsWith(phoneBook[j])) return false;
                    if(phoneBook[j].startsWith(phoneBook[i])) return false;
                }
            }
            return true;
    }
}
