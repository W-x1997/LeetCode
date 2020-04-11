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
     */


    class Solution {
        public int superEggDrop(int K, int N) {

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


}