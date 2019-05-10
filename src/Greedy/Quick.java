package Greedy;

/**
 * 快速排序 ：它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 */

public class Quick {
    //public  static  final int a=0;
    public static int[] sort(int arr[],int low,int high){
        /**
         *  5   1   7   2   8   9   4   10
         */
        int L=low;
        int H=high;
        int key=arr[low];//改进可以改进key的大小的策略

        // 比key 放在key右边，否则放在左边
        while(L<H){//如果L H没有碰面，则没有遍历玩
            while(L < H && arr[H]>=key)//H 从数组的最后一个元素向前遍历，如果比key大，则H--
                H--;
            if(L <H){//当遇到比arr[H]<key
                arr[L]=arr[H];//
                L++;
            }
            while(L<H && arr[L]<=key){//如果比key小则 L++
                L++;
            }
            if(L < H){// 如果 arr[L]>key
                arr[H]=arr[L];
                H--;
            }
        }
        arr[L]=key;
        System.out.println(key);
        System.out.println("L="+(L+1)+"  H="+(H+1)+" key"+key);
        //递归
        if(L-1>low) sort(arr,low,L-1);
        if(H+1<high) sort(arr,H+1,high);
        return arr;
    }

    public static void main(String[] args) {
        int [] arr={5 ,  1  , 7 ,  2  , 8  , 9 ,  4 ,  10};
        int []result=Quick.sort(arr,0,arr.length-1);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }

    }
 /*   public<T extends Comparable<? super T>> T[] quickSort(T [] target,int start,int end){

    }*/
}

