package wx.leetcode;
import java.util.*;
public class Leetcode40 {
    class Solution {
        /**
         40. Combination Sum II
         Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
         Each number in candidates may only be used once in the combination.

         All numbers (including target) will be positive integers.
         The solution set must not contain duplicate combinations.
         Example 1:

         Input: candidates = [10,1,2,7,6,1,5], target = 8,
         A solution set is:
         [
         [1, 7],
         [1, 2, 5],
         [2, 6],
         [1, 1, 6]
         ]
         **/

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            /**
             DFS+backtrack 经典题 和I 不同的是，nums里多了重复的元素，且每个只能使用一次
             那么我们就需要多一步sort，
             backtrack中要判断nums[i],nums[i-1]相等与否，i是否大于start（自身不能重复搞）跳过
             其他都是backtrack增删步骤

             1.sort
             2.判断nums[i],nums[i-1]相等与否，i是否大于index（自身不能重复搞）
             3.i+1

             **/
            List<List<Integer>> res=new ArrayList();
            Arrays.sort(candidates);

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
                if(i>index && candidates[i]==candidates[i-1]) continue;//!!!
                cur_sum=cur_sum+candidates[i];
                list.add(candidates[i]);
                dfs(res,list,candidates,target,cur_sum,i+1);//这里的参数是i+1
                list.remove(list.size()-1);
                cur_sum=cur_sum-candidates[i];
            }


        }


    }
}
