package Complete.baekjoon;

import java.util.*;

public class p4949 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> results = new ArrayList();
        while (true){
            String txt = sc.nextLine();
            if(txt.equals("."))
                break;

            Stack<Character> stack = new Stack<>();
            String result = "yes";
            for (int i=0;i<txt.length();i++){
                if(txt.charAt(i)=='('||txt.charAt(i)=='[')
                    stack.push(txt.charAt(i));
                else{

                    if(txt.charAt(i)==')') {
                        if (!stack.isEmpty() && stack.peek() == '(')
                            stack.pop();
                        else {
                            result= "no";
                            break;
                        }
                    }

                    if(txt.charAt(i)==']') {
                        if (!stack.isEmpty() && stack.peek() == '[')
                            stack.pop();
                        else {
                            result= "no";
                            break;
                        }
                    }
                }

            }

            if(!stack.isEmpty()) result= "no";
            results.add(result);

        }

        Iterator it = results.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}
