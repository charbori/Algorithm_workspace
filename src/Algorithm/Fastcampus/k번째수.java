package Algorithm.Fastcampus;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class k번째수 {
    static int N;
    static int idx;
    static ArrayList<Integer> dataList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        idx = Integer.parseInt(st.nextToken());

        dataList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int i = 0;

        while(st.hasMoreTokens()){
            dataList.add(Integer.parseInt(st.nextToken()));
            i++;
        }

        dataList = quickSort(dataList);

        for (int k :
                dataList) {
            System.out.println(k);
        }
    }

    static ArrayList<Integer> quickSort(ArrayList<Integer> dataList){
        if(dataList.size() < 1)
            return dataList;

        int pivot = dataList.get(0);
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> listLeft = new ArrayList<>();
        ArrayList<Integer> listRight = new ArrayList<>();

        for (int i=1;i<dataList.size();i++){
            if(dataList.get(i) < pivot){
                listLeft.add(dataList.get(i));
            }
            if(dataList.get(i) >= pivot){
                listRight.add(dataList.get(i));
            }
        }

        answer.addAll(quickSort(listLeft));
        answer.add(pivot);
        answer.addAll(quickSort(listRight));

        return answer;
    }
}
