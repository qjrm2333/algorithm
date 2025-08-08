import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        if(n < 10) {
            bw.write(String.valueOf(n));
        } else if (n > 1022) {
            bw.write("-1");
        } else {

            for(int i = 0; i < 10; i++){
                cal(i, 1);
            }

            Collections.sort(list);
            bw.write(String.valueOf(list.get(n)));
        }
        bw.flush();
        return;
    }

    private static void cal(long num, int idx){
        if(idx > 10){
            return;
        }

        list.add(num);
        for(long i = 0; i < num % 10; i++){
            cal((num * 10) + i, idx+1);
        }
    }
}
