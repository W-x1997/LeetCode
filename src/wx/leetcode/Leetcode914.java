package wx.leetcode;

public class Leetcode914 {
    /**
     *
     * 914. X of a Kind in a Deck of Cards
     * In a deck of cards, each card has an integer written on it.
     *
     * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
     *
     * Each group has exactly X cards.
     * All the cards in each group have the same integer.
     */

    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            // base case
            if (deck.length < 2) return false;

            // 统计频率
            int[] freq = new int[10000];
            for (int num : deck) freq[num]++;

            // 默认最大公约数为第一个数字的
            int gcd = freq[deck[0]];
            for (int f : freq) {
                if (f == 0) continue;

                // 不断求最大公约数并更新
                gcd = gcd(gcd, f);

                // 没有最大公约数
                if (gcd == 1) return false;
            }
            return true;
        }

        // 求两数的最大公约数
        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

    }
}
