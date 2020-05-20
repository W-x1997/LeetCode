package wx.leetcode;

public class Leetcode256 {
    class Solution {
        /**
         256. Paint House
         There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

         The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
         **/



        /**
         The algorithm is straightforward. We iterate backwards over all the rows in the grid (starting from the second-to-last) and calculate a total cost for each cell in the way shown in the animation.
         **/
        public int minCost(int[][] costs) {
            // int n=costs.length;
            if(costs==null||costs.length==0)
                return 0;
            for(int i=costs.length-2;i>=0;i--){
                // Total cost of painting the nth house red.
                costs[i][0]=costs[i][0]+Math.min(costs[i+1][1],costs[i+1][2]);

                // Total cost of painting the nth house green.
                costs[i][1]=costs[i][1]+Math.min(costs[i+1][0],costs[i+1][2]);

                // Total cost of painting the nth house blue.
                costs[i][2]=costs[i][2]+Math.min(costs[i+1][0],costs[i+1][1]);
            }

            return Math.min(Math.min(costs[0][0],costs[0][1]),costs[0][2]);

        }

    }
}
