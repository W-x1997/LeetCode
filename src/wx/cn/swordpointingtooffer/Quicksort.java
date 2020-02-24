package wx.cn.swordpointingtooffer;

public class Quicksort {


    public static void quicksort(int[] n,int start,int end){
        if(start>=end)
            return;
        int p=partition(n,start,end);
        quicksort(n,start,p-1);
        quicksort(n,p+1,end);

    }


    public static int partition(int[] n,int left,int right){
        int base=n[left];


        while(left<right) {

            while(n[right]>=base&&left<right){
                right--;
            }
            n[left] = n[right];
            while(n[left]<=base&&left<right){
                left++;
            }
            n[right]=n[left];



        }
        n[left]=base;

        return left;


    }

  public static void swap(int[] n,int i,int j){
        int temp=n[i];
        n[i]=n[j];
        n[j]=temp;
  }


    public static void main(String[] args){
        int[] n={2,4444,2123,223,412,442,2,4,4,445,34,78,35,75,12,54,95,25,23,55,55,55};
        quicksort(n,0,n.length-1);
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }

    }
}
