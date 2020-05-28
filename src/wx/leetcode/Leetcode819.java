package wx.leetcode;
import java.util.*;


public class Leetcode819 {

    class Solution {
        /**
         819. Most Common Word
         **/
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> set=new HashSet();
            for(String s:banned){
                set.add(s);
            }

            paragraph=paragraph+".";//这里要加上！！ 因为否则特殊 比如 "Bob" []


            HashMap<String,Integer> map=new HashMap<String,Integer>();
            StringBuilder sb=new StringBuilder("");
            for(int i=0;i<paragraph.length();i++){
                char ch=paragraph.charAt(i);

                if(Character.isLetter(ch)){
                    sb.append(Character.toLowerCase(ch));
                    continue;
                }

                if(sb.length()>0){
                    String cur=sb.toString();
                    if(map.containsKey(cur))
                        map.put(cur,map.get(cur)+1);
                    else
                        map.put(cur,1);


                }

                sb=new StringBuilder("");


            }


            List<String> list=new ArrayList(map.keySet());
            Collections.sort(list,new Comparator<String>(){
                public int compare(String s1,String s2){
                    return  map.get(s2)-map.get(s1);
                }
            });

            for(int i=0;i<list.size();i++){
                String res=list.get(i);
                if(!set.contains(res)){
                    return res;
                }
            }

            return "";
        }
    }
}
