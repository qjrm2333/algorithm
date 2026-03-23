import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String word = br.readLine();
            if(word.length() >= M){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<String> words = new ArrayList<>(map.keySet());

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if((int) map.get(o1) != map.get(o2)){
                    return Integer.compare(map.get(o2), map.get(o1));
                } else if(o1.length() != o2. length()){
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });

        for(String str: words){
            bw.write(str);
            bw.newLine();
        }
        bw.flush();
    }
}
