import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T =  Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < T; testCase++){
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")){
                    map.put(num, map.getOrDefault(num, 0)+1);
                } else {
                    if(map.isEmpty())
                        continue;

                    if(num == -1){
                        int tmp = map.get(map.firstKey());
                        if(tmp == 1) map.remove(map.firstKey());
                        else map.put(map.firstKey(), tmp-1);
                    } else if(num == 1){
                        int tmp = map.get(map.lastKey());
                        if(tmp == 1) map.remove(map.lastKey());
                        else map.put(map.lastKey(), tmp-1);
                    }
                }
            }

            if(map.isEmpty()){
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey()+" "+map.firstKey()+"\n");
            }
        }
        bw.flush();
    }
}

