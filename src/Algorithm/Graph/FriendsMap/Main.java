package Algorithm.Graph.FriendsMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test_case = Integer.parseInt(st.nextToken());
        int str_arr = Integer.parseInt(st.nextToken());

        HashMap<String, String> name_map = new HashMap<>();
        HashMap<String, String> val_map = new HashMap<>();
        HashMap<String, String> map = new HashMap<>();

        int test_case_idx = 0;
        int map_idx = 0;

        int answer = 1;

        while (test_case_idx < test_case)
        {
            while (map_idx < str_arr)
            {
                st = new StringTokenizer(br.readLine());

                map.put(st.nextToken(), st.nextToken());

                String name = "";


                System.out.println();

                map_idx++;
            }


            test_case_idx++;
        }

    }
}
class Person{
    ArrayList<String> friends;
    String name;

    public Person(String name, String friends_name){
        this.name = name;
        friends.add(friends_name);
    }

    void add_friend(String name){
        friends.add(name);
    }
}

class FriendsMap {
    HashMap<String, Person> friends_map;
    ArrayList<String> answer_list;

    public FriendsMap(String name, Person p){
        friends_map = new HashMap<>();
        friends_map.put(name, p);
    }

    void add_friends_map(String name, String name2){
        if(friends_map.containsKey(name))
        {
            Person temp = friends_map.get(name);
            temp.add_friend(name2);
        }
        else
        {
            friends_map.put(name,new Person(name, name2));
        }
    }

    void search(Person p){
        answer_list = new ArrayList<>();


    }
}
