package system12306;

public class Window extends Thread{
    private String winName;
    public Window(String winName){
        this.winName=winName;
    }
    @Override
    public void run() {
       this.sellTicket();
    }

    private void sellTicket() {
        while (true){
            System12306 sys=System12306.getInstance();
            Ticket ticket=sys.getTicket();
            if(ticket==null){
                System.out.println("当前窗口"+winName+"车票售完");
                break;
            }
            System.out.println("从窗口"+winName+"卖出"+ticket);
        }
    }


}
