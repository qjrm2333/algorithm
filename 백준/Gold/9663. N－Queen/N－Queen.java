import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, cnt = 0;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        visited = new int[N];
        for (int i = 0; i < N; i++) {
            visited[i] = -1;
        }

        backtrack(0);

        bw.write(cnt+"");
        bw.flush();
    }

    static void backtrack(int num) throws IOException {
        if (num == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            boolean check = false;
            for(int j = 0; j < num; j++) {
                if (visited[j] == i || num - j == Math.abs(visited[j] - i)) {
                    check = true;
                    break;
                }
            }

            if(!check){
                visited[num] = i;
                backtrack(num+1);
            }
        }
    }
}

