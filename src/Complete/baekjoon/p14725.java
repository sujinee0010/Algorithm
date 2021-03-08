package Complete.baekjoon;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Trie {

    // 루트 노드
    private TrieNode rootNode;
    Trie() {
        rootNode = new TrieNode();
    }
    TrieNode getRoot(){
        return rootNode;
    }

    // 자식 노드 추가
    void insert(String words) {
        String word[] = words.split(" ");

        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < word.length; i++) { //a , new
            thisNode = thisNode.getChildNodes().computeIfAbsent(word[i], c -> new TrieNode());
        }
        //thisNode.setIsLastWord(true);
    }
    

}


class TrieNode {

    // 자식 노드 맵
    private Map<String, TrieNode> childNodes = new HashMap<>();

    // 자식 노드 맵 Getter
    Map<String, TrieNode> getChildNodes() {
        return this.childNodes;
    }
}

public class p14725 {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();

        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int g = sc.nextInt();
            StringBuilder words = new StringBuilder();
            for(int j=0;j<g;j++) {
                String keyword = sc.next();
                words.append(keyword+" ");
            }
            trie.insert(String.valueOf(words));


        }


        dfs(trie.getRoot() ,"");


    }

    private static void dfs(TrieNode root , String depth) {
        List<String> heads = new ArrayList<>(root.getChildNodes().keySet()); // a b
        heads.sort(Comparator.naturalOrder());

        for (int i=0;i<heads.size();i++){
            System.out.println(depth+heads.get(i));
            dfs(root.getChildNodes().get(heads.get(i)),depth+"--");
        }

    }


}
