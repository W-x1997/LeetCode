package wx.leetcode;

public class Leetcode1041 {
    class Solution {
        /**

         1041. Robot Bounded In Circle

         On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

         "G": go straight 1 unit;
         "L": turn 90 degrees to the left;
         "R": turn 90 degress to the right.
         The robot performs the instructions given in order, and repeats them forever.

         Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.



         Intuition
         Let chopper help explain.

         Starting at the origin and face north (0,1),
         after one sequence of instructions,

         if chopper return to the origin, he is obvious in an circle.
         if chopper finishes with face not towards north,
         it will get back to the initial status in another one or three sequences.


         **/

        public boolean isRobotBounded(String instructions) {

            int[][] dr={{0,1},{1,0},{0,-1},{-1,0}}; //和下午对应

            int x=0;
            int y=0;

            int direction=0; //表示当前方向
            for(int i=0;i<instructions.length();i++){
                char ch=instructions.charAt(i);

                if(ch=='L'){
                    direction=(direction+3)%4;  //左转相当于+3
                }else if(ch=='R'){
                    direction=(direction+1)%4; //右转加1
                }else{
                    x=x+dr[direction][0];
                    y=y+dr[direction][1];
                }

            }

            return x==0&&y==0||direction>0;

        }

    }
}
