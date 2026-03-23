import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static class Team {
        int teamNo;
        int member = 1;
        int score = 0;
        int check = 0;
        int last = 0;

        public Team(int teamNo) {
            this.teamNo = teamNo;
        }

        public int compare(Team o1, Team o2) {
            if (o1.score != o2.score) {
                return o2.score - o1.score;
            } else {
                return o2.last - o1.last;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] rank = new int[N];

            Map<Integer, Team> teams = new HashMap<>();

            for (int j = 0; j < N; j++) {
                rank[j] = Integer.parseInt(st.nextToken());
                if (teams.containsKey(rank[j])) {
                    teams.get(rank[j]).member++;
                } else {
                    teams.put(rank[j], new Team(rank[j]));
                }
            }

            int score = 1;
            for (int j = 0; j < N; j++) {
                Team team = teams.get(rank[j]);
                if (team.member == 6) {
                    if (team.check < 4) {
                        team.score += score;
                    } else if (team.check == 4) {
                        team.last = j;
                    }
                    team.check++;
                    score++;
                }
            }

            Team minTeam = teams.values()
                    .stream()
                    .filter(e -> e.score != 0)
                    .min(Comparator.comparingInt((Team e) ->
                                    e.score)
                            .thenComparingInt(e -> e.last))
                    .orElse(null);

            System.out.println(minTeam.teamNo);
        }
    }
}
