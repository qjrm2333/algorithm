import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Node implements Comparable<Node>{
        int e, v;
        public Node(int e, int v){
            this.e = e;
            this.v = v;
        }
        @Override
        public int compareTo(Node o){
            return o.v - this.v;
        }
    }

    static int N, M, ans = Integer.MAX_VALUE;
    static ArrayList<Node>[] roads;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        roads = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            roads[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            roads[a].add(new Node(b, c));
            roads[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start, end);

        bw.write(ans+"");
        bw.flush();
    }

    static void dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, Integer.MAX_VALUE));
        boolean[] visited = new boolean[N+1];
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.e]) continue;
            visited[cur.e] = true;
            ans = Math.min(ans, cur.v);
            if(cur.e == end) return;
            for(Node next : roads[cur.e]){
                if(!visited[next.e]) pq.add(next);
            }
        }
    }
}
