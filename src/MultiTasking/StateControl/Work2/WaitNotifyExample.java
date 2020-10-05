package MultiTasking.StateControl.Work2;

public class WaitNotifyExample {
    public static void main(String[] args){
        DataBox d = new DataBox();
        ProductThread p = new ProductThread(d);
        ConsumerThread c = new ConsumerThread(d);

        p.start();
        c.start();
    }
}
