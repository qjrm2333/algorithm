import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        arr = Arrays.stream(origin)
                .distinct()
                .sorted()
                .toArray();

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }

        for(int i = 0; i < N; i++){
            bw.write(map.get(origin[i])+" ");
        }
        bw.flush();
    }
}
