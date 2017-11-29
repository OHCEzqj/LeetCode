
public class ReverseWordsInAStringIII {
	public String reverseWords(String s) {
        char[] chars=s.toCharArray();
        int length=s.length();
        int start=0;
        for(int i=0;i<length;i++){
        	if(chars[i]==' '){
        		reverse(chars,start,i-1);
        		start=i+1;
        	}
        }
        reverse(chars,start,length-1);
        return new String(chars);
    }
	
	char[] reverse(char[] c,int i,int l){
		char s;
		while(i<l){
			s=c[i];
			c[i]=c[l];
			c[l]=s;
			i++;l--;
		}
		return c;
	}


}
