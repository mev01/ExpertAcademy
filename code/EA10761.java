import java.io.*;
import java.util.StringTokenizer;

public class EA10761 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			String test = br.readLine();
			StringTokenizer st = new StringTokenizer(test);
			int numInst = Integer.parseInt(st.nextToken());
			int preO = 1, preB = 1, ans = 0, lastO = 0, lastB = 0;
			String nowRobot = "a";
			
			for (int j = 0; j < numInst; j++) {
				nowRobot = st.nextToken();
				int dis = Integer.parseInt(st.nextToken());
				
				// ������ 2���� ���� ����� ����
				// 1. �κ��� �ٸ� �κ��� ����� ó���� ������ ��ٸ��� ���
				// 2. �κ��� ��ٸ��� �ʰ� �����̴ٰ� �ٷ� ��ư�� ������ ���
				// 1�� ��쿡�� ��ٷȴٰ� �ٷ� ó���ϸ� �ǹǷ� ���� ��ɾ ó���� �ð�+1
				// 2�� ��쿡�� �ٸ� �κ��� ��ɾ ó���� �ð��� ������ �� �����Ƿ� ���� �ڸ����� �������� ���� �ð��� ��� 
				if(nowRobot.equals("O")){
					int time = ( Math.abs(dis - preO) <= (ans - lastO)) ? 
							ans + 1 : (Math.abs(dis - preO) + 1 + lastO);
					ans = time;
					preO = dis;
					lastO = ans;
				}
				else if(nowRobot.equals("B")){
					int time = ( Math.abs(dis - preB) <= (ans - lastB)) ?
							ans + 1 : (Math.abs(dis - preB) + 1 + lastB);
					ans = time;
					preB = dis;
					lastB = ans;
				}
			}
			
			bw.write("#"+i+" "+ans+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
