package Algorithm.Hash.Model;

import java.util.Comparator;

public class DescendingComparator implements Comparator<HashSetMember> {
    @Override
    public int compare(HashSetMember o1, HashSetMember o2) {
        if(o1.age < o2.age) return 1;
        else if(o1.age == o2.age)   return 0;
        else return -1;
    }
}
