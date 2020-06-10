package wx.leetcode;
import  java.util.*;
public class Leetcode78 {
    class Solution {
        /**
         78. Subsets
         Given a set of distinct integers, nums, return all possible subsets (the power set).

         Note: The solution set must not contain duplicate subsets.
         **/
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>>  res=new ArrayList();
            Arrays.sort(nums);

            backtrack(res,new ArrayList<>(),nums,0) ;


            return res;

        }



        public void  backtrack(List<List<Integer>> res,List<Integer> tempList,int []nums,int start){
            res.add(new ArrayList<>(tempList));

            for(int i=start;i<nums.length;i++){
                tempList.add(nums[i]);
                backtrack(res,tempList,nums,i+1);
                tempList.remove(tempList.size()-1);

            }





        }


    }
}
