
public class ReverseVowelsofaString {
	
	public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        String point="aeiouAEIOU";
        int l=s.length()-1;
        int i=0;
        char temp;
        
        while(i<l){
        	while(i<l&&!point.contains(chars[i]+"")){
        		i++;
        	}
        	while(l>i&&!point.contains(chars[l]+"")){
        		l--;
        	}
        	temp=chars[i];
        	chars[i]=chars[l];
        	chars[l]=temp;
        	i++;
        	l--;
        }
        
		return new String(chars);
    	}

}
