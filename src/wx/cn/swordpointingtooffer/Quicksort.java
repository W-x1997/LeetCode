package wx.cn.swordpointingtooffer;

public class Quicksort {


    public static void quicksort(int[] n,int start,int end){
        if(start>end)
            return;
        int p=partition(n,start,end);
        quicksort(n,start,p-1);
        quicksort(n,p+1,end);

    }


    public static int partition(int[] n,int start,int end){
        int base=n[start];
        int left=start+1;
        int right=end;

        while(left<right) {
            while(n[left]<=base&&left<right){
                left++;
            }
            while(n[right]>=base&&left<right){
                right--;
            }
            int temp=n[left];
            n[left]=n[right];
            n[right]=left;
            left++;
            right--;


        }
        n[right]=base;
        return right;


    }




    public static void main(String[] args){
        int[] n={2,4444,2123,223,412,442,2,4,6767,445,34,78,35,75,12,54,95,25,23,55,55,55};
        quicksort(n,0,n.length-1);
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }

    }
}
