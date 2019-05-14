package backTrackingMethod;

/**
 * 回溯法--8皇后问题
 * 8皇后：8*8的格子，放皇后，每一排，每一列，对角线都不能有两个皇后，求有多少种摆法
 */
public class BackTrackingMethod {
    public static int num=0;//累计方法总数
    public static final int MAXQUEEN=8;//8个皇后
    public static int[] cols=new int[MAXQUEEN];//定义cols数组，表示8列棋子摆放的位置

    public void getCount(int n){
        boolean[] rows=new boolean[8];//记录每个方格是否可以放,这里列皇后可以所在的位置
        for(int m=0;m<n;m++){//n为每一列
            rows[cols[m]]=true;//cols放的是皇后所在位置的下标，放了皇后的置放为true
            int d=n-m;//n--填第n列的皇后   d看斜对角
            //填第n列时，要查看前面n-1列的皇后的位置
            if(cols[m]-d>=0){
                rows[cols[m]-d]=true;
            }
            // \
            if((cols[m]+d)<=(MAXQUEEN-1)){
                rows[cols[m]+d]=true;
            }
        }
        //放皇后
        for(int i=0;i<MAXQUEEN;i++){
            if(rows[i]){//不能放
                continue;
            }
            cols[n]=i;//cols存放皇后的摆放位置
            if(n<MAXQUEEN-1){
                getCount(n+1);//回溯
            }else {
                //找到完整的一套方案
                num++;
                printQueen();
            }

            //下面可能也有合法位置
        }
    }

    private void printQueen() {
        System.out.println("这是第"+num+"方案：");
        for(int i=0;i<MAXQUEEN;i++){
            for(int j=0;j<MAXQUEEN;j++){
                if(i==cols[j]){
                    System.out.print("0"+" ");
                }else{
                    System.out.print("-"+" ");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BackTrackingMethod queen=new BackTrackingMethod();
        queen.getCount(0);
    }
}
