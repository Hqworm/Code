package producer;

public class Produce extends Thread{
    //为了保证生产者与消费者使用同一个长裤
    private Warehouse house;
    public  Produce(Warehouse house){
        this.house=house;
    }
    @Override
    public void run() {
        while(true){
            house.add();
            System.out.println("生产者存入一个货物");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
