package producer;

public class testMain {
    public static void main(String[] args) {
        Warehouse house=new Warehouse();
        Produce p1=new Produce(house);
       // p1.setPriority(10);//可以设置线程的级别

        Consumer c1=new Consumer(house);
        Consumer c2=new Consumer(house);
        p1.start();

        c1.start();
        c2.start();
    }
}
