package wx.cn.swordpointingtooffer;

public class 二维数组的查找 {

    /**
     *     在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     *     请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *     <p/>
     *     规律：首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束：
     *      如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
     *      也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，这样每一步都可以缩小
     *      查找的范围，直到找到要查找的数字，或者查找范围为空。
     *
     *
     *
     **/
    public class Solution {
        public boolean Find(int target, int [][] array) {
            if(array==null||array.length==0)
                return false;

            int i=0;
            int j=array[0].length-1;

            while(i<array.length&&j>=0){
                if(target==array[i][j])
                    return true;
                else if(target<array[i][j]){
                    j--;
                }else
                    i++;

            }

            return false;

        }
    }
}
