package MultiTasking.StateControl.Work2;

public class DataBox {

    private String data;

    public synchronized String getData() {
        if(data == null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String temp = data;
        System.out.println("출력" + data);
        data = null;

        notify();

        return temp;
    }

    public synchronized void setData(String data) {
        if(this.data != null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.data = data;
        System.out.println("입력" + data);

        notify();

    }
}

