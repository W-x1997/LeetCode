package wx.leetcode;
import java.util.*;
public class Leetcode39 {
    class Solution {
        /**
         39. Combination Sum

         Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

         The same repeated number may be chosen from candidates unlimited number of times.
         **/


        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res=new ArrayList();

            /**
             * 这里注意最后一个参数 dfs中从i开始
             *
             * 给定candidates中无重复的，所以不用sort也不用判断临近的两个数是否相等(nums[i]==nums[i-1] continue)
             * 但是当前index的数字可以选用无数次，所以call 下一次的时候要 传入i，而不是i+1.
             * 只有在remain==0的时候才添加到res，start可以小于等于nums.length
             */
            dfs(res,new ArrayList(),candidates,target,0,0);


            return res;
        }




        public void dfs(List<List<Integer>> res, List<Integer> list,int[] candidates,int target, int cur_sum,int index){
            if(cur_sum>target)return;
            if(cur_sum==target){
                res.add(new ArrayList(list));
                return;
            }

            for(int i=index;i<candidates.length;i++){
                cur_sum=cur_sum+candidates[i];
                list.add(candidates[i]);
                dfs(res,list,candidates,target,cur_sum,i);//这里的参数是i
                list.remove(list.size()-1);
                cur_sum=cur_sum-candidates[i];
            }


        }


    }
}
