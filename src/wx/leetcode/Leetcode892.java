package wx.leetcode;

public class Leetcode892 {
    /**
     *
     *892. Surface Area of 3D Shapes
     * On a N * N grid, we place some 1 * 1 * 1 cubes.
     *
     * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
     *
     * Return the total surface area of the resulting shapes.
     *
     *
     *
     * Example 1:
     *
     * Input: [[2]]
     * Output: 10
     *
     * 分步累加
     * 思路
     *
     * 我们单独计算每一个 v = grid[i][j] 所贡献的表面积，再将所有的 v 值相加就能得到最终形体的表面积：
     *
     * 对于顶面和底面的表面积，如果 v > 0，那么顶面和底面各贡献了 1 的表面积，总计 2 的表面积；
     *
     * 对于四个侧面的表面积，只有在相邻位置的高度小于 v 时，对应的那个侧面才会贡献表面积，且贡献的数量为 v - nv，其中 nv 是相邻位置的高度。我们可以将其写成 max(v - nv, 0)。
     *
     * 举一个例子，对于网格
     *
     * 1 5
     * 6 7
     * 而言，位置 grid[0][1] 的高度为 5：
     *
     * 因为 5 > 0，所以贡献了 2 的顶面和底面表面积；
     *
     * 该位置的上方和右侧没有单元格，可以看成高度为 0，所以分别贡献了 max(5 - 0, 0) = 5 的表面积；
     *
     * 该位置的左侧高度为 1，所以贡献了 max(5 - 1, 0) = 4 的表面积；
     *
     * 该位置的下方高度为 7，所以贡献了 max(5 - 7, 0) = 0 的表面积。
     *
     * 因此 grid[0][1] 贡献的表面积总和为 2 + 5 + 5 + 4 + 0 = 16。
     *
     * 算法
     *
     * 对于每个 v = grid[r][c] > 0，计算 ans += 2，对于 grid[r][c] 四个方向的每个相邻值 nv 还要加上 max(v - nv, 0)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes/solution/san-wei-xing-ti-de-biao-mian-ji-by-leetcode-soluti/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */

    class Solution {
        public int surfaceArea(int[][] grid) {
            if(grid==null)return 0;
            int res=0;
            int row=grid.length;
            int col=grid[0].length;


            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(grid[i][j]==0)
                        continue;
                    res=res+2;
                    res=res+calculateNear(grid,i,j);

                }
            }

            return res;
        }


        public int calculateNear(int[][] grid,int i,int j){
            int sum=0;
            if(i-1>=0){
                sum=sum+Math.max(0,grid[i][j]-grid[i-1][j]);
            }else
                sum=sum+grid[i][j];

            if(j-1>=0){
                sum=sum+Math.max(0,grid[i][j]-grid[i][j-1]);
            }else
                sum=sum+grid[i][j];

            if(j+1<grid[0].length){
                sum=sum+Math.max(0,grid[i][j]-grid[i][j+1]);
            }else
                sum=sum+grid[i][j];

            if(i+1<grid.length){
                sum=sum+Math.max(0,grid[i][j]-grid[i+1][j]);
            }else
                sum=sum+grid[i][j];

            return sum;

        }
    }
}
