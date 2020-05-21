package wx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Leetcode49 {

    class Solution {
        /**

         49. Group Anagrams

         Given an array of strings, group anagrams together.
         **/

        public List<List<String>> groupAnagrams(String[] strs) {
            /**
             we need to use a hashtable to store the relationship
             the key is the sorted string and the value is the list

             finall, we could get the map.values()

             **/
            List<List<String>> res=new ArrayList<>();
            if(strs==null||strs.length==0)
                return res;

            HashMap<String,List<String>> map=new HashMap<>();


            for(int i=0;i<strs.length;i++){
                String str=strs[i];  // first turn the string to array then sort to get the key
                char[] array=str.toCharArray();
                Arrays.sort(array);
                String key=String.valueOf(array);

                if(map.containsKey(key)){
                    map.get(key).add(str);

                }else{
                    List<String> list=new ArrayList();
                    list.add(str);
                    map.put(key,list);

                }


            }
            res.addAll(map.values());

            return res;
        }
    }
}
