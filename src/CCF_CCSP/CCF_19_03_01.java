package CCF_CCSP;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 小中大
 * 4
 * -2 -1 3 4   4 1 -2
 */
public class CCF_19_03_01 {
    static int max=0;
    static String  mid=null;
    static int  min=0;


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        CCF_19_03_01.max_mid_min(arr,n);

        System.out.println(max+" "+mid+" "+min);
    }
    public static void max_mid_min(int[] arr,int n){
        DecimalFormat df = new DecimalFormat("#.0");
        Arrays.sort(arr);
        if(n==1){
            max=arr[0];
            min=arr[0];
            mid=arr[0]+"";

        }else if(n==2){
            max=Math.max(arr[0],arr[1]);
            min=Math.min(arr[0],arr[1]);
            if((max+min)%2==0){
                mid=(max+min)/2+"";
            }else {
                mid = df.format(((double)(max + min)) / 2);
            }
        }else{//n>=3
            max=arr[n-1];
            min=arr[0];
            int index=0;
            int sum=0;
            for (int i = 1; i <n-1 ; i++) {
                sum=sum+arr[i];
                index++;

            }
            if(sum%index==0){
                mid=sum/index+"";
            }else {
                mid = df.format(((double)sum )/ index);
            }
        }

    }
}
