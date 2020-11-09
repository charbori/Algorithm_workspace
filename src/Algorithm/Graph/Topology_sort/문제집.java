package Algorithm.Graph.Topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제집
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> need_visit = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();
        int[] arr = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];

        int j = 0;
        while(j < N + 1)
        {
            list[j] = new ArrayList<>();
            j++;
        }

        int i = 0;
        while(i < M)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[y]++;
            list[x].add(y);
            i++;
        }

        arr[0] = -1;

        for(int x=1;x<N+1;x++)
        {
            if(arr[x] == 0)
            {
                need_visit.add(x);
            }
        }

        while(!need_visit.isEmpty())
        {
            int node = need_visit.poll();

            answer.add(node);

            for(int next : list[node])
            {
                arr[next]--;
                if(arr[next] == 0)
                {
                    need_visit.add(next);
                }
            }
        }

        while(!answer.isEmpty())
            System.out.print(answer.poll() + " ");
    }
}
