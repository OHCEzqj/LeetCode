

public class JudgeRemoteCircle {
	   public boolean judgeCircle(String moves) {
	        int heng=0;
	        int zong=0;
	      
	        char[] out=moves.toCharArray();       
	        for(int i=0;i<out.length;i++){
	            if(out[i]=='U'){
	                zong+=1;
	            }else if(out[i]=='D'){
	                zong-=1;
	            }else if(out[i]=='R'){
	                heng+=1;
	            }else if(out[i]=='L'){
	                heng-=1;
	            }else{
	                System.out.println("wrong input!");
	            }
	        }
	       return heng==0&&zong==0;
	    }
	  
}
