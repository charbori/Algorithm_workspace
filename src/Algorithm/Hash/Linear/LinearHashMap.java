package Algorithm.Hash.Linear;

import Algorithm.Hash.Model.DataPair;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;

public class LinearHashMap {
    HashMap<String, DataPair> data = new HashMap<>();

    public String getHashCode(String str){
        StringBuffer hexString = new StringBuffer();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes("UTF-8"));


            for(int i=0;i<hash.length;i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            //System.out.println(hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return hexString.toString();
    }

    public String getHashCodeSimple(String str){
        return str.substring(0,2);
    }

    public void put(String key, int value){
        String hash_key = getHashCodeSimple(key);

        //case key 중복인가?
        if(data.containsKey(hash_key)){
            while(data.containsKey(hash_key) && !data.get(hash_key).key.equals(key)){
                hash_key += "a";
            }
            data.put(hash_key,new DataPair(key, value));
        }else{
            data.put(hash_key,new DataPair(key, value));
        }
    }

    public DataPair get(String key){
        String hash_key = getHashCodeSimple(key);

        if(data.containsKey(hash_key)){
            DataPair temp;

            while(data.containsKey(hash_key) && !data.get(hash_key).key.equals(key)){
                hash_key += "a";
            }
            temp = data.get(hash_key);

            if(temp != null)
                System.out.println(temp.data);
            else
                System.out.println("error");

            return temp;
        }
        else{
            System.out.println("error");
            return null;
        }
    }

    public void remove(String key){

    }

    public void printAll(){
        Iterator<String> mapIter = data.keySet().iterator();

        while(mapIter.hasNext()){
            String key = mapIter.next();
            DataPair dataPair = data.get(key);
            System.out.println(key);
            System.out.println(dataPair.key + " " + dataPair.data);
        }
    }
}
