
public class AddBinary {
	public String addBinary(String a, String b) {		
		
		char[] ca=a.toCharArray();
		char[] cb=b.toCharArray();
		int la=a.length()-1;
		int lb=b.length()-1;
		int add=0;
		StringBuilder sb=new StringBuilder();
		while(la>=0||lb>=0||add==1){
			//从最小为开始，进行每次运算
			int ta= (la)<0? 0:ca[la--] -'0';
			int tb= (lb)<0? 0:cb[lb--] -'0';
			//取余为新位
			sb.insert(0, (ta+tb+add)%2);
			add=(ta+tb+add)/2;
		}
		return sb.toString();
		}
}
