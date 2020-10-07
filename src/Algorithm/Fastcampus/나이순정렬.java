package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<String>[] list = new ArrayList[201];

        for(int i=0;i<201;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            list[age].add(name);
        }

        for(int i=0;i<201;i++){
            for(int j=0;j<list[i].size();j++){
                System.out.println(i + " " + list[i].get(j));
            }
        }
    }
}