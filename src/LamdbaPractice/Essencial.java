package LamdbaPractice;

public class Essencial {

    public static void main(String[] args){
        EssentialInterface e = () ->{
            String str = "method call";
            System.out.println(str);
        };
        e.method();

        e = () -> {
            String str = "method call2";
            System.out.println(str);
        };
        e.method();

        e = () -> {
            String str = "method call3";
            System.out.println(str);
        };
        e.method();

        EssentialInterface2 e2 = (a, b) -> {
            System.out.println(a + b + "");
            return a + b;
        };
        e2.method(10,20);
    }
}

@FunctionalInterface
interface EssentialInterface{
    void method();
}

@FunctionalInterface
interface EssentialInterface2{
    int method(int x, int y);
}