

public class ReverseString {
	public String reverseString(String s){
		char[] chars=s.toCharArray();
		int i=0;
		int l=s.length()-1;
		//������ʱ����
		char temp;
		while(i<l){//˼���Ƿ���Ҫ���ڣ��Ӳ��Ӷ�һ�����
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
