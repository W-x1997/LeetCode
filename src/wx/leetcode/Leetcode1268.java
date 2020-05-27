package wx.leetcode;
import java.util.*;
public class Leetcode1268 {class Solution {
    /**
     *
     * 这是暴力法
     *
     *
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord){
        List<List<String>> res=new ArrayList<>();



        for(int i=0;i<searchWord.length();i++){
            Set<String> set=new TreeSet<>();   //Treeset默认按字典序排序
            String prefix=searchWord.substring(0,i+1);

            for(int j=0;j<products.length;j++){
                if(products[j].indexOf(prefix)==0)//这里不能用contains 因为 是prefix 必须保证前缀为1

                    set.add(products[j]);
            }

            List<String> list=new ArrayList(set);//set转list
            if(list.size()>3)
                list=list.subList(0,3);

            res.add(list);

        }



        return res;
    }

    /**
     * 优化
     *
     * 即先排序 然后用双指针夹逼 得到所有满足条件的单词 然后比较从左边和从右边的数量 目的是只取3个
     *
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts2(String[] products, String searchWord){
        List<List<String>> res=new ArrayList<>();

        int lo=0;
        int hi=products.length-1;

        Arrays.sort(products);

        for(int i=0;i<searchWord.length();i++){
            while((lo<=hi)&&(products[lo].length()<=i||products[lo].charAt(i)!=searchWord.charAt(i))){
                lo++;
            }

            while(lo<=hi&&(products[hi].charAt(i)!=searchWord.charAt(i)||products[hi].length()<=i)){
                hi--;
            }

            int min=Math.min(lo+3,hi+1);  //因为有可能超过3个 所以选小的
            List<String> list=new ArrayList();
            for(int k=lo;k<min;k++){
                list.add(products[k]);
            }
            res.add(list);

        }


        return res;
    }
}
}
