import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++){
            list[i] = new ArrayList<>();
        }

        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            list[fir].add(sec);
            list[sec].add(fir);
        }

        for(int i = 0; i < N+1; i++){
            Collections.sort(list[i]);
        }

        dfs(V);
        bw.write("\n");
        bfs();
        bw.flush();
    }

    static void bfs() throws IOException{
        boolean visited[] = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(visited[now])
                continue;

            visited[now] = true;
            bw.write(now+" ");

            for(int i = 0; i < list[now].size(); i++){
                queue.add((int) list[now].get(i));
            }
        }
    }

    static void dfs(int node) throws IOException{
        visited[node] = true;
        bw.write(node+" ");

        for(int i = 0; i < list[node].size(); i++){
            if(!visited[(int) list[node].get(i)]){
                dfs((int) list[node].get(i));
            }
        }
    }
}
