import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine(), "+-", true);

        int ans = 0;
        boolean flag = false;
        while (st.hasMoreTokens()) {
            String ch = st.nextToken();
            if (ch.equals("+")) {
                ch = st.nextToken();
                if(!flag){
                    ans += Integer.parseInt(ch);
                } else {
                    ans -= Integer.parseInt(ch);
                }
            } else if (ch.equals("-")) {
                ch = st.nextToken();
                flag = true;
                ans -= Integer.parseInt(ch);
            } else {
                ans += Integer.parseInt(ch);
            }
        }

        bw.write(ans+"");
        bw.flush();
    }
}
