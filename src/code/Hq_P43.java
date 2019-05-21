package code;

import java.util.Scanner;

/**
 * 为了更改的规划城市，需要统计楼栋数目信息。
 *
 *   方法如下，一张航拍照片会被分隔为N*M个小格子，每个格子可以用0跟1来表示。
 *   如果楼栋的楼顶出现在了格子里，那么此格子就被设置为1,出现在相邻格子里的楼顶被记为同一座楼栋，
 *   若是斜邻的则记为不同的楼栋。求一张图里的楼栋总数目。
 * 例如，
 * 输入{
 * {0,0,0,0,0},
 * {0,1,1,0,0},
 * {0,0,1,1,0},
 * {0,0,0,0,0}，
 * {0,0,0,0,0}
 * };输出的结果应为1
 * 输入{
 * {0,0,0,0},
 * {0,1,0,0},
 * {0,0,1,0},
 * {0,0,0,0} }输出的结果应为2
 */
public class Hq_P43 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }

        }


        System.out.println(Hq_P43.f(arr,n));
    }

    public static int  f(int[][] arr,int n){
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j=0;j<n;j++){
                if(arr[i][j]==1){
                    count++;
                    DFS(arr,i,j);

                }
            }
        }
        return count;
    }
    public static void DFS(int [][] arr ,int i,int j){//用来判断当前元素的上下相邻的 如果跟他相邻就置为0
        if(i<0|| i>= arr.length|| j<0 || j>arr.length){
            return ;
        }
        if(arr[i][j]==1){
            arr[i][j]=0;
            DFS(arr,i-1,j);//上
            DFS(arr,i+1,j);//下
            DFS(arr,i,j-1);//左
            DFS(arr,i,j+1);//右
        }

    }
}
