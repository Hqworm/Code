package dynamic_programming;
/**
 * 动态规划：根据前面的规划，结果然后影响后面的策略
 */

/**
 * 最长公共子序列：随着前面子序列的变化而不断地规划
 * C[i,j]分别表达式下标<=i,<=j子序列  最长公共子序列
 * C[i,j]={ 0;  两个长度为0
 *          C[i-1,j-1]+1;C[i,j]的结果根据他们的前一个C[i-1,j-1]的结果+1 若Xi=Yj
 *          MAX{C[i,j-1],C[i-1,j]}  Xi ! =Yj
 *
 *          }
 *
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(LongestCommonSubsequence.findLCS("android","random"));
    }

    public static int findLCS(String A,String B){

        int n=A.length();
        int m=B.length();
        char [] a=A.toCharArray();
        char[] b=B.toCharArray();
        int[][] dp=new int[n][m];
        for (int i = 0; i <n; i++) {
            //第一列
            if(a[i]==b[0]){//第一列b[0]与a有相同，则把当前位置及其的那一列的剩余所有都置为1
                dp[i][0]=1;
                for(int j=i+1;j<n;j++){
                    dp[j][0]=1;
                }
                break;
            }
        }

        for(int i=0;i<m;i++){
                if(a[0]==b[i]){//第一行a[0]与b有相同
                    dp[0][i]=1;
                    for(int j=1+1;j<m;j++){
                        dp[0][j]=1;
                    }
                    break;
                }

        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(a[i]==b[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n-1][m-1];
    }
}
