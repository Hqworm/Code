package Greedy;

import java.util.Arrays;

/**
 * 归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,该算法是采用分治法（Divide and Conquer）应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
 */
public class MergeSort {
    public static int[] mergeSort(int[] array){
        int length=array.length;
        int middle=length/2;
        int []result;
        if(length>1){//如果问题规模>1 则分
            int left[]= Arrays.copyOfRange(array,0,middle);
            int right[]=Arrays.copyOfRange(array,middle,length);
            mergeSort(left);//递归左半部分使用分治
            mergeSort(right);
           result= merge(array,left,right);
        }else{
            result=array;
        }
        return result;

    }

    //合并排序 升序
    private static  int[] merge(int[] result,int []left,int []  right){
        int i=0;//result 的 index
        int L=0;// left 的 index
        int R=0;// right 的 index
        while(L<left.length && R<right.length){
            if (left[L] < right[R]) {
                result[i]=left[L];
                i++;
                L++;
            }else {
                result[i]=right[R];
                R++;
                i++;
            }
        }

        while(R<right.length){//如果left 遍历完了剩right
            result[i]=right[R];
            R++;
            i++;
        }

        while(L<left.length){//如果right 遍历完了，剩 left
            result[i]=left[L];
            L++;
            i++;

        }
        return result;

    }

    public static void main(String[] args) {
       int [] array={1,6,5,4,7,8,9,3,2,10};
       int[] result= MergeSort.mergeSort(array);
       for(int i=0;i<result.length;i++){
           System.out.print(result[i]+" ");
       }

    }
}
