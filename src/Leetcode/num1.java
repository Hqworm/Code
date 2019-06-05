package Leetcode;

//1.两数之和
public class num1 {
    //给定 nums = [2, 7, 11, 15], target = 9
    //
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]
    public int[] twoSum1(int[] nums, int target) {//暴力法
        int[] res=new int[2];

        int num=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                num=nums[i]+nums[j];//如果找到就退出
                if(num==target){
                    res[0]=i;
                    res[1]=j;
                    break;

                }
                //入果没找找到 就继续

            }
        }


        return res;
    }

    public int[] twoSum2(int[] nums, int target) {//暴力法
        int[] res=new int[2];

        int point=0;
        int rear=nums.length-1;
        while((nums[point]+nums[rear])!=target && rear>point){
            while((nums[point]+nums[rear])!=target && rear>point){
                rear--;
                if((nums[point]+nums[rear])==target){
                    res[0]=point;
                    res[1]=rear;
                    break;
                }
            }

            rear=nums.length-1;
            point++;
        }


        return res;
    }

    public static void main(String[] args) {
        num1 u=new num1();
        int nums[]={2,7,11,15};
        int res[]=u.twoSum2(nums,26);
        for (int i = 0; i <res.length ; i++) {
            System.out.println(res[i]);
        }
    }
}
