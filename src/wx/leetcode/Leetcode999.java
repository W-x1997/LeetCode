package wx.leetcode;

public class Leetcode999 {

    /**
     *
     * 999. Available Captures for Rook
     * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
     *
     * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
     *
     * Return the number of pawns the rook can capture in one move.
     *
     */

    class Solution {
        public int numRookCaptures(char[][] board) {
            // 定义上下左右四个方向
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    // 找到白车所在的位置
                    if (board[i][j] == 'R') {
                        // 分别判断白车的上、下、左、右四个方向
                        int res = 0;
                        for (int k = 0; k < 4; k++) {
                            int x = i, y = j;
                            while (true) {
                                x += dx[k];
                                y += dy[k];
                                if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B') {
                                    break;
                                }
                                if (board[x][y] == 'p') {
                                    res++;
                                    break;
                                }
                            }
                        }
                        return res;
                    }
                }
            }
            return 0;
        }
    }

}