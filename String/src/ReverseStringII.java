
public class ReverseStringII {
	 public String reverseStr(String s, int k) {
	        char[] chars=s.toCharArray();
	        int time=s.length()/(2*k);
	        System.out.println(time);
	        char temp;
	        if(time>0){
	        	for(int i=0;i<time;i++){//change ki ki+1 ki+2....ki+k-1
		        	for(int x=0;x<(k/2);x++)
		        	{
		        		temp=chars[2*k*i+x];
		        		chars[2*k*i+x]=chars[2*k*i+k-1-x];
		        		chars[2*k*i+k-1-x]=temp;
		        	}
		        }
	        }
	        //change 2k*time-1 2k*time...
	        int left=s.length()-2*k*time;//剩下的数组个数
	        //2k*time-1 2k*time .....2k*time+left-1
	        if(left<k){
	        	for(int x=0;x<(left/2);x++){
	        		temp=chars[2*k*time+x];
	        		chars[2*k*time+x]=chars[2*k*time-1+left-x];
	        		chars[2*k*time-1+left-x]=temp;
	        	}
	        }else{//left>k
	        	for(int x=0;x<(k/2);x++){
	        		temp=chars[2*k*time+x];
	        		chars[2*k*time+x]=chars[2*k*time-1+k-x];
	        		chars[2*k*time-1+k-x]=temp;
	        	}
	        }
	       return new String(chars);
	    }
}
