# String

[657. Judge Route Circle](#657-judge-route-circle)

[344. Reverse String](#344-reverse-string)

[541. Reverse String II](#541-reverse-string-ii)

[345. Reverse Vowels of a String](#345-reverse-vowels-of-a-string)

[67. Add binary](#67-add-binary)

[13. Roman to Integer](#13-roman-to-integer)

[58. Length of Last Word](#58-length-of-last-word)

[ceshi](#1-ceshi)


## 657. Judge Route Circle

- Description

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to **the original place**.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are `R` (Right), `L`(Left), `U` (Up) and `D` (down). The output should be true or false representing whether the robot makes a circle.

**Example 1:**

```
Input: "UD"
Output: true
```

**Example 2:**

```
Input: "LL"
Output: false
```

- Solution

```java
class Solution {
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
	        if(zong==0&&heng==0){
	        	return true;
	        }else{
	        	return false;
	        }
	    }
	
    
}
```

- 将string转为char数组，之后使用char数组进行判断

## 344. Reverse String

- Description

Write a function that takes a string as input and returns the string reversed.

**Example:**
Given s = "hello", return "olleh".

- Solution

```java
class Solution {
    public String reverseString(String s) {
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
    }
}
```

##  541. Reverse String II

- Description

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

**Example:**

```
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

```

Restrictions:

1. The string consists of lower English letters only.
2. Length of the given string and k will in the range [1, 10000]

```java
class Solution {
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
```

improve

```java
class Solution {
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
```

##  345. Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.

**Example 1:**
Given s = "hello", return "holle".

**Example 2:**
Given s = "leetcode", return "leotcede".

**Note:**
The vowels does not include the letter "y".

```java
class Solution {
    public String reverseVowels(String s) {
       char[] chars=s.toCharArray();
        String point="aeiouAEIOU";
        int l=s.length()-1;
        int i=0;
        char temp;
        
        for(;i<l;i++){
        	if(point.contains(chars[i]+"")){//扫描到前面的元音字母
        		System.out.println(chars[i]);
        		for(;l>i;l--){
        			if(point.contains(chars[l]+"")){//扫描到后面的，交换
        				System.out.println(chars[l]);
        				temp=chars[i];
        				chars[i]=chars[l];
        				chars[l]=temp;	
        				l--;
        				break;//交换结束，退出l遍历循环
        			}
        		}
        	}
        }
        
		return new String(chars);
    }
}
```

improve

```java
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
```

## 67. Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = `"11"`
b = `"1"`
Return `"100"`.

```java
class Solution {
    public String addBinary(String a, String b) {
		int x=BinaryToDecimal(a);
		int y=BinaryToDecimal(b);
		return Integer.toBinaryString(x+y);
        
		}
	public int BinaryToDecimal(String s){
		char[] chars=s.toCharArray();
		int length=s.length();
		int result = 0;
		for(int i=0;i<length;i++){
			result+=(chars[i]-48)*Math.pow(2, length-i-1);
		}
		return result;
	}
}
```

二进制过长，如111111111111000001101010，则超过运算限制。

improve:

```java

public class AddBinary {
	public String addBinary(String a, String b) {		
		
		char[] ca=a.toCharArray();
		char[] cb=b.toCharArray();
		int la=a.length()-1;
		int lb=b.length()-1;
		int add=0;
		StringBuilder sb=new StringBuilder();
		while(la>=0||lb>=0||add==1){
			//从最小为开始，进行每次运算
			int ta= (la)<0? 0:ca[la--] -'0';
			int tb= (lb)<0? 0:cb[lb--] -'0';
			//取余为新位
			sb.insert(0, (ta+tb+add)%2);
			add=(ta+tb+add)/2;
		}
		return sb.toString();
		}
}
```

## 13. Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

```java
class Solution {
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
```

## 58. Length of Last Word

Given a string *s* consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word in the string.

If the last word does not exist, return 0.

**Note:** A word is defined as a character sequence consists of non-space characters only.

**Example:**

```
Input: "Hello World"
Output: 5
```

```java
class Solution {
    public int lengthOfLastWord(String s) {
       return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
```

## 1. ceshi