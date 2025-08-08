import java.io.*;
import java.util.*;

public class Main {

    static long cnt = 0;
    static int r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        split(r, c, (int) Math.pow(2, N));
        bw.write(cnt+"\n");
        bw.flush();
        return;
    }

    private static void split(int x, int y, int len){
        if(len == 1)
            return;

        if(x < len/2 && y < len/2){
            split(x, y, len/2);
        } else if(x < len/2 && y >= len/2){
            cnt += len * len / 4;
            split(x, y-len/2, len/2);
        } else if(x >= len/2 && y < len/2){
            cnt += len * len / 4 * 2;
            split(x-len/2, y, len/2);
        } else if(x >= len/2 && y >= len/2){
            cnt += len * len / 4 * 3;
            split(x-len/2, y-len/2, len/2);
        }
    } 
    
}
