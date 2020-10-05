package Algorithm.Hash.Chaining;

public class Main {
    public static void main(String[] args){
        ChainingHashMap linear = new ChainingHashMap();

        linear.put("choi",1);
        linear.put("kim",2);
        linear.put("sol",3);
        linear.put("jang",4);
        linear.put("min",5);
        linear.put("chang",6);
        linear.put("cho",7);
        linear.put("choi",8);
        linear.put("choi",9);

        linear.put("choi",1);
        linear.put("kim",2);
        linear.put("sol",3);
        linear.put("jang",4);
        linear.put("min",5);
        linear.put("chang",6);
        linear.put("cho",7);
        linear.put("choi",8);
        linear.put("choi",9);

        linear.get("choi");
        linear.get("kim");
        linear.get("sol");
        linear.get("jang");
        linear.get("min");
        linear.get("chang");
        linear.get("cho");
        linear.get("choasda");

        linear.printAll();
    }
}
