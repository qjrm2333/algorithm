import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[] S;
    static String ans;
    static boolean[][][][][] visited;

    public static void main(String[] args) throws Exception {
        S = br.readLine().toCharArray();
        int a = 0, b = 0, c = 0;
        for(int i = 0; i < S.length; i++){
            if(S[i] == 'A') a++;
            else if(S[i] == 'B') b++;
            else if(S[i] == 'C') c++;
        }
        visited = new boolean[a+1][b+1][c+1][3][3];

        dfs(a, b, c, 0, 0, "");

        if(ans == null){
            bw.write("-1");
        } else {
            bw.write(ans);
        }
        bw.flush();
    }

    static void dfs(int a, int b, int c, int prev1, int prev2, String str) {
        if(a == 0 && b == 0 && c == 0){
            ans = str;
            return;
        }

        if(visited[a][b][c][prev1][prev2]) return;
        visited[a][b][c][prev1][prev2] = true;
        if (a > 0) {
            dfs(a - 1, b, c, 0, prev1, str + "A");
        }
        if(b > 0 && prev1 != 1) {
            dfs(a, b - 1, c, 1, prev1, str + "B");
        }
        if(c > 0 && prev1 != 2 && prev2 != 2) {
            dfs(a, b, c - 1, 2, prev1, str + "C");
        }
    }
}
