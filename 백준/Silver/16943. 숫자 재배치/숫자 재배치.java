import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[] A;
    static int B, max = -1;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        A = st.nextToken().toCharArray();
        B = Integer.parseInt(st.nextToken());
        Arrays.sort(A);
        visited = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            if(A[i] != '0') {
                visited[i] = true;
                cal(1, A[i]-'0');
                visited[i] = false;
            }
        }

        bw.write(max+"");
        bw.flush();
    }

    static void cal(int depth, int total){
        if(depth == A.length){
            if(total < B){
                max = Math.max(max,total);
            }
            return;
        }

        for(int i = 0; i < A.length; i++){
            if(!visited[i]) {
                visited[i] = true;
                cal(depth + 1, total*10+(A[i]-'0'));
                visited[i] = false;
            }
        }
    }
}