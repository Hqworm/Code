package queue;

/**
 * 队列：
 *      1.boolean add(T t);入队
 *      2.T t offer()出队
 *      3.boolean peek()
 *
 *      rear:队尾
 *      front:队首
 *      队内数据容量:(rear-front+len)%len
 *
 *
 */
public class MyQueue<T>{
    private int size;
    private int front;
    private int rear;
    private Object[] data;
    private int length;
    public MyQueue(){
        this.size=10;
        this.rear=-1;
        this.front=0;
        this.data=new Object[size];
        this.length=10;
    }

  /*  public MyQueue(T t){
        if(rear==length){

        }
        this.size=10;
        this.rear=0;
        this.front=0;
        this.data=new Object[size];
        this.length=10;
    }*/

    /**
     * 入队
     * @return
     */
  public boolean add(T t){
      if(size==length){
          return false;
      }else{
         rear++;
         data[rear]=t;
         size++;
         return true;
      }
  }

    /**
     * 出队
     * @return t
     */
  public T offer(){
      if(size==0){
          return  null;
      }else{

          size--;
          T t=(T)data[front++];
          if(front==rear){
              front=0;
              rear=-1;
          }
          return t;
      }
  }

    /**
     *
     * @return
     */
  public T peek(){
      if(size==0){
          return  null;
      }else{
          return (T)data[front];
      }
  }

  public int size(){
      return  this.size;
  }

    public static void main(String[] args) {
        MyQueue<String> queue=new MyQueue<>();
        queue.add("1");
        queue.add("2");
        System.out.println(queue.peek());

    }

}
