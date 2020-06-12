package wx.leetcode;
import java.util.*;
public class Leetcode380 {
    class RandomizedSet {

        /**
         380. Insert Delete GetRandom O(1)

         Design a data structure that supports all following operations in average O(1) time.

         insert(val): Inserts an item val to the set if not already present.
         remove(val): Removes an item val from the set if present.
         getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
         **/

        /**
         * 用Hashmao+list实现
         * hashmap存放 value+ index     index为list中value的位置
         * 每次删除的时候 把末尾最后一个元素放到当前要删除的位置
         */

        HashMap<Integer,Integer> map;
        List<Integer> list;
        Random random=new Random();
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map=new HashMap<>();
            list=new ArrayList();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val))
                return false;
            else{
                map.put(val,list.size());
                list.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val))
                return false;
            else{
                int lastelement=list.get(list.size()-1);
                int index=map.get(val);

                list.set(index,lastelement);
                map.put(lastelement,index); //!!map中 也要更新

                list.remove(list.size()-1);

                map.remove(val);
                return true;
            }

        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
