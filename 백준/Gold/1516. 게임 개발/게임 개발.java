import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] arr, time, cost;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        time = new int[N+1];
        cost = new int[N+1];
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            cost[i] = a;
            int b;
            while((b = Integer.parseInt(st.nextToken())) != -1){
                arr[i]++;
                list[b].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(arr[i] == 0){
                q.add(i);
                time[i] = cost[i];
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            if(list[cur].isEmpty()) continue;
            for(int i : list[cur]){
                time[i] = Math.max(time[i], time[cur]+cost[i]);
                arr[i]--;
                if(arr[i] == 0){
                    q.add(i);
                }
            }
        }

        for(int i = 1; i <= N; i++){
            bw.write(time[i]+"\n");
        }
        bw.flush();
    }
}

