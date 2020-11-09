package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문서검색 {
    static StringBuilder strData;
    static String target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        strData = new StringBuilder();
        strData.append(br.readLine());

        target = br.readLine();

        System.out.println(searchDocument(strData, target));
    }

    static int searchDocument(StringBuilder str, String strTarget){
        int i=0;
        int answer = 0;
        String strTemp = "";

        while(i + strTarget.length() < strData.length()){
            strTemp = strData.substring(i,i + strTarget.length());

            if(strTemp.equals(strTarget)){
                i +=  strTarget.length();
                answer++;
            }else{
                i++;
            }
        }

        return answer;
    }
}
