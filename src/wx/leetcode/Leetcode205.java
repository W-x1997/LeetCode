package wx.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Leetcode205 {

    /**
     *
     * 205. Isomorphic Strings
     *
     * Given two strings s and t, determine if they are isomorphic.
     *
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     *
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character but a character may map to itself.
     *
     * Solution2// use array to minic HashMap, same idea but faster
     * class Solution {
     *     public boolean isIsomorphic(String sString, String tString) {
     *         char [] s = sString.toCharArray();
     *         char [] t = tString.toCharArray();
     *         int [] smap = new int [256];
     *         int [] tmap = new int [256];
     *         for (int i = 0; i < s.length; i++) {
     *             if (smap[s[i]] == 0 && tmap[t[i]] == 0) {
     *                 smap[s[i]] = t[i];
     *                 tmap[t[i]] = s[i];
     *             } else if (smap[s[i]] != t[i]) return false;
     *         }
     *         return true;
     *     }
     * }
     *
     *
     * 　【只要s和t满足一一映射就可以了】
     * 　　使用一个哈希表map维护两个字符串中字符的映射关系，同时用一个set保存映射的值。
     * (s[i], t[i])，如是s[i]键没有在map中出现过并且t[i]没有在set中出现过，就加入到映射关系中，t[i]值已经出现过，说明是多对一映射，
     * 不符合返回false。s[i]键如果已经出现过，设为s[k]，对应的映射值为t[k]),即s[i]==s[k],则找出s[k]的对对应值t[k]，如果t[i]!=t[k],
     * 说明一个同一个字符存在两个不同的映射，两个字符串不是同构的，返回false，继续处理下一个字符，直到结束。
     */


    class Solution {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character,Character> map=new HashMap<Character,Character>();

            HashSet<Character> set=new HashSet<Character>();
            for(int i=0;i<s.length();i++){
                char ss=s.charAt(i);
                char tt=t.charAt(i);

                if(map.containsKey(ss)){
                    if(map.get(ss)!=tt)
                        return false;
                }else {
                    if(set.contains(tt)){
                        return false;
                    }else {
                        map.put(ss,tt);
                        set.add(tt);
                    }


                }


            }


            return true;

        }
    }
}
