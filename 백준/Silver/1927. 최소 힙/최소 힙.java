import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		//List<Integer> arr = new ArrayList<>();
		PriorityQueue<Integer> arr = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			//StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(arr.isEmpty())
					bw.write("0\n");
				else
					bw.write(Integer.toString(arr.poll()) + "\n");
			}
			else {
				arr.add(num);
			}
		}
		bw.flush();
	}
}
