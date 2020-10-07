package LamdbaPractice;

public class Essential {
    public int outterField = 10;

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

        EssentialInterface2 eReI = (a, b) -> a + b;
        System.out.println("interface2 변형 : " + eReI.method(10,20));

        Essential Essential = new Essential();
        Essential.Inner inner = Essential.new Inner();
        inner.method();
    }

    class Inner{
        int innerField = 20;

        void method(){
            EssentialInterface essential = () -> {
                System.out.println("outterField : " + outterField);
                System.out.println("outterField : " + Essential.this.outterField);

                System.out.println("innerField : " + innerField);
                System.out.println("innerField : " + Inner.this.innerField);
            };
            essential.method();
        }
    }
}

@FunctionalInterface
interface EssentialInterface{
    public void method();
}

@FunctionalInterface
interface EssentialInterface2{
    int method(int x, int y);
}

