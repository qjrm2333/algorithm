import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        HashMap<Integer, Integer> fruits = new HashMap<>();

        for(int end = 0, start = 0; end < N; end++) {
            fruits.put(arr[end], fruits.getOrDefault(arr[end], 0) + 1);

            while(fruits.size() > 2){
                int tmp = fruits.get(arr[start]);
                if(tmp == 1){
                    fruits.remove(arr[start]);
                } else {
                    fruits.put(arr[start], fruits.get(arr[start]) - 1);
                }
                start++;
            }

            max = Math.max(max, end-start+1);
        }

        bw.write(max+"");
        bw.flush();
    }
}
