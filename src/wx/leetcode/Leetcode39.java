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
