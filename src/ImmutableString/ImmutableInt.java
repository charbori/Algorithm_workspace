package ImmutableString;

import java.util.Arrays;

public class ImmutableInt {
    public static void main(String[] args){
        int arr1[] = new int[5];

        Arrays.fill(arr1, 1);
        int arr2[] = new int[5];
        int arr3[] = new int[5];

        arr2 = arr1;
        arr3 = arr1;

        if(arr1[0] == arr2[0])
            System.out.println("둘은 참조 주소값이 같습니다. a는 : " + arr1[0] + " b는 : " + arr2[0]);
        else
            System.out.println("둘은 참조 주소값이 다릅니다.");

        if(arr2[0] == arr3[0])
            System.out.println("둘은 참조 주소값이 같습니다. b는 : " + arr2[0] + " c는 : " + arr3[0]);
        else
            System.out.println("둘은 참조 주소값이 다릅니다.");

        arr1[0] = 2;

        if( arr1[0] == arr2[0])
            System.out.println("둘은 참조 주소값이 같습니다. a는 : " + arr1[0] + " b는 : " + arr2[0]);
        else
            System.out.println("둘은 참조 주소값이 다릅니다.");

        if(arr2[0] == arr3[0])
            System.out.println("둘은 참조 주소값이 같습니다. b는 : " + arr2[0] + " c는 : " + arr3[0]);
        else
            System.out.println("둘은 참조 주소값이 다릅니다.");

        Immut immut1 = new Immut(arr1);
        Immut immut2 = new Immut(arr2);
        Immut immut3 = new Immut(arr3);

        arr1[0] = 3;

        if(immut1.getArr() == immut2.getArr())
            System.out.println("둘은 참조 주소값이 같습니다. a는 : " + immut1.getArr() + " b는 : " + immut2.getArr());
        else
            System.out.println("둘은 참조 주소값이 다릅니다.");

        if(immut2.getArr() == immut3.getArr())
            System.out.println("둘은 참조 주소값이 같습니다. b는 : " + immut2.getArr() + " c는 : " + immut3.getArr());
        else
            System.out.println("둘은 참조 주소값이 다릅니다.");

        int a = 1;
        int b = 2;

        //swap(a,b);

        System.out.println( a + " " + b);

        immut1.x = 10;
        immut1.y = 20;

        immut2.x = 2000;
        immut2.y = 1000;

        swap(immut1, immut2);

        System.out.println(immut1.x + " " + immut1.y);

        System.out.println(immut2.x + " " + immut2.y);

    }

    static void swap(Immut i1, Immut i2){
        Immut temp = i1;
        i1 = i2;
        i2 = temp;
    }
}

class Immut{
    int arr[];
    int x,y;

    public Immut(int[] arr){
        this.arr = arr;
        this.x = 1;
        this.y = 2;
    }

    int getArr(){
        return this.arr[0];
    }

    void setArr(int[] arr){
        this.arr = arr;
    }
}