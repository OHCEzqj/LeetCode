
public class RomantoInteger {
	
	  public int romanToInt(String s) {
	        char [] chars=s.toCharArray();
	        int result=Roman(chars[0]);
	        for(int i=0;i<s.length()-1;i++){
	        	result=Calculate(Roman(chars[i]),Roman(chars[i+1]),result);
	        }
	        return result;
	    }
		
		int Roman(char x){
			int fanhui;
			switch (x)
			{
				case 'I':
					fanhui=1;
					break;
				case 'V':
					fanhui=5;
					break;
				case 'X':
					fanhui=10;
					break;
				case 'L':
					fanhui=50;
					break;
				case 'C':
					fanhui=100;
					break;
				case 'D':
					fanhui=500;
					break;
				case 'M':
					fanhui=1000;
					break;
				default:
					return 0;				
			}
			return fanhui;
		}
		
		int Calculate(int left,int right,int result){
			if(left>=right)
					return result+right;
			else
				return result+right-2*left;
		}
}
