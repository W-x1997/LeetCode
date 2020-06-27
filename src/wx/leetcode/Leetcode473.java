package wx.leetcode;

public class Leetcode473 {
    class Solution {
        /**
         473. Matchsticks to Square
         Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

         Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.

         Example 1:
         Input: [1,1,2,2,2]
         Output: true

         Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
         **/


        /**
         dfs 要注意设置两组条件 按照边来dfs
         **/
        public boolean makesquare(int[] nums) {
            if(nums == null || nums.length == 0)
                return false;

            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum += nums[i];
            }

            if (sum % 4 != 0)return false;
            Arrays.sort(nums);

            return dfs(nums, 0, sum/4, 0, 1, new boolean[nums.length]);

        }



        public boolean dfs(int[] nums, int pos, int target, int cursum, int edgeId, boolean[] visited){
            if (edgeId == 4)
                return true;

            if (cursum == target)
                return dfs(nums, 0, target, 0, edgeId+1, visited);

            if (cursum > target)
                return false;

            for (int i = pos; i < nums.length; i++){
                if (visited[i])
                    continue;

                if (i >0 && nums[i] == nums[i-1] && !visited[i-1])
                    continue;

                visited[i] = true;
                if (dfs(nums, pos+1, target, cursum+nums[i], edgeId, visited))
                    return true;

                visited[i] = false;

            }

            return false;

        }
    }
}
