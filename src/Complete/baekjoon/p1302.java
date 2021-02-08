package Complete.baekjoon;

import java.util.*;
import java.util.Map.Entry;
public class p1302 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> books = new HashMap<>();
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            String title = sc.next();
            if(books.isEmpty() || !books.containsKey(title))
                books.put(title,1);
            else
                books.put(title,books.get(title)+1);
        }

        List<String> keylist = new ArrayList(books.keySet());
        Collections.sort(keylist, (o1, o2) -> {
            if (books.get(o1)==books.get(o2))
                return o1.compareTo(o2);
            return books.get(o2) - books.get(o1);
        });


        System.out.println(keylist.get(0));

    }
}
