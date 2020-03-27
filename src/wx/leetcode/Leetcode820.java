package wx.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Leetcode820 {
    /**
     *
     * 820. Short Encoding of Words
     * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
     *
     * For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].
     *
     * Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.
     *
     * What is the length of the shortest reference string S possible that encodes the given words?
     *
     *
     * 存储后缀
     * 思路
     *
     * 如果单词 X 是 Y 的后缀，那么单词 X 就不需要考虑了，因为编码 Y 的时候就同时将 X 编码了。例如，如果 words 中同时有 "me" 和 "time"，我们就可以在不改变答案的情况下不考虑 "me"。
     *
     * 如果单词 Y 不在任何别的单词 X 的后缀中出现，那么 Y 一定是编码字符串的一部分。
     *
     * 因此，目标就是保留所有不是其他单词后缀的单词，最后的结果就是这些单词长度加一的总和，因为每个单词编码后后面还需要跟一个 # 符号。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/short-encoding-of-words/solution/dan-ci-de-ya-suo-bian-ma-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */



    class Solution {
        public int minimumLengthEncoding(String[] words) {
            int res=0;
            HashSet<String> set=new HashSet<String>(Arrays.asList(words));
            for(int i=0;i<words.length;i++){
                String cur=words[i];
                for(int j=1;j<cur.length();j++){
                    String tmp=cur.substring(j);
                    if(set.contains(tmp))
                        set.remove(tmp);
                }

            }
            for(String word:set){
                res=res+word.length()+1;

            }
            return res;


        }
    }
}
