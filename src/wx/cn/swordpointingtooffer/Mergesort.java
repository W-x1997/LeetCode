package wx.cn.swordpointingtooffer;

public class Mergesort {

    public static void mergesort(int[]num,int left,int right){
        if(left>=right)
            return;

        int mid=(left+right)/2;
        mergesort(num,left,mid);
        mergesort(num,mid+1,right);

       merge(num,left,mid,right);


    }


    public static void  merge(int[]num,int left,int mid, int right){
        int[] temp=new int[num.length];

        int cur1=left;
        int cur2=mid+1;
        int i=left;
        while(cur1<=mid&&cur2<=right){
            if(num[cur1]<num[cur2]){
                temp[i]=num[cur1];
                i++;
                cur1++;
            }else {
                temp[i]=num[cur2];
                i++;
                cur2++;

            }

        }

        while(cur1<=mid){
            temp[i]=num[cur1];
            i++;
            cur1++;

        }

        while(cur2<=right){
            temp[i]=num[cur2];
            i++;
            cur2++;
        }

        for(int j=left;j<=right;j++){
            num[j]=temp[j];

        }


    }



    public static void main(String[] args){
            int[] n={0,12,33,123,12,3,7,3,4,8,1,44,765,77,3};
            mergesort(n,0,n.length-1);
            for(int i=0;i<n.length;i++)
            System.out.print(n[i]+" ");
    }
}
