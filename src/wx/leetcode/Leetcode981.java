package wx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode981 {
    /**

     981. Time Based Key-Value Store

     Create a timebased key-value store class TimeMap, that supports two operations.

     1. set(string key, string value, int timestamp)

     Stores the key and value, along with the given timestamp.
     2. get(string key, int timestamp)

     Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
     If there are multiple such values, it returns the one with the largest timestamp_prev.
     If there are no values, it returns the empty string ("").
     **/

    class TimeMap {

        //用一个嵌套的Map来实现即可  第一个map: String-->Map2
        //                    !!!第二个map：Integer--->String  这里的Integer是timestamp

        Map<String,Map<Integer,String>> maps;

        /** Initialize your data structure here. */
        public TimeMap() {
            maps=new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(maps.containsKey(key)){
                maps.get(key).put(timestamp,value);

            }else {
                HashMap<Integer,String>map=new HashMap<>();
                map.put(timestamp,value);
                maps.put(key,map);

            }

        }



        public String get(String key, int timestamp) {

            if (!maps.containsKey(key)) {
                return "";
            }

            Map<Integer,String> map=maps.get(key);
            if(map.containsKey(timestamp)){
                return map.get(timestamp);

            }else{

                int tmp=timestamp;

                //这里可以用二分法来优化查找
                for(int i=timestamp;i>=0;i--){
                    if(maps.get(key).containsKey(i))
                        return maps.get(key).get(i);
                }

                return "";

            }


        }


    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
