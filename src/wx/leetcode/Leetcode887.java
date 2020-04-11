package wx.leetcode;

import java.util.Arrays;

public class Leetcode887 {
    /**
     * 887. Super Egg Drop
     * You are given K eggs, and you have access to a building with N floors from 1 to N. 
     * <p>
     * Each egg is identical in function, and if an egg breaks, you cannot drop it again.
     * <p>
     * You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.
     * <p>
     * Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N). 
     * <p>
     * Your goal is to know with certainty what the value of F is.
     * <p>
     * What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?
     * <p>
     *  
     * <p>
     * Example 1:
     * <p>
     * Input: K = 1, N = 2
     * Output: 2
     * Explanation:
     * Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
     * Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
     * If it didn't break, then we know with certainty F = 2.
     * Hence, we needed 2 moves in the worst case to know what F is with certainty.
     *
     *
     *
     * 可以用二分 优化！！！
     */


    class Solution {
        public int superEggDrop1(int K, int N) {

            /**
             *
             * 复杂度分析：
             *
             * 时间复杂度：O(NK^2)O(NK
             * 2
             *  )，三层 for 循环，每层循环都是线性的；
             * 空间复杂度：O(NK)O(NK)，表格的大小。
             * 这里需要盯着「状态转移方程」使劲看：
             *
             * dp[i][j] = \min_{1 \le k \le i} \left(\max(dp[k - 1][j - 1], dp[i - k][j]) + 1 \right)
             * dp[i][j]=
             * 1≤k≤i
             * min
             * ​
             *  (max(dp[k−1][j−1],dp[i−k][j])+1)
             *
             * 「状态转移方程」里最外层的变量是 k，它枚举了扔下鸡蛋的楼层的高度，这里它是自变量，将其余的 i 和 j 视为常数：
             *
             * dp[k - 1][j - 1]：根据语义，k 增大的时候，楼层大小越大，它的值就越大；
             * dp[i - k][j]：根据语义，k 增大的时候，楼层大小越小，它的值就越小。
             * 可以得出一个是单调不减的（dp[k - 1][j - 1]，下图红点），一个是单调不增的
             *
             * 作者：liweiwei1419
             * 链接：https://leetcode-cn.com/problems/super-egg-drop/solution/dong-tai-gui-hua-zhi-jie-shi-guan-fang-ti-jie-fang/
             * 来源：力扣（LeetCode）
             * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
             */

            // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少实验的次数
            // 注意：
            // 1、i 表示的是楼层的大小，不是第几层的意思，例如楼层区间 [8, 9, 10] 的大小为 3，这一点是在状态转移的过程中调整的定义
            // 2、j 表示可以使用的鸡蛋的个数，它是约束条件，我个人习惯放在后面的维度，表示消除后效性的意思

            // 0 个楼层和 0 个鸡蛋的情况都需要算上去，虽然没有实际的意义，但是作为递推的起点，被其它状态值所参考
            int[][] dp = new int[N + 1][K + 1];

            // 由于求的是最小值，因此初始化的时候赋值为一个较大的数，9999 或者 i 都可以
            for (int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], i);
            }

            // 初始化：填写下标为 0、1 的行和下标为 0、1 的列
            // 第 0 行：楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0
            for (int j = 0; j <= K; j++) {
                dp[0][j] = 0;
            }

            // 第 1 行：楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次
            dp[1][0] = 0;
            for (int j = 1; j <= K; j++) {
                dp[1][j] = 1;
            }

            // 第 0 列：鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0
            // 第 1 列：鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度（想想复杂度的定义）
            for (int i = 0; i <= N; i++) {
                dp[i][0] = 0;
                dp[i][1] = i;
            }

            // 从第 2 行，第 2 列开始填表
            for (int i = 2; i <= N; i++) {
                for (int j = 2; j <= K; j++) {
                    for (int k = 1; k <= i; k++) {
                        // 碎了，就需要往低层继续扔：层数少 1 ，鸡蛋也少 1
                        // 不碎，就需要往高层继续扔：层数是当前层到最高层的距离差，鸡蛋数量不少
                        // 两种情况都做了一次尝试，所以加 1
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
                    }
                }
            }
            return dp[N][K];
        }

    }


    public int superEggDrop2(int K, int N) {
        /**
         * 时间复杂度：O(NK \log N)O(NKlogN)，其中一层循环变成二分查找，复杂度成为对数；
         * 空间复杂度：O(NK)O(NK)，表格的大小。
         */
        // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少仍的次数
        int[][] dp = new int[N + 1][K + 1];

        // 初始化
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], i);
        }
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
        }

        dp[1][0] = 0;
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        // 开始递推
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                // 在区间 [1, i] 里确定一个最优值
                int left = 1;
                int right = i;
                while (left < right) {
                    // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                    int mid = left + (right - left + 1) / 2;

                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }
        return dp[N][K];
    }


}