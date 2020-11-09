package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 중량제한 {
    static ArrayList<Pair> dataList[];
    static int N, M;
    static Pair target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dataList = new ArrayList[N + 1];

        for(int i=0;i<N+1;i++){
            dataList[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            dataList[x].add(new Pair(y, dis));
            dataList[y].add(new Pair(x, dis));
        }

        st = new StringTokenizer(br.readLine());
        target = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for(int i=0;i<N+1;i++){
            Collections.sort(dataList[i], new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.value - o2.value;
                }
            });
        }

        int disMin = 0;
        int disMax = dataList[target.idx].size();
        int disMid = 1;
        int nextNode = target.idx;

        while(disMid <= disMax){

            String tracking = "";
            tracking += nextNode;

            while(nextNode != target.value){
                for(int i=0;i<dataList[nextNode].size();i++){
                    Pair nextRoad = dataList[nextNode].get(i);

                    if(nextRoad.value >= disMid){
                        nextNode = nextRoad.idx;
                        tracking += "->" + nextNode;
                    }else{
                        continue;
                    }
                }
            }

            disMid++;
        }
        System.out.println(disMid);
    }
}

