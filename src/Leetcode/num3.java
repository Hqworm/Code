package Leetcode;

public class num3 {
    public static void main(String[] args) {
        num3 n=new num3();

        System.out.println(n.lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        //
        int len=1;
        if(s.length()<=1){
            return s.length();
        }else{
            for(int i=0;i<s.length()-1;i++){
                for(int j=i+1;j<s.length();j++){
                    if(s.substring(i,j).contains(s.substring(j,j+1))){//如果重复
                        if(j-i-1>len){//如果此时的子串长度大于之前长度 则进行替换  否则不管
                            len=j-i-1;
                        }
                        break;

                    }else{
                       if( len<=j-i+1){
                        len=j-i+1;
                    }
                }

                }
            }
        }

        return len;
    }
}
