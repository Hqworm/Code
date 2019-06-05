package Leetcode;

/**
 *
 * 寻找两个有序数组的中位数
 *  时间复杂度： O(log(m + n))
 */
public class num4 {
    public static void main(String[] args) {

        num4 n=new num4();
       int[] nums1={1,2};
        int[] nums2 ={3,4};
        System.out.println(n.findMedianSortedArrays(nums1,nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int result=0;
        if(nums1.length!=0 && nums2.length!=0) {
            result=0;
            int[] res = num4.arrayMerge(nums1, nums2);//将两个数组进行归并排序
            if(res.length%2==0){//如果为偶数
                return (1.0*res[res.length/2-1]+res[res.length/2])/2;
            }else{
                return (1.0*res[res.length/2]);
            }

        }else if(nums1.length==0 && nums2.length!=0){//nums1为空
            result=0;
            if(nums2.length%2==0){//如果为偶数
                return (1.0*nums2[nums2.length/2-1]+nums2[nums2.length/2])/2;
            }else{
                return (1.0*nums2[nums2.length/2]);
            }
        }else if(nums1.length!=0 && nums2.length==0){//nums1为空
            result=0;
            if(nums1.length%2==0){//如果为偶数
                return (1.0*nums1[nums1.length/2-1]+nums1[nums1.length/2])/2;
            }else{
                return (1.0*nums1[nums1.length/2]);
            }

        }
        return 0;

    }

    /**
     * 归并排序  ：两个有序的数组 进行 快速合并并排序
     * @param a
     * @param b
     * @return
     */
    public static int[] arrayMerge(int[] a, int[] b) {
        int[] am = new int[a.length + b.length];
        int ai = 0;
        int bj = 0;

        while ((ai<a.length) && (bj<b.length)) {
            if(a[ai] < b[bj]) {
                am[ai + bj] = a[ai];
                ai++;
            } else {
                am[ai + bj] = b[bj];
                bj++;
            }
        }

        while (ai < a.length) {//当有一方数组遍历完时
            am[ai + bj] = a[ai];
            ai++;
        }

        while (bj < b.length) {
            am[ai + bj] = b[bj];
            bj++;
        }

        return am;

    }
}
