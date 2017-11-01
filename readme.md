# String

[657. Judge Route Circle](#657-Judge-Route-Circle)

[344. Reverse String](#344-Reverse-String)

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

