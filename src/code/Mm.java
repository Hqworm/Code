package code;

class demo2 {
    public int value;


     public void ccalculate(){
     value+=7;
     }

}
public class Mm extends  demo2{
    @Override
    public void ccalculate() {
        super.ccalculate();
        value=3;
    }
    public void ccalculate(int m){
        ccalculate();
        super.ccalculate();
        value*=m;
    }

    public static void main(String[] args) {
Mm m  =new Mm();
        m.ccalculate(2);
System.out.println("value:"+m.value);
    }
}
