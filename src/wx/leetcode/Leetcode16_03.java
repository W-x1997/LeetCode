package wx.leetcode;

public class Leetcode16_03 {
    class Solution {
        /**
         * 面试题 16.03. Intersection LCCI
         * Given two straight line segments (represented as a start point and an end point), compute the point of intersection, if any. If there's no intersection, return an empty array.
         *
         * The absolute error should not exceed 10^-6. If there are more than one intersections, return the one with smallest X axis value. If there are more than one intersections that have same X axis value, return the one with smallest Y axis value.
         * Example 1:
         *
         * Input:
         * line1 = {0, 0}, {1, 0}
         * line2 = {1, 1}, {0, -1}
         * Output:  {0.5, 0}
         * @param start1
         * @param end1
         * @param start2
         * @param end2

         */
        public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
            double k1 = 0, k2 = 0, b1 = 0, b2 = 0;
            boolean vertical1 = true, vertical2 = true;
            double[] res = new double[2];
            double[] empty = new double[0];
            //前4个if是为了让x更小的点在前面，如果x相同，让y值更小的点在前面，方便后面进行判断
            if(start1[0]>end1[0]) {
                int[] tmp = start1;
                start1 = end1;
                end1 = tmp;
            }
            if(start2[0]>end2[0]) {
                int[] tmp = start2;
                start2 = end2;
                end2 = tmp;
            }
            if(start1[0]==end1[0]&&start1[1]>end1[1]) {
                int[] tmp = start1;
                start1 = end1;
                end1 = tmp;
            }
            if(start2[0]==end2[0]&&start2[1]>end2[1]) {
                int[] tmp = start2;
                start2 = end2;
                end2 = tmp;
            }
            //将int转为double，否则计算double x = 2/3; x=0.0
            double x1 = start1[0], y1 = start1[1], x2 = end1[0], y2 = end1[1];
            double x3 = start2[0], y3 = start2[1], x4 = end2[0], y4 = end2[1];
            //y=kx+b，计算k和b
            if(x1!=x2) {
                k1 = (y1-y2)/(x1-x2);
                b1 = (x1*y2-x2*y1)/(x1-x2);
                vertical1 = false;
            }
            if(x3!=x4) {
                k2 = (y3-y4)/(x3-x4);
                b2 = (x3*y4-x4*y3)/(x3-x4);
                vertical2 = false;
            }
            if(!vertical1&&!vertical2&&k1==k2) {//平行且都不为垂直于x轴的线段，多个交点（如果有）
                if(b1!=b2) return empty;
                else if((x1>=x3&&x1<=x4)||(x3>=x1&&x3<=x2)) {
                    res[0] = Math.max(x1, x3);
                    res[1] = res[0]==x1 ? y1 : y3;
                    return res;
                } else return empty;
            } else  if(vertical1&&vertical2) {//平行且都为垂直于x轴的线段，多个交点且x坐标相同（如果有）
                if(x1!=x3) return empty;
                else  if((y1>=y3&&y1<=y4)||(y2>=y3&&x2<=y4)) {
                    res[0] = x1;
                    res[1] = Math.max(y1, y3);
                    return res;
                } else return empty;
            } else if(vertical1&&!vertical2) {//线段1垂直于x轴
                if(x1>=x3&&x1<=x4) {
                    double y = k2*x1 + b2;
                    if(y>=y3&&y<=y4) {
                        res[0] = x1;
                        res[1] = y;
                        return res;
                    } else  return empty;
                } else return empty;
            } else if(!vertical1&&vertical2) {//线段2垂直于x轴
                if(x3>=x1&&x3<=x2) {
                    double y = k1*x3 + b1;
                    if(y>=y1&&y<=y2) {
                        res[0] = x3;
                        res[1] = y;
                        return res;
                    } else return empty;
                } else return empty;
            } else {//其他情况
                double x = (b2-b1)/(k1-k2);
                if(x>=x1&&x<=x2&&x>=x3&&x<=x4) {
                    res[0] = x;
                    res[1] = k1*x+b1;
                    return res;
                } else return empty;
            }
        }
    }

}
