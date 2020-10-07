package Algorithm.SortPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;

public class MergeSortPractice2 {

    public static int[] src;
    public static int[] tmp;
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        src = new int[N];
        tmp = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int val1 = Integer.parseInt(st.nextToken());
            src[i] = val1;
        }
        merge(0, src.length - 1);

        for (int i : src){
            System.out.println(i);
        }
    }

    static void merge(int left, int right){
        //값이 다른 두 개 이상의 수인가?
        if(left < right){
            int mid = (left + right) / 2;
            //중간점을(mid) 기준으로 값을 반복하여 쪼갠다.
            merge(left, mid);
            merge(mid + 1, right);

            int p = left;
            int q = mid + 1;
            int idx = p;

            //모든 left(left <= p <= mid)와
            //모든 right(mid + 1 <= q <= right)를 비교한다.
            //이때 저장할 위치인 idx를 저장할 때마다 증가시키고
            //left를 의미하는 index값 변수인 p를 저장할 때마다 증가시키고
            //right를 의미하는 index값 변수인 q 또한 저장할 때마다 증가시킨다.
            while(p <= mid || q <= right){
                // #1  q > right
                // q가 없으면 p만 남았다는 의미이므로
                // #2  src[p] <= src[q]
                // p가 작은 값이 경우를 찾고 있음.
                // #3  p <= mid
                // while 조건이 or 조건이므로 p <= mid인 조건이 충족해야함
                if(q > right || ((src[p] <= src[q]) && p <= mid)){
                    tmp[idx++] = src[p++];
                }
                else{
                    tmp[idx++] = src[q++];
                }
            }

            for(int i=left;i<=right;i++){
                src[i] = tmp[i];
            }
        }
    }

}
