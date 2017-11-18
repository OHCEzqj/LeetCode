

public class ReverseString {
	public String reverseString(String s){
		char[] chars=s.toCharArray();
		int i=0;
		int l=s.length()-1;
		//定义临时变量
		char temp;
		while(i<l){//思考是否需要等于：加不加都一样结果
			temp=chars[i];
			chars[i]=chars[l];
			chars[l]=temp;
			++i;
			--l;
		}
		return new String(chars);
		//return chars.toString();
	}
}
