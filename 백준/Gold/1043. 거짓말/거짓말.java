import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, cnt;
    static int[] parents;
    static List<Integer>[] party;
    static boolean[] known;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        known = new boolean[N+1];
        party = new List[M];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }
        for(int i = 0; i < M; i++){
            party[i] = new ArrayList<>();
        }


        st = new StringTokenizer(br.readLine());
        int knownNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knownNum; i++) {
            int a = Integer.parseInt(st.nextToken());
            known[a] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partyNum; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }

            for(int j = 1; j < party[i].size(); j++){
                union(party[i].get(0), party[i].get(j));
            }
        }

        for(int i = 0; i < M; i++) {
            for (int j = 0; j < party[i].size(); j++) {
                if (known[find(party[i].get(j))]) {
                    cnt++;
                    break;
                }
            }
        }

        bw.write((M-cnt)+"");
        bw.flush();
    }

    static int find(int x){
        if(parents[x] == x){ return x;}
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x == y) return;

        if(known[x]) parents[y] = x;
        else if(known[y]) parents[x] = y;
        else{
            if(x > y){parents[x] = y;}
            else parents[y] = x;
        }
    }
}

