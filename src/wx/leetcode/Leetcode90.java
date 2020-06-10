package wx.leetcode;
import java.util.*;

public class Leetcode90 {
    /*和SubSet I 差不多
就是排个序去重就好
别忘了每次res都直接加templist进入res
*/
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res=new ArrayList<>();
            List<Integer> templist=new ArrayList<>();
            helper(res,templist,nums,0);
            return res;
        }

        private void helper(List<List<Integer>> res,List<Integer> templist,int[]nums,int start){
            res.add(new ArrayList(templist));
            for(int i=start;i<nums.length;i++){
                if(i>start && nums[i]==nums[i-1] )continue;
                templist.add(nums[i]);
                helper(res,templist,nums,i+1);
                templist.remove(templist.size()-1);
            }
        }
    }
}
