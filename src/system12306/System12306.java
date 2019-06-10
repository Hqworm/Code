package system12306;

import java.util.Vector;

public  class System12306 {
    //设计一个单例模式
    private System12306(){};
    private static System12306 sys=new System12306();
    public static System12306 getInstance(){
        return sys;
    }


    private Vector<Ticket> tickets=new Vector<>();

    //在系统创建对象后给tickets赋值
    {
        for (int i = 0; i <200 ; i++) {
            tickets.add(new Ticket("北京"+i,"成都"+i,i*3.0f+3));
        }
    }


    public Ticket getTicket(){
        try {
            return tickets.remove(0);
        }catch (Exception e){
            return null;
        }


    }

}
