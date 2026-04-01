import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int K;
    static char[] arr;
    static boolean[] visited;
    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(br.readLine());
        visited = new boolean[10];
        arr = br.readLine().replace(" ","").toCharArray();

        permu("", 0);

        Collections.sort(ans);
        bw.write(ans.get(ans.size()-1)+"\n");
        bw.write(ans.get(0)+"\n");
        bw.flush();
    }

    static void permu(String num, int idx){
        if(idx == K+1){
            ans.add(num);
            return;
        }

        for(int i = 0; i <= 9; i++){
            if(!visited[i]){
                if(idx == 0 || check(num.charAt(idx-1)-'0', i, arr[idx - 1])) {
                    visited[i] = true;
                    permu(num+i, idx + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean check(int a, int b, char oper){
        if(oper == '>') return a > b;
        return a < b;
    }
}