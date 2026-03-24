import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] time = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] =  Integer.parseInt(st.nextToken());
            time[i][1] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return  o1[1] - o2[1];
            }
        });

        int cnt = 1;
        int tmp = 0;
        for(int i = 1; i < N; i++){
            if(time[tmp][1] <= time[i][0]){
                cnt++;
                tmp = i;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
