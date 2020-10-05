package Algorithm.Hash.Chaining;

import Algorithm.Hash.Model.Contact;

import java.util.LinkedList;

public class ChainingHashMapPractice {
    public LinkedList<Contact>[] data;

    public ChainingHashMapPractice(int size){
        data = new LinkedList[size];
    }

    int getHashCode(String key){
        int hashCode = key.charAt(0) - 'A';
        return hashCode;
    }

    int convertToIndex(int hashCode){
        return hashCode % 26;
    }

    public void put(String key, String value){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        Contact contact = new Contact(key, value);
        if(data[index] == null){
            data[index] = new LinkedList<>();
        }
        data[index].addLast(contact);
    }

    public String get(String key){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Contact> contacts = data[index];
        for(Contact c: contacts){
            if(c.getKey().equals(key)){
                return c.getValue();
            }
        }
        return null;
    }
}
