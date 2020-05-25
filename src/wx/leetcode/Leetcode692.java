package wx.leetcode;
import java.util.*;
public class Leetcode692 {
    class Solution {
        /**
         692. Top K Frequent Words

         Given a non-empty list of words, return the k most frequent elements.

         Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

         Example 1:
         Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
         Output: ["i", "love"]
         Explanation: "i" and "love" are the two most frequent words.
         Note that "i" comes before "love" due to a lower alphabetical order.
         **/
        public List<String> topKFrequent(String[] words, int k) {

            /**
             经典题 hashmap+排序
             **/

            HashMap<String,Integer> map=new HashMap<>();
            for(String word:words){
                map.put(word,map.getOrDefault(word,0)+1);
            }

            List<String> res=new ArrayList(map.keySet());;
            Collections.sort(res,new Comparator<String>(){
                public int compare(String s1,String s2){
                    if(map.get(s1)==map.get(s2)){
                        return s1.compareTo(s2);
                    }

                    return map.get(s2)-map.get(s1);

                }
            });

            return res.subList(0,k);

        }
    }
}
