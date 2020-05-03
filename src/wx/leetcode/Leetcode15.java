package wx.leetcode;

import java.util.*;

public class Leetcode15 {
    class Solution {


        /**
         *
         * 15. 3Sum
         * Medium
         *
         * 6208
         *
         * 749
         *
         * Add to List
         *
         * Share
         * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
         * Find all unique triplets in the array which gives the sum of zero.
         *
         *


         第一种方法很容易想到  就是取第一个数字作为基准 然后将问题转换为2Sum 即可
         时间复杂度为O(n^2)   额外空间复杂度是O(n)。

         但是 这并不是最优秀解法 这样做会带来两个问题  1个是需要hashmap额外空间
         第二个是需要解决一个去重的问题


         因此有第二个方法
         同样是先固定一个元素a，找b+c=-a，而最优美的地方就在于如何找着另外两个数b和c，这里不用HashMap，
         而是先将整个数组进行排序（排序时间复杂度O(nlogn)），然后可以利用前后双指针解法去找这两个元素。
         这样做的好处有两个：一是不需要额外的空间，二是由于已经有序，去重简单。
         **/
     public List<List<Integer>> threeSum1(int[] nums) {

     if (nums == null || nums.length <= 2) {
         return Collections.emptyList();
     }


         Set<List<Integer>> res = new LinkedHashSet<>();
         for(int i=0;i<nums.length-2;i++){
             int target=0-nums[i];
             HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
             for(int j=i+1;j<nums.length;j++){
                 if(map.containsKey(target-nums[j])){
                     map.put(target-nums[j],1);
                     List<Integer> list=new ArrayList();
                     list.add(nums[i]);
                     list.add(nums[j]);
                     list.add(target-nums[j]);
                     Collections.sort(list);
                     res.add(list);
                 }else{
                      map.put(nums[j],1);

                 }
             }

         }



         return new ArrayList(res);
     }

        //
        //方法二 夹逼法

        /**
         * 最优
         *
         * 同样是先固定一个元素a，找b+c=-a，而最优美的地方就在于如何找着另外两个数b和c，这里不用HashMap，
         *          而是先将整个数组进行排序（排序时间复杂度O(nlogn)），然后可以利用前后双指针解法去找这两个元素。
         *          这样做的好处有两个：一是不需要额外的空间，二是由于已经有序，去重简单。
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {

            if (nums == null || nums.length <= 2) {
                return Collections.emptyList();
            }
            List<List<Integer>> res=new ArrayList();
            Arrays.sort(nums);
            for(int i=0;i<nums.length-2;i++){

                if(i>0 && nums[i]==nums[i-1])
                    continue;     //重复元素直接跳过

                int target=0-nums[i];
                int left=i+1;
                int right=nums.length-1;

                while(left<right){
                    if(nums[left]+nums[right]==target){
                        List<Integer> list=new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        //去重
                        while(left<right&&nums[left]==nums[left+1])left++;
                        while(left<right&&nums[right]==nums[right-1])right--;

                        left++;
                        right--;

                    }else if(nums[left]+nums[right]>target){
                        right--;
                    }else {
                        left++;
                    }

                }

            }
            return res;


        }
    }
}
