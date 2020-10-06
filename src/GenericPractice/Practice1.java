package GenericPractice;


public class Practice1 {
    public static <T> Box<T> boxing(T t){
        Box<T> box = new Box<>();
        box.set(t);
        return box;
    }

    public static <K, V> boolean compare(Pair<K,V> p1, Pair<K,V> p2){
        boolean keyCompare = p1.getKey().equals(p2.getKey());
        boolean valueCompare = p1.getValue().equals(p2.getValue());
        return keyCompare && valueCompare;
    }

    public static void main(String[] args){
        Box<Integer> box1 = Practice1.boxing(100);
        int intValue = box1.get();

        Box<String> box2 = Practice1.boxing("홍길동");
        String strValue = box2.get();

        System.out.println(intValue + " " + strValue);

        Pair<Integer, String> p1 = new Pair<Integer, String>(1, "사과");
        Pair<Integer, String> p2 = new Pair<Integer, String>(1, "사과");

        boolean result1 = Practice1.compare(p1, p2);
        if(result1){
            System.out.println("논리적으로 동등한 객체이다.");
        }else{
            System.out.println("다른 객체");
        }
    }
}

class Box<T> {
    private T t;
    public T get(){return t;}
    public void set(T t){this.t = t;}
}

class Pair<K,V>{
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }
}