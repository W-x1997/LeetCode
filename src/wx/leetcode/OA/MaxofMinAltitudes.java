package wx.leetcode.OA;

public class MaxofMinAltitudes {
    /**
     * 67
     * Sithis's avatar
     * Sithis
     * Moderator
     * 11558
     * Last Edit: November 8, 2019 9:27 AM
     *
     * 41.9K VIEWS
     *
     * Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at [r-1, c-1]. The score of a path is the minimum value in that path. For example, the score of the path 8 → 4 → 5 → 9 is 4.
     *
     * Don't include the first or final entry. You can only move either down or right at any point in time.
     *
     * Example 1:
     *
     * Input:
     * [[5, 1],
     *  [4, 5]]
     *
     * Output: 4
     * Explanation:
     * Possible paths:
     * 5 → 1 → 5 => min value is 1
     * 5 → 4 → 5 => min value is 4
     * Return the max value among minimum values => max(4, 1) = 4.
     * Example 2:
     *
     * Input:
     * [[1, 2, 3]
     *  [4, 5, 1]]
     *
     * Output: 4
     * Explanation:
     * Possible paths:
     * 1-> 2 -> 3 -> 1
     * 1-> 2 -> 5 -> 1
     * 1-> 4 -> 5 -> 1
     * So min of all the paths = [2, 2, 4]. Note that we don't include the first and final entry.
     * Return the max of that, so 4.
     */


    public static int getMaxScore(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = Integer.MAX_VALUE;
        dp[grid.length - 1][grid[0].length - 1] = Integer.MAX_VALUE;
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);
        }

        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], grid[0][i]);
        }

        for (int i = 1; i <grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
             dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
             dp[i][j] = Math.min(dp[i][j], grid[i][j]);

            }
        }
        return dp[grid.length - 1][grid[0].length - 1];

    }


    public static void test(int[][] grid, int expected) {
        System.out.println(getMaxScore((grid)) == expected);
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][] { { 5, 1 }, { 4, 5 } };
        int[][] grid2 = new int[][] { { 5, 7 }, { 3, 4 }, { 9, 8 } };
        int[][] grid3 = new int[][] { { 5, 7, 6, 8 }, { 3, 4, 2, 1 }, { 9, 8, 4, 6 } };

        test(grid1, 4);
        test(grid2, 4);
        test(grid3, 4);
    }
}

//
//    private int maxScore;
//    public int minSumPath(int[][] grid){
//        if (grid == null || grid.length == 0) return 0;
//        maxScore = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        dfs(grid, 0, 0,  min);
//        return maxScore;
//    }
//    private void dfs(int[][] grid, int i, int j, int min){
//        if (i<0 || i>=grid.length || j<0 ||j>=grid[0].length)
//            return;
//        if(i==0 && j==0 || i==grid.length-1 &&j==grid[0].length-1){}
//        else
//            min = Math.min(min, grid[i][j]);
//        if (i== grid.length-1 && j==grid[0].length-1)
//            maxScore = Math.max(maxScore, min);
//        dfs(grid, i+1,j,min);
//        dfs(grid,i,j+1,min);
//    }
//}
