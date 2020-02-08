package wx.cn.swordpointingtooffer;

public class 不用加减乘除做加分 {




    public class Solution2 {
        public int Add(int num1,int num2) {
            int sum=0;
            while(num2!=0){
                sum=num1^num2; //异或操作表示直接两数相加  不算进位
                num2=(num1&num2)<<1; //表示 计算两数的进位   通过 与 操作 之后再左移一位
                num1=sum;
            }
            return num1;

        }
    }


    public class Solution {
        public int Add(int num1,int num2) {
            while (num2!=0) {
                int temp = num1^num2;
                num2 = (num1&num2)<<1;
                num1 = temp;
            }
            return num1;
        }
    }
}
