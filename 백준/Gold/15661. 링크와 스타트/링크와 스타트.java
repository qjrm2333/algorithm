import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[][] map;
	static boolean[] visit;
	static int n, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		set_team(0, 0);

		bw.write(min + "\n");
		bw.flush();
	}

	static int team_score(int bit) {
		int score = 0;
		for (int i = 0; i < n-1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (check(bit, i) && check(bit, j)) {
						score += map[i][j];
						score += map[j][i];
				}
				else if(!check(bit, i) && !check(bit, j)) {
						score -= map[i][j];
						score -= map[j][i];
				}
			}
		}
		return score;
	}

	static void set_team(int bit, int target) throws IOException {
		if (target == n) {
			int score = team_score(bit);
			min = Math.min(min, Math.abs(score));

			if (min == 0) {
				bw.write(min + "\n");
				bw.flush();
				System.exit(0);
			}
			return;
		}

		bit |= 1 << target;
		set_team(bit, target + 1);
		bit &= ~(1 << target);
		set_team(bit, target + 1);
	}

	static boolean check(int bit, int find) {
		if ((bit & (1 << find)) == (1 << find))
			return true;
		else
			return false;
	}
}
