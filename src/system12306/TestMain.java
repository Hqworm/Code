package system12306;

public class TestMain {
    public static void main(String[] args) {
        Window w1=new Window("成都东站");
        Window w2=new Window("成都北站");
        Window w3=new Window("成都南");
        w1.start();
        w2.start();
        w3.start();
    }
}
