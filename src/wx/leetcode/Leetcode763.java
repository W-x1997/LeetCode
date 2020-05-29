package wx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode763 {class Solution {
    /**
     763. Partition Labels


     A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

     Example 1:
     Input: S = "ababcbacadefegdehijhklij"
     Output: [9,7,8]
     Explanation:
     The partition is "ababcbaca", "defegde", "hijhklij".
     This is a partition so that each letter appears in at most one part.
     A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.



     **/
    public List<Integer> partitionLabels(String S) {

        /**
         * We need an array last[char] -> index of S where char occurs last.
         * Then, let anchor and j be the start and end of the current partition.
         * If we are at a label that occurs last at some index after j, we'll extend the partition j = last[c].
         * If we are at the end of the partition (i == j) then we'll append a partition size to our answer,
         * and set the start of our new partition to i+1.
         *
         */
        List<Integer> res=new ArrayList();
        if(S==null||S.length()==0)return res;

        int[] last_index=new int[26]; //  the last occurrence of that letter
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            last_index[ch-'a']=i;
        }


        int  target=0; // the end position we need to reach
        int   start=0;// the start position


        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);

            target=Math.max(target,last_index[ch-'a']);

            if(target==i){ // 即当前位置 从start到当前位置i 符合条件
                res.add(i-start+1);
                start=i+1;
            }


        }
        return res;



    }
}
}
