import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, E;
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int v1, v2;

    static class Node implements Comparable<Node>{
        int end;
        int value;

        public Node(int end, int value){
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e, v));
            arr[e].add(new Node(s, v));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int total1 = 0;
        total1 += dijkstra(1, v1);
        total1 += dijkstra(v1, v2);
        total1 += dijkstra(v2, N);

        int total2 = 0;
        total2 += dijkstra(1, v2);
        total2 += dijkstra(v2, v1);
        total2 += dijkstra(v1, N);

        int ans = Math.min(total1, total2);
        if(ans >= 2500000)
            bw.write("-1");
        else
            bw.write(ans+"");
        bw.flush();
    }

    static int dijkstra(int start, int end){
        visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.end]){ continue; }
            if(cur.end == end){
                return cur.value;
            }

            visited[cur.end] = true;
            for(Node nxt : arr[cur.end]){
                if(!visited[nxt.end]){
                    pq.add(new Node(nxt.end, cur.value+nxt.value));
                }
            }
        }
        return 2500000;
    }
}

