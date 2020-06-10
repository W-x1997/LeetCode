package wx.leetcode;
import java.util.*;

public class Leetcode46 {
    class Solution {
        /**
         46. Permutations
         Given a collection of distinct integers, return all possible permutations.
         **/
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res=new ArrayList();

            boolean[] visited=new boolean[nums.length];
            dfs(res,new ArrayList(),nums,visited);

            return res;
        }


        public void dfs( List<List<Integer>> res,List<Integer> list,int[] nums,boolean[] visited){
            if(list.size()==nums.length){
                res.add(new ArrayList(list));
                return;
            }



            for(int i=0;i<nums.length;i++){
                if(visited[i]==false){
                    visited[i]=true;
                    list.add(nums[i]);
                    dfs(res,list,nums,visited);
                    list.remove(list.size()-1);
                    visited[i]=false;
                }




            }


        }
    }

    /**
     * 也可以加入index
     *
     *
     */

    class Solution2 {
        /**
         46. Permutations
         Given a collection of distinct integers, return all possible permutations.
         **/
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res=new ArrayList();

            boolean[] visited=new boolean[nums.length];
            dfs(res,new ArrayList(),nums,visited,0);

            return res;
        }


        public void dfs( List<List<Integer>> res,List<Integer> list,int[] nums,boolean[] visited,int index){
            if(list.size()==nums.length){
                res.add(new ArrayList(list));
                return;
            }



            for(int i=0;i<nums.length;i++){
                if(visited[i]==false){
                    visited[i]=true;
                    list.add(nums[i]);
                    dfs(res,list,nums,visited,i+1);
                    list.remove(list.size()-1);
                    visited[i]=false;
                }




            }


        }
    }
}
