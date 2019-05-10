package Greedy;

/**
 * 分治法：把问题分小的相似的问题，去解决若干个小问题。
 */
//贪心
public class Greedy {
    public static void main(String[] args) {

        int a=1;
        int b=2;
        //交换 a b值的三种方法
        //1.利用辅助空间（易于理解，但浪费了空间）
        int temp=a;
        a=b;
        b=temp;
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        //2.利用a+b的和差来进行(不会利用辅助空间，但是a+b可能会溢出)
        a=a+b;//a=a+b
        b=a-b;//b-->a
        a=a-b;//a-b(a)  a-->b
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        //3.利用一个数与同一个数进行两次亦或，则不变
        a=a^b;//001 ^ 010 =011
        b=a^b;//011 ^ 010 =001
        a=a^b;//011 ^ 001= 010
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        //




    }
}
