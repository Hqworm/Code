package stack;

import java.util.Stack;

/**
 * 1.栈：
 *      boolean push(E data)入栈，压栈
 *      E pop()出栈
 *      void peek()检视下一个
 * 变量：
 *      size(记录栈里面的数据个数) top(栈顶下标)
 *
 *
 * @author worm
 */

public class MyStack<T>{
    private int size;
    private int top;
    private Object[] data;//数组时没有泛型的，所以不能用T
    private int len;


    /**
     * 构造方法
     * @param len 容器的容量
     */
    public MyStack(int len){
        this.top= -1;
        this.size= 0;
        if(len<=0){
            len=10;//让用户输入的地方要去验证用户数据的合法性
        }
        this.len=len;
        data=new Object[len];
    }
    public MyStack(){
        this.size=0;
        this.top=-1;
        this.data=new Object[len];
        this.len=10;
    }

    /**
     * 压栈
     * @param t 入栈数据
     * @return boolean
     */
    public boolean push(T t){
        //判断栈是否为空
        if(size==len){
            return false;
        }else {
            data[++top]=t;
            size++;
            return true;
        }

    }

    /**
     * 出栈
     * @return 栈顶元素
     */
    public T pop(){
        if(size==0){
            return null;
        }else{
            size--;
            return (T)data[top--];
        }
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    public T peek(){
        if(size==0){
            return null;
        }else{
            return (T)data[top];
        }
    }

    /**
     * 获取栈的存储数据大小
     * @return int
     */
    public int size(){
        return size;
    }
    public boolean empty() {
        return size() == 0;
    }

}
