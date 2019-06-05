package CCF_CCSP;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CCF_19_03_02 {
    //把运算String变成 后缀式
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str;
        for (int i = 0; i <n; i++) {
            str=sc.next();
            System.out.println(CCF_19_03_02.f(str));
        }

    }

    //9+3+4x3
    public static boolean f(String str) {
        //因为题目中只有7长度 3个操作符
        //入栈  队列用于将表达式转成 后缀表达式
        Stack<String> stack1=new Stack<>();
        ArrayList<String> arr=new ArrayList<>();//用来存放后缀表达式
        int index=0;
        while(index<7){

            if(Character.isDigit(str.charAt(index))){

                //如果是数字 则直接到 arr中去
                arr.add(str.substring(index,index+1));
                index++;
            }else{//如果是操作符则进栈
                if(stack1.isEmpty()){//如果栈空 则直接进栈
                    stack1.push(str.substring(index,index+1));
                    index++;
                }else if((str.substring(index,index+1).equals("x")||str.substring(index,index+1).equals("/"))&& (stack1.peek().equals("+")||stack1.peek().equals("-"))){
                    //如果站内 - +   入栈的为 x /  直接入栈
                    stack1.push(str.substring(index,index+1));
                    index++;
                }else if((stack1.peek().equals("x")||stack1.peek().equals("/"))){
                    //如果栈内 与 将要入栈的优先级一样  则  入队列
                    arr.add(str.substring(index,index+1));
                    index++;

                }else if((str.substring(index,index+1).equals("+")||str.substring(index,index+1).equals("-"))&& (stack1.peek().equals("+")||stack1.peek().equals("-"))){
                    arr.add(str.substring(index,index+1));
                    index++;
                }
            }
        }

        while(!stack1.isEmpty()){
            arr.add(stack1.pop());
        }
        Stack<Integer> stack2=new Stack<>();
        int num=0;
        int index2=0;
        while(index2<arr.size()-1){
            if(stack2.isEmpty()){
                stack2.push(Integer.parseInt(arr.get(index2)));//栈空则 入栈

                index2++;
            }else if(Character.isDigit(arr.get(index2).charAt(0))){
                stack2.push(Integer.parseInt(arr.get(index2)));

                index2++;
            }else if(!Character.isDigit(arr.get(index2).charAt(0))){
                if(arr.get(index2).equals("+")){
                    int pop1=stack2.pop();
                    int pop2=stack2.pop();
                    int temp=pop1+pop2;
                    num=temp;
                    stack2.push(temp);
                    index2++;
                }
                if(arr.get(index2).equals("-")){
                    int pop1=stack2.pop();
                    int pop2=stack2.pop();
                    int temp=pop2-pop1;
                    stack2.push(temp);
                    num=temp;
                    index2++;
                }
                if(arr.get(index2).equals("x")){
                    int pop1=stack2.pop();
                    int pop2=stack2.pop();
                    int temp=pop1*pop2;
                    stack2.push(temp);
                    num=temp;
                    index2++;
                }
                if(arr.get(index2).equals("/")){
                    int pop1=stack2.pop();
                    int pop2=stack2.pop();
                    int temp=pop2/pop1;
                    stack2.push(temp);
                    num=temp;
                    index2++;
                }

            }

        }




        System.out.println(stack2.pop());
        return num==24;
    }

}
