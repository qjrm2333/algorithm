import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static List<Node>[] arr;
    static boolean[] visited;
    static int[] values;

    static class Node{
        int end;
        int value;
        public Node(int end, int value){
            this.end = end;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        arr = new List[N];
        visited = new boolean[N];
        values = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = new ArrayList<>();
            values[i] = 100000000;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            arr[s].add(new Node(e, Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;

        dijkstra(start);

        bw.write(values[end]+"");
        bw.flush();
    }

    static void dijkstra(int start) throws IOException {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });
        pq.add(new Node(start, 0));
        values[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.end]){ continue; }
            visited[cur.end] = true;

//            bw.write(cur.end+" "+cur.value+"\n");

            for(Node nxt : arr[cur.end]){
                if(!visited[nxt.end] && values[nxt.end] > values[cur.end] + nxt.value){
                    values[nxt.end] = values[cur.end]+nxt.value;
                    pq.add(new Node(nxt.end, values[nxt.end]));
                }
            }
        }
    }
}

