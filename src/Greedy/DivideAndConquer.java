package Greedy;

/**
 * 分治法：把问题分小的若干个相似的问题，去解决若干个小问题。
 */
public class DivideAndConquer {
    //解决sports Schedule问题 2^n 只球队 才能保证每天每个球队都比赛且不重复
    public void sportsScheduleTable(int[][] table ,int n){
        if(n==1){//如果只有一个球队
            table[0][0]=1;
        }else{
            /**
             *  1   2   3   4      5   6   7   8
             *  2   1   4   3      6   5   8   7
             *  3   4   1   2      7   8   5   6
             *  4   3   2   1      8   7   6   5
             *
             *  5   6   7   8      1   2   3   4
             *  6   5   8   7      2   1   4   3
             *  7   8   5   6      3   4   1   2
             *  8   7   6   5      4   3   2   1
             */
            //填充左上区域矩阵 在划分，递归
            int m=n/2;
            /**
             * 打印顺序。。。小问题，，在递归
             *  1(1)    2(2)
             *
             *  2(3)    1(4)
             */
            sportsScheduleTable(table,m);//再划分，递归

            //填充右上区域矩阵
            for (int i = 0; i <m ; i++) {
                for (int j=m;j<n;j++){
                    table[i][j]=table[i][j-m]+m;//后面比前面大m
                }
            }
            //填充左下区域矩阵
            for (int i = m; i <n ; i++) {
                for(int j=0;j<m;j++){
                    //table[i][j]=table[i-m][i]+m;与左上相比较
                    table[i][j]=table[j][i];
                }
            }
            //填充右下区域矩阵
            for (int i = m; i <n ; i++) {
                for(int j=m;j<n;j++){
                    table[i][j]=table[i-m][j-m];//与左上角相比较
                }
            }
        }
    }

    public static void main(String[] args) {
        int n=8;
        int [][] table=new int [n][n];
        DivideAndConquer schedule=new DivideAndConquer();
        schedule.sportsScheduleTable(table,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }
}

