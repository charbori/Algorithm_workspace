package CopyPractice;

import java.util.*;
import java.util.stream.Stream;

public class CopyExam {
    public static void main(String args[]){
        int dataArr[] = new int[10];
        int dataArrCopy[] = new int[10];

        String strArr[] = new String[10];
        String strArrCopy[] = new String[10];

        for(int i=0;i<10;i++){
            dataArr[i] = i;
            strArr[i] = String.valueOf(i);
        }

        dataArrCopy = dataArr.clone();
        strArrCopy = strArr.clone();

        for(int i=0;i<10;i++){
            dataArrCopy[i] += 10;
            strArrCopy[i] += " - change";

            System.out.println("int[" + i + "] / string[" + i + "]" + " " + dataArr[i] +"/" + strArr[i]);
            System.out.println("int[" + i + "] / string[" + i + "]" + " " + dataArrCopy[i] +"/" + strArrCopy[i]);
        }

        DoUWantCopY_Y copY_y = new DoUWantCopY_Y(strArr, 193939);

        try {
            DoUWantCopY_Y copyY = (DoUWantCopY_Y) copY_y.clone();

            copY_y.password = 2122299500;

            for(int i=0;i<10;i++){
                copY_y.strArr[i] += "-clone change";
            }

            for(int i=0;i<10;i++){
                System.out.println("int[" + i + "] / string[" + i + "]" + " " + dataArr[i] +"/" + copY_y.strArr[i]);
                System.out.println("int[" + i + "] / string[" + i + "]" + " " + dataArrCopy[i] +"/" + copyY.strArr[i]);
            }

            System.out.println("password : " + copY_y.password);
            System.out.println("password : " + copyY.password);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        String strArrArr[][] = new String[3][3];
        String strArrArrCopy[][] = new String[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                strArrArr[i][j] = "str";
            }
        }

        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        Vector<String> vector = new Vector<>();

        ArrayList<String> listCopy = new ArrayList<>();
        HashMap<String, Integer> mapCopy = new HashMap<>();
        HashSet<String> setCopy = new HashSet<>();
        Vector<String> vectorCopy = new Vector<>();

        list.add("before");
        list.add("123132");
        list.add("hahaha");

        map.put("melon",10000);
        map.put("apple",2000);
        map.put("water",1000);

        set.add("delphi");
        set.add("cobol");
        set.add("java");

        vector.add("c++");
        vector.add("unity");
        vector.add("unreal");

        listCopy = (ArrayList<String>) list.clone();
        mapCopy = (HashMap<String, Integer>) map.clone();
        setCopy = (HashSet<String>) set.clone();
        vectorCopy = (Vector<String>) vector.clone();

        //original
        list.add("original");
        map.put("original",1111);
        set.add("original");
        vector.add("original");

        //cloned obj
        listCopy.add("change");
        mapCopy.put("change",1111);
        setCopy.add("change");
        vectorCopy.add("change");

        for(int i=0;i<4;i++){
            try{
                System.out.println("list " + list.get(i) + " / " + listCopy.get(i));
                System.out.println("vector " + vector.get(i) + " / " + vectorCopy.get(i));
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        Stream<String> stream = set.stream();
        stream.forEach(s -> System.out.println("set " + s));

        stream = setCopy.stream();
        stream.forEach(s -> System.out.println("set " + s));

    }
}

class DoUWantCopY_Y implements Cloneable{
    String strArr[];
    int scores[];
    int password;

    public DoUWantCopY_Y(String[] strArr, int password){
        this.strArr = strArr;
        this.password = password;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        DoUWantCopY_Y cloneObj = (DoUWantCopY_Y) super.clone();
        cloneObj.strArr = this.strArr.clone();
        return cloneObj;
    }
}
