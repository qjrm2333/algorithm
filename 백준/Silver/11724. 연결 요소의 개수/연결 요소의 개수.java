import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static boolean[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < M; i++) {
            st =  new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            arr[x][y] = true;
            arr[y][x] = true;
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                bfs(i);
                cnt++;
            }
        }

        bw.write(cnt+"");
        bw.flush();
    }

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()){
            int tmp = q.poll();
            if(visited[tmp]){
                continue;
            }
            visited[tmp] = true;

            for(int i = 0; i < arr.length; i++){
                if(arr[tmp][i] && !visited[i]){
                    q.add(i);
                }
            }
        }
    }
}
