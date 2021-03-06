package wx.leetcode;

public class Leetcode208 {
    /**
     *
     * 208. Implement Trie (Prefix Tree)
     * Implement a trie with insert, search, and startsWith methods.
     *
     * Example:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // returns true
     * trie.search("app");     // returns false
     * trie.startsWith("app"); // returns true
     * trie.insert("app");
     * trie.search("app");     // returns true
     *
     */

    class Trie {
        TrieNode root;

        class TrieNode{
            char ch;
            boolean isword;
            TrieNode[] children;

            public TrieNode(char ch){
                this.ch=ch;
                children=new TrieNode[26];
                isword=false;
            }
        }

        /** Initialize your data structure here. */
        public Trie() {
            root=new TrieNode(' ');
        }


        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(cur.children[ch-'a']==null){
                    cur.children[ch-'a']=new TrieNode(ch);
                }
                cur=cur.children[ch-'a'];

            }
            cur.isword=true;

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode cur=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(cur.children[ch-'a']==null)
                    return false;
                cur=cur.children[ch-'a'];
            }
            return cur.isword;

        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode cur=root;
            for(int i=0;i<prefix.length();i++){
                char ch=prefix.charAt(i);
                if(cur.children[ch-'a']==null)
                    return false;
                cur=cur.children[ch-'a'];
            }
            return true;

        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
