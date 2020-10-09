package Algorithm.Tree;

import java.util.*;

public class TreePractice {
    public static void main(String[] args){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("zoo");
        treeSet.add("base");
        treeSet.add("guess");
        treeSet.add("cherry");
        treeSet.add("apple");
        treeSet.add("ever");

        NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", true);
        for(String word : rangeSet){
            System.out.println(word);
        }

        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(new Integer(87), "홍길동");
        scores.put(new Integer(98), "이동수");
        scores.put(new Integer(95), "박길순");
        scores.put(new Integer(81), "신용권");
        scores.put(new Integer(90), "김자바");
        scores.put(new Integer(85), "델파이썬");

        Map.Entry<Integer, String> entry = null;

        entry = scores.firstEntry();
        System.out.println("가장 낮은 점수 : " + entry.getKey() + " " + entry.getValue());

        entry = scores.lastEntry();
        System.out.println("가장 높은 점수 : " + entry.getKey() + " " + entry.getValue());

        NavigableMap<Integer, String> descendingMap = scores.descendingMap();
        Set<Map.Entry<Integer, String>> descendingEntrySet = descendingMap.entrySet();
        for(Map.Entry<Integer, String> mEntry : descendingEntrySet){
            System.out.println(mEntry.getKey() + " " + mEntry.getValue());
        }

        NavigableMap<Integer, String> ascendingMap = descendingMap.descendingMap();
        Set<Map.Entry<Integer, String>> ascendingEntrySet = ascendingMap.entrySet();
        for(Map.Entry<Integer, String> nEntry : ascendingEntrySet){
            System.out.println(nEntry.getKey() + " " + nEntry.getValue());
        }
    }
}
