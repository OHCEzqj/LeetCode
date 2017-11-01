# String

[657. Judge Route Circle](#657-judge-route-circle)

[344. Reverse String](#344-reverse-string)

[541. Reverse String II](#541-reverse-string-ii)



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

