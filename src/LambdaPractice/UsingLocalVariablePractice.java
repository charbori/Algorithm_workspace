package LambdaPractice;

public class UsingLocalVariablePractice{
    public static void main(String[] args){
        UsingLocalVariable ulv = new UsingLocalVariable();
        ulv.method(20);
    }
}

class UsingLocalVariable {
    void method(int arg){
        int localVar = 40;

        MyFunctionalInterface fi = () -> {
            System.out.println("arg: " + arg);
            System.out.println("localVar: " + localVar);
        };
        fi.method();
    }
}

interface MyFunctionalInterface{
    public void method();
}

