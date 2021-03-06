import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[]args)throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int [] value=new int [100];
			char [] op=br.readLine().toCharArray();
			int pointer=0;
			
			for (char c : op) {
				switch (c) {
					case '>' : {
						pointer=(pointer+1)%value.length;
						break;
					}
					case '<' : {
						pointer--;
						if (pointer<0) {
							pointer+=value.length;
						}
						break;
					}
					case '+' : {
						value[pointer]=(value[pointer]+1)%256;
						break;
					}
					case '-' : {
						value[pointer]--;
						if (value[pointer]<0) {
							value[pointer]+=256;
						}
						value[pointer]=value[pointer]%256;
						break;
					}
				}
			}
			
			StringBuilder expr=new StringBuilder();
			for (int i=0;i<value.length;i++) {
				String hex=Integer.toHexString(value[i]);
				if (hex.length()==1) {
					expr.append("0");
				}
				expr.append(hex);
				if (i<value.length-1) {
					expr.append(" ");
				}
			}
			
			StringBuilder sb=new StringBuilder("Case ");
			sb.append(testCase);
			sb.append(": ");
			sb.append(expr.toString().toUpperCase());
			System.out.println(sb.toString());
		}
	}
}