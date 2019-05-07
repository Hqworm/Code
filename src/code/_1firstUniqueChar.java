package code;


import java.io.Serializable;

/*
找出字符串中第一个不重复的字符，且字符串为小写的a~z
 */
public class _1firstUniqueChar implements Serializable {

    private static final long serialVersionUID = -249838819828293756L;//在类上alt+回车
    private int id;
    private String name;

    public _1firstUniqueChar(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public _1firstUniqueChar(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public _1firstUniqueChar() {
    }

    public static int firstUniqueChar(String str){
        int [] frequency=new int[26];
        for(int i=0;i< str.length();i++){
            frequency[str.charAt(i)-'a']++;//0~25 26个字符的频率存进了26数组长度中
        }

         for(int i=0;i<str.length();i++){
             if(frequency[str.charAt(i)-'a']==1){
                 return i;
             }
         }

        return -1;

    }

    public static void main(String[] args) {//psvm回车
        System.out.println();//sout回车
        for (int i = 0; i <10 ; i++) {//fori 回车
            System.out.println(i);
        }
        System.out.println("=======");
        String []arr={"aaa","bbb","ccc"};
        for(String index:arr){//增强for循环
            System.out.println(index);
        }
        for (String s : arr) {// arr.for   回车

        }



        try {//ctrl+alt+t  选中一些行 在 ctrl+alt+t 回车可以生成很多流程控制语句if ...
            System.out.println("========");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


        //快捷键 psvm .for  fori  sout
        // ctrl+alt+t 可以快捷输出流程控制语句
        /*

         */
        // alt+inserti 可以生成构造函数 get set,toString(),Override..,equals函数 在按住shift+左键进行点击---可以勾选想生成的get set 以及 构造函数


    }

}
