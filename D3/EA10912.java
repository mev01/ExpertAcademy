import java.io.*;

public class EA10912{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			bw.write("#"+i+" ");
			String test = br.readLine();
			int notLonely = 1;
			int[] count = new int[26];
			
			//������ ���ڵ��� ���ڷ� ġȯ a->0, b->1, ...
			//ġȯ�� ���ڵ��� �迭�� �ε����� �����ϰ� �迭�� ������ ++
			for (int j = 0; j < test.length(); j++) {
				count[(int)(test.charAt(j)-'a')]++;
			}
			
			//�迭�� ���� ¦���� �ƴ϶�� �ε����� �ش��ϴ� ���ڸ� �ѹ� ���
			for (int j = 0; j < 26; j++) {
				if(count[j]%2 != 0){
					bw.write(j+'a');
					notLonely = 0;
				}
			}
			//��µ� ���� ������ Good�� �ѹ� ���
			if(notLonely == 1) bw.write("Good");
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
