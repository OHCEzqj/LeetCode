
public class LengthofLasWord {
	public int lengthOfLastWord(String s) {
        return s.lastIndexOf(" ")>0? s.length()-s.lastIndexOf(" ")-1: s.length();
    }

}
