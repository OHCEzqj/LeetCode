
public class LengthofLasWord {
	public int lengthOfLastWord(String s) {
        return s.trim().lastIndexOf(" ")>0? s.trim().length()-s.trim().lastIndexOf(" ")-1: s.length();
    }

}
