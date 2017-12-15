/**
 * @author: zqj
 * @date 2017/12/15
 * @Description:
 */
/*
public class NumberofSegmentsinaString {
    public int countSegments(String s) {
        String ss=s.trim();
        //将原始的String去除开始与结束空格
        char[] chars=ss.toCharArray();
        int num=1;
        //该String都是空格
        if (chars.length==0)
            return 0;
        int st=0;
        int end;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' ') {
                end=i;
                String substring=ss.substring( st,end ).trim();
                if(substring.length()>0)
                    num++;
                st=i+1;
            }
        }
     return  num;
    }
}
*/
// 优化
public class NumberofSegmentsinaString {
    public int countSegments(String s) {
        return  s.trim().length()==0? 0:s.trim().split( "\\s+"  ).length;
    }
}
