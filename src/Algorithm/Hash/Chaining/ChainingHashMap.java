package Algorithm.Hash.Chaining;

import Algorithm.Hash.Model.DataPair;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainingHashMap {
    LinkedList<DataPair>[] data = new LinkedList[1000];

    public int getHashCodeSimple(String str){
        int a = str.charAt(0) - 'A';
        int b = str.charAt(1) - 'A';
        int c = str.charAt(2) - 'A';
        return (a%10) * 100 + (b%10) * 10 + (c%10);
    }

    public void put(String key, int value){
        int hash_key = getHashCodeSimple(key);

        if(data[hash_key] == null){
            data[hash_key] = new LinkedList<>();
        }

        for(DataPair c: data[hash_key]){
            if(c.key == key){
                int idx = data[hash_key].indexOf(c);
                data[hash_key].remove(idx);
                data[hash_key].addLast(new DataPair(key, value));

                return ;
            }
        }

        data[hash_key].addLast(new DataPair(key, value));
    }

    public DataPair get(String key){
        int hash_key = getHashCodeSimple(key);

        for(DataPair c: data[hash_key]){
            if(c.key == key){
                System.out.println(c.key);
                System.out.println(c.data);
                return c;
            }
        }

        System.out.println("error");
        return null;
    }

    public void remove(String key){

    }

    public void printAll(){
        System.out.println();

        ListIterator<DataPair> listIterator;
        for(int i=0;i<data.length;i++){
            if(data[i] != null){
                listIterator = data[i].listIterator();
                while(listIterator.hasNext()){
                    DataPair temp = listIterator.next();
                    System.out.println(getHashCodeSimple(temp.key) + " " + temp.key + " " + temp.data);
                }
            }
        }
    }
}
