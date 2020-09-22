package ImmutableString;

public class Main {
    public static void main(String[] args){
        String str = "abcd";
        String str2 = str;
        String str3 = new String("abcd");

        if(str == str2)
            System.out.println("둘은 참조 주소값이 같습니다.");
        else
            System.out.println("둘은 참조 주소값이 다릅니다.");

        if(str == str3)
            System.out.println("둘은 참조 주소값이 같습니다.");
        else
            System.out.println("둘은 참조 주소값이 다릅니다.");

        if(str2 == str3)
            System.out.println("둘은 참조 주소값이 같습니다.");
        else
            System.out.println("둘은 참조 주소값이 다릅니다.");

        str = "kkkk change together!";

        System.out.println(str);
        System.out.println(str2);

        Immutable immut = new Immutable("abcd", 1);
        Immutable immut2 = new Immutable("abcd", 1);

        if(immut.str == immut2.str)
            System.out.println("둘은 참조 주소값이 같습니다.");
        else
            System.out.println("둘은 참조 주소값이 다릅니다.");

        immut.setStr("it's changed!");

        System.out.println(str);
        System.out.println(str2);
        System.out.println(immut.getStr());
        System.out.println(immut2.getStr());
    }
}

class Immutable{
    String str;
    int x;
    public Immutable(String str, int x){
        this.str = str;
        this.x = x;
    }

    public void setStr(String str){
        this.str = str;
    }

    String getStr(){
        return this.str;
    }
}
