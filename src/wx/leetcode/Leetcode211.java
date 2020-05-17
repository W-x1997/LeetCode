package wx.leetcode;

public class Leetcode211 {
    /**
     *
     * 211. Add and Search Word - Data structure design
     * Medium
     *
     * 1563
     *
     * 80
     *
     * Add to List
     *
     * Share
     * Design a data structure that supports the following two operations:
     *
     * void addWord(word)
     * bool search(word)
     * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
     */

    class WordDictionary {

        /**
         * TrieNode，注意只要TrieNode，同时实现insert
         * 然后是search：和原本的search有所不同，这次要全面检索包括.匹配的
         * 所以需要用到DFS来全面检索26个字母
         *
         * Time Complexity:
         * addWord() - O(n), n = length of the new word
         */

        class TrieNode{
            char ch;
            boolean isword;
            TrieNode[] children;

            public TrieNode(char ch){
                this.ch=ch;
                children=new TrieNode[26];
            }
        }

        TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root=new TrieNode(' ');


        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
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



        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return helper(word,0,root);

        }


        public boolean helper(String word,int index,TrieNode node){
            if(node==null)return false;
            if(index==word.length())return node.isword;

            char ch=word.charAt(index);
            if(ch=='.'){
                for(int i=0;i<26;i++){
                    if(helper(word,index+1,node.children[i])){
                        return true;
                    }
                }
            }else{
                //if(ch!=node.ch)return false;
                if(helper(word,index+1,node.children[ch-'a']))
                    return true;
            }

            return false;
        }

    }





/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
