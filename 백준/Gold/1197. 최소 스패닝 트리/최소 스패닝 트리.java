import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E;
    static int[] parents;
    static Node[] roads;

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int value;

        public Node(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V+1];
        for(int i = 1; i <= V; i++){
            parents[i] = i;
        }
        roads = new Node[E];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            roads[i] = new Node(s, e, v);
        }

        Arrays.sort(roads);

        int ans = 0;
        for(int i = 0; i < E; i++){
            Node cur = roads[i];
            if(find(cur.start) == find(cur.end)) continue;
            ans += cur.value;
            union(cur.start, cur.end);
        }

        bw.write(ans+"");
        bw.flush();
    }

    static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b){
        int a1 = find(a);
        int b1 = find(b);

        if(a1 > b1){
            parents[a1] = b1;
        } else {
            parents[b1] = a1;
        }
    }
}

