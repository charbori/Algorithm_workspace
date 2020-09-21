package Lib_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Queue <T> implements java.util.Queue {
    ArrayList<T> queue;

    public Queue(){
        this.queue = new ArrayList<T>();
    }
    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        if(this.queue.size() == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean contains(Object o) {
        if(this.queue.contains(o))
            return true;
        else
            return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public T[] toArray() {
        return (T[]) this.queue.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        this.queue.add((T) o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(this.queue.contains((T) o)){
            this.queue.remove((T) o);
            return true;
        }else{
            try {
                throw new Exception("not in list");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        if(!queue.isEmpty()){
            queue.clear();
        }else{

        }
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        if(this.queue.size() == 0){
            try {
                throw new Exception("nothing in list");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }else{
            T data = this.queue.get(0);
            this.queue.remove(0);
            return data;
        }
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        if(this.queue.size() == 0){
            try {
                throw new Exception("nothing in list");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }else{
            return this.queue.get(0);
        }
    }
}
