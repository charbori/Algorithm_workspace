package Algorithm.Hash.Model;

import java.util.Comparator;
import java.util.HashSet;

public class HashSetMember implements Comparable<HashSetMember>{
    public String name;
    public int age;

    public HashSetMember(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof HashSetMember){
            HashSetMember member = (HashSetMember) obj;
            return member.name.equals(this.name) && (member.age == this.age);
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        System.out.println((this.name.hashCode() + age));
        return this.name.hashCode() + age;
    }

    @Override
    public int compareTo(HashSetMember o) {
        if(this.age < o.age)    return -1;
        else if(this.age == o.age)  return 0;
        else return 1;
    }
}
