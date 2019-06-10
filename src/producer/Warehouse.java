package producer;

import java.util.ArrayList;

public class Warehouse {

    //1.设计单例模式，保证 仓库只有一个

    private ArrayList<String> list=new ArrayList<>();

    public synchronized  void add(){
        if(list.size()<20){
            list.add("a");
        }else{
            try {
                //假死 所有的线程都进入一个等待状态  通知别人 唤醒
                this.wait();//不是当前的对象wait ,是访问当前这个对象的线程wait()   访问仓库的生产者线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //1.synchronized 关键字 放在方法结构上   锁定调用那个方法的对象  可以保证线程安全，因为上锁了。
    //2.放在方法的内部  表示 对某一个锁调用方法对象

    public   synchronized void get(){
        if(list.size()>0){
            list.remove(0);
        }else{
            try {
                this.notifyAll();
                this.wait();//不是当前的对象wait ,是访问当前这个对象的线程wait()   访问仓库的消费者线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
