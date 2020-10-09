package Algorithm.Hash;

import Algorithm.Hash.Model.DescendingComparator;
import Algorithm.Hash.Model.HashSetMember;
import Algorithm.순열조합.Pair;

import java.util.*;

public class SetPractice {
    public static void main(String[] args){
        Set<HashSetMember> hashSet = new HashSet<>();

        hashSet.add(new HashSetMember("길동",20));
        hashSet.add(new HashSetMember("한솔",30));
        hashSet.add(new HashSetMember("재혁",30));

        Iterator iter = hashSet.iterator();

        while(iter.hasNext()){
            HashSetMember p = (HashSetMember) iter.next();
            System.out.println(p.name + " " + p.age);
        }

        if(hashSet.remove(new HashSetMember("길동",20))){
            System.out.println("해당 요소를 삭제하였습니다.");
        }

        iter = hashSet.iterator();

        while(iter.hasNext()){
            HashSetMember p = (HashSetMember) iter.next();
            System.out.println(p.name + " " + p.age);
        }

        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("홍길동", 85);
        map.put("재혁", 95);
        map.put("한솔", 95);
        System.out.println("entry : " + map.size());

        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();

        while(keyIterator.hasNext()){
            String key = keyIterator.next();
            Integer value = map.get(key);
            System.out.println("\t" + key + " : " + value);
        }
        System.out.println();

        map.remove("홍길동");

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();

        while(entryIterator.hasNext()){
            Map.Entry<String, Integer> mapEntry = entryIterator.next();

            System.out.println("이름 : " + mapEntry.getKey());
            System.out.println("점수 : " + mapEntry.getValue());
        }

        TreeSet<HashSetMember> treeSet = new TreeSet<>();
        TreeSet<HashSetMember> treeSetAscending = new TreeSet<HashSetMember>(new DescendingComparator());

        treeSet.add(new HashSetMember("홍길동", 44));
        treeSet.add(new HashSetMember("박자바", 34));
        treeSet.add(new HashSetMember("김파이썬", 41));

        Iterator<HashSetMember> iterator = treeSet.descendingIterator();

        while(iterator.hasNext()){
            HashSetMember tmpHashM = iterator.next();
            System.out.println(tmpHashM.name + " " + tmpHashM.age);
        }
    }
}
