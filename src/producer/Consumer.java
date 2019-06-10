package producer;

public class Consumer extends Thread {

    private Warehouse house;
    public Consumer(Warehouse house){
        this.house=house;
    }
    @Override
    public void run() {
        house.get();
        System.out.println("消费者消费了货物");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
