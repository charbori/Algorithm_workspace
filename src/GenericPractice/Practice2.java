package GenericPractice;

public class Practice2 {
    public static <T extends Number> int compare(T t1, T t2){
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();
        return Double.compare(v1, v2);
    }

    public static void main(String[] args){
        Box<Integer> b1 = Practice1.boxing(1);
        Box<Integer> b2 = Practice1.boxing(1);

        int result = Practice2.compare(10, 20);
        System.out.println(result);

        int result2 = Practice2.compare(3.5, 20);
        System.out.println(result2);

    }
}
