import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, min = Integer.MAX_VALUE;
    static int[] people;
    static ArrayList<Integer>[] route;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        people = new int[N];
        route = new ArrayList[N];
        selected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            route[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                route[i].add(Integer.parseInt(st.nextToken())-1);
            }
        }

        for(int i = 1; i < (1<<N)-1; i++){
            for(int j = 0; j < N; j++){
                selected[j] = (i & (1 << j)) !=0;
            }

            if(isConnected(true) && isConnected(false)){
                int total = 0;
                for(int j = 0; j < N; j++){
                    if(selected[j]){
                        total += people[j];
                    } else {
                        total -= people[j];
                    }
                }
                min = Math.min(min, Math.abs(total));
            }
        }

        if(min == Integer.MAX_VALUE){
            bw.write("-1\n");
        } else {
            bw.write(min + "");
        }
        bw.flush();
    }

    static boolean isConnected(boolean flag){
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            if(selected[i] == flag){
                q.add(i);
                visited[i] = true;
                break;
            }
        }

        if(q.isEmpty()){ return false;}

        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;

            for(int i : route[cur]){
                if(!visited[i] && selected[i] == flag){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

        int total = 0;
        for(int i = 0; i < N; i++){
            if(selected[i] == flag){
                total++;
            }
        }

        return total == cnt;
    }
}