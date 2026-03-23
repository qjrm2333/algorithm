import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int num = Integer.parseInt(br.readLine());
        long[] road =  new long[num-1];
        long[] city =  new long[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num-1; i++){
            road[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            city[i] = Long.parseLong(st.nextToken());
        }

        long ans = 0;
        long min = city[0];

        for(int i = 0; i < num-1; i++){
            if(city[i] < min){
                min = city[i];
            }
            ans += min * road[i];
        }
        
        bw.write(ans+"\n");
        bw.flush();
    }
}
