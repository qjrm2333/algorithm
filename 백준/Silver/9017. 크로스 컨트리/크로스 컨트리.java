import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Team {
        int member;
        int score;
        int check;
        int last;
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] rank = new int[N];
            Team[] teams = new Team[201];

            for (int i = 0; i < N; i++) {
                int t = Integer.parseInt(st.nextToken());
                rank[i] = t;

                if (teams[t] == null) teams[t] = new Team();
                teams[t].member++;
            }

            int score = 1;

            for (int i = 0; i < N; i++) {
                int t = rank[i];
                Team team = teams[t];

                if (team.member == 6) {
                    if (team.check < 4) {
                        team.score += score;
                    } else if (team.check == 4) {
                        team.last = i;
                    }
                    team.check++;
                    score++;
                }
            }

            int answer = 0;
            int minScore = Integer.MAX_VALUE;
            int minLast = Integer.MAX_VALUE;

            for (int i = 1; i <= 200; i++) {
                Team t = teams[i];
                if (t == null || t.member != 6) continue;

                if (t.score < minScore || 
                   (t.score == minScore && t.last < minLast)) {
                    minScore = t.score;
                    minLast = t.last;
                    answer = i;
                }
            }

            System.out.println(answer);
        }
    }
}