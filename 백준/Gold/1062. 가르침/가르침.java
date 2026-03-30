import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K, base, max = 0;
    static int[] words;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new int[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int bit = 0;

            for(char c : s.toCharArray()) {
                bit |= (1 << (c - 'a'));
            }
            words[i] = bit;
        }

        if(K < 5){
            bw.write("0");
            bw.flush();
            return;
        }

        base = 0;
        base |= (1 << ('a' - 'a'));
        base |= (1 << ('n' - 'a'));
        base |= (1 << ('t' - 'a'));
        base |= (1 << ('i' - 'a'));
        base |= (1 << ('c' - 'a'));

        learn(0, 0, base);

        bw.write(max+"");
        bw.flush();
    }

    static void learn(int idx, int cnt, int learned){
        if(cnt == K - 5){
            int check = 0;
            for(int word : words){
                if((word & learned) == word){
                    check++;
                }
            }

            max = Math.max(max, check);
            return;
        }

        for(int i = idx; i < 26; i++){
            if((learned & (1 << i))!=0) continue;
            learn(i + 1, cnt + 1, learned | (1 << i));
        }
    }
}