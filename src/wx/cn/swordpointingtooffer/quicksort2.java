package wx.cn.swordpointingtooffer;

public class quicksort2 {

    public static void quicksort(int[] n,int left,int right){
        if(left<right){
            int partition=partition(n,left,right);
            quicksort(n,left,partition-1);
            quicksort(n,partition+1,right);


        }
        return ;
    }

    private static int partition(int[] n, int left, int right) {
        int base=n[left];
        while(left<right) {
            while (left < right && base <= n[right]) right--;
            n[left] = n[right];
            while (left < right && base >= n[left]) left++;
            n[right] = n[left];
        }
        n[left]=base;
        return left;

    }

    public static boolean Isright(int[] n){
        for(int i=0;i<n.length-1;i++){
            if(n[i]>n[i+1])return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[] n={2,4444,2123,223,412,442,2,4,4,445,34,78,35,75,12,54,95,25,23,55,55,55};
        quicksort(n,0,n.length-1);
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }

        System.out.println("IsRIght:"+Isright(n));
    }
}
