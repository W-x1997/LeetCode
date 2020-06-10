package wx.leetcode;
import java.util.*;
public class Leetcode47 {
    /*DFS+backtrack 经典题
这题nums里头有了重复的元素，就需要我们排序再标记used[i]==used[i-1]说明遇到了重复的，可以886
其他的变化不大，也别忘了i是从0开始，谁都可以当头
*/
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);   //原始数组有重复的，所以需要排序和标记i和i-1是否为重复的
            List<List<Integer>> res=new ArrayList<>();
            List<Integer> templist=new ArrayList<>();
            boolean[] used =new boolean[nums.length];
            helper(nums,res,templist,used);
            return res;
        }

        private void helper(int[] nums, List<List<Integer>> res,List<Integer> templist, boolean[] used){
            if(templist.size()==nums.length) {
                res.add(new ArrayList<Integer>(templist));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if( used[i] || ( i > 0 && nums[i] == nums[i - 1] &&!used[i-1]) )//用过的和重复的都continue   used[i-1]==false说明used用过了
                    continue;
                used[i]=true;
                templist.add(nums[i]);
                helper(nums,res,templist,used);
                used[i]=false;
                templist.remove(templist.size()-1);
            }
        }
    }
}
