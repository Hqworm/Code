package dynamic_programming;

/**
 * 最小路径和：
 */
/*
给定一个矩阵m，从左上角开始每次只能向右走或者向下走，最后达到右下角的位置，
路径中所有数字累加起来就是路径和，返回所有路径的最小路径和，如果给定的m如下，
那么路径1,3,1,0,6,1,0就是最小路径和，返回12.

1 3 5 9     1   4   9   18
8 1 3 4     9   5   8   12
5 0 6 1     14  5   11  12
8 8 4 0     26  13  15  12


假设m是m行n列的矩阵，那么我们用dp[m][n]来抽象这个问题，dp[i][j]表示的是从原点到i,
j位置的最短路径和。我们首先计算第一行和第一列，直接累加即可，那么对于其他位置，
要么是从它左边的位置达到，要么是从上边的位置达到，我们取左边和上边的较小值，
然后加上当前的路径值，就是达到当前点的最短路径。然后从左到右，
 */
public class MinimumPathSum {
    public static void main(String[] args) {
       int[][] array={{1 ,3 ,5 ,9} ,
               {8 ,1 ,3 ,4} ,
               {5 ,0 ,6, 1 },
               {8, 8, 4 ,0}};
        System.out.println(MinimumPathSum.getMPS(array));
    }
    public static int getMPS(int[][] array){
        int m=array.length;
        int n=array[0].length;
        for(int i=0;i<m;i++){
            //第一列全部算出来
            if(i>0){
                array[i][0] = array[i - 1][0] + array[i][0];
            }

        }
        for(int j=0;j<n;j++){
            //第一行·
            if(j>0) {
                array[0][j] = array[0][j - 1] + array[0][j];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                array[i][j]=Math.min(array[i-1][j],array[i][j-1])+array[i][j];
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        return array[m-1][n-1];
    }
}
