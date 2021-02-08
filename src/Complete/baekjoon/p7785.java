package Complete.baekjoon;

import java.util.*;

public class p7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> enter = new HashSet();
//        HashSet<String> leave = new HashSet();
//        HashSet<String> tmp;

        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String name = sc.next();
            String state = sc.next();
            if(state.equals("enter"))
                enter.add(name);
            else if (state.equals("leave"))
                enter.remove(name);
//                leave.add(name);
//
//                //교집합
//                tmp = new HashSet(enter);
//                tmp.retainAll(leave);
//
//                enter.removeAll(tmp);
//                leave.removeAll(tmp);

                //leave.removeAll(enter);
            //System.out.println(enter);

        }


        List<String> people = new ArrayList(enter);
        Collections.sort(people,Collections.reverseOrder());
        for(String name : people) System.out.println(name);


        //Multiset<String> multiset = HashMultiset.create();
		/*
		ss.addAll(ss2);	// (1 2 3 4) ∪ (3 4 5 6) = (1 2 3 4 5 6) 합집합
		for(int n : ss) System.out.print(n + " ");
		System.out.println();
		*/

		/*
		ss.retainAll(ss2);	// (1 2 3 4) ∩ (3 4 5 6) = (3 4) 교집합
		for(int n : ss) System.out.print(n + " ");
		System.out.println();
		*/

		/*
		ss.removeAll(ss2);	// (1 2 3 4) - (3 4 5 6) = (1 2) 차집합
		for(int n : ss) System.out.print(n + " ");
		System.out.println();
		*/

		/*
		System.out.println(ss.containsAll(ss2));	// (1 2 3 4) ≠ (3 4 5 6)
		System.out.println(ss.containsAll(ss3));	// (1 2 3 4) ⊃ (1 2)
		*/
    }

}
