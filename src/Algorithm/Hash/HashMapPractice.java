package Algorithm.Hash;

import Algorithm.Hash.Chaining.ChainingHashMapPractice;

public class HashMapPractice {

    public static void main(String[] args){
        ChainingHashMapPractice hashTable = new ChainingHashMapPractice(1000);

        hashTable.put("choi jae hyeok", "010-5579-5740");
        hashTable.put("kim jae hyeok", "010-5571-5740");
        hashTable.put("Jang jae hyeok", "010-9572-5740");
        hashTable.put("Joo jae hyeok", "010-1232-5740");
        hashTable.put("Seol jae hyeok", "010-3464-5740");

        System.out.println(hashTable.get("choi jae hyeok"));
        System.out.println(hashTable.get("kim jae hyeok"));
        System.out.println(hashTable.get("Jang jae hyeok"));
        System.out.println(hashTable.get("Joo jae hyeok"));
        System.out.println(hashTable.get("Seol jae hyeok"));
    }

}