

public class ReverseStringII {
	 public String reverseStr(String s, int k) {
	        char[] chars=s.toCharArray();
	        int time=s.length()/(2*k);
	        if(time>0){
	        	for(int i=0;i<time;i++){
	        			chars=sort(chars,2*k*i,2*k*i+k-1);	
	        	}    	
	        }
	        int left=s.length()-2*k*time;
	        int e=left<k?left:k;
	        if(e>0){
	        	 chars=sort(chars,2*k*time,2*k*time+e-1);
	        }  
	       return new String(chars);
	    }
	 
	 
	public char[] sort(char[] chars,int s,int e){
		//对chars[],start和end之间倒序
		int l=e-s+1;
		char temp;
		for(int i=0;i<(l/2);i++){
			temp=chars[s+i];
			chars[s+i]=chars[e-i];
			chars[e-i]=temp;
		}
		return chars;
		 
	 }
}
