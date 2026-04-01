import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int D;
    static String start;
    static long x, y;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        start = st.nextToken();
        st = new StringTokenizer(br.readLine());
        y = Long.parseLong(st.nextToken());
        x = Long.parseLong(st.nextToken());

        long n = (long) Math.pow(2, D);
        long[] xy = find(0, 0, 0, n, n);
        xy[0] -= x;
        xy[1] += y;

        if(xy[0] >= 0 && xy[1] >= 0 && xy[0] < n && xy[1] < n){
            divide(xy[0], xy[1], D);
        } else {
            bw.write("-1");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void divide(long x, long y, int depth){
        if(depth == 0){
            return;
        }

        long half = (long) Math.pow(2, depth-1);

        if(x < half && y >= half){
            sb.append("1");
            divide(x, y-half, depth-1);
        } else if(x < half && y < half){
            sb.append("2");
            divide(x, y, depth-1);
        } else if(x >= half && y < half){
            sb.append("3");
            divide(x-half, y, depth-1);
        } else if(x >= half && y >= half){
            sb.append("4");
            divide(x-half, y-half, depth-1);
        }
    }

    static long[] find(int idx, long lx, long ly, long rx, long ry){
        if(idx == D){
            return new long[]{lx, ly};
        }

        int num = start.charAt(idx)-'0';
        long mx = (lx+rx)/2;
        long my = (ly+ry)/2;

        if(num == 1){
            return find(idx+1, lx, my, mx, ry);
        } else if(num == 2){
            return find(idx+1, lx, ly, mx, my);
        } else if(num == 3){
            return find(idx+1, mx, ly, rx, my);
        } else{
            return find(idx+1, mx, my, rx, ry);
        }
    }
}