package dynamic_programming;

/**
 * 爬楼梯：有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 * 分析：动态规划的实现的关键在于能不能准确合理的用动态规划表来抽象出实际问题。
 * 在这个问题上，我们让f(n)表示走上n级台阶的方法数。
 * 那么当n为1时，f(n) = 1,n为2时，f(n) =2,就是说当台阶只有一级的时候，
 * 方法数是一种，台阶有两级的时候，方法数为2。
 * 那么当我们要走上n级台阶，必然是从n-1级台阶迈一步或者是从n-2级台阶迈两步，
 * 所以到达n级台阶的方法数必然是到达n-1级台阶的方法数加上到达n-2级台阶的方法数之和。
 * 即f(n) = f(n-1)+f(n-2)，我们用dp[n]来表示动态规划表，dp[i],i>0,i<=n,
 * 表示到达i级台阶的方法数。
 */
public class ClimbingStairs {
    //动态规划表：用于记录到达i级台阶的方法数
    public static int[] steps=new int[11];

    public static void main(String[] args) {
        steps[10]=ClimbingStairs.calStep(10);
        for(int i=0;i< steps.length;i++){
            System.out.print(steps[i]+" ");
        }
        System.out.println();
        System.out.println(steps[10]);
    }

    public static int calStep(int n){
        if(n==1||n==2){
            return n;//入过为1则一种，如果2两种1+1 2
        }
        //计算到达n-1级阶梯的方法数
        if(steps[n-1]==0){//为的是把每一个阶梯数目存放动态规划表中
            steps[n-1]=calStep(n-1);
        }
        if(steps[n-2]==0){
            steps[n-2]=calStep(n-2);
        }
        return steps[n-1]+steps[n-2];
    }
}
