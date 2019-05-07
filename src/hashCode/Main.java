package hashCode;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    /**
     * equals 也要进行重写
     * @param args
     */
    public static void main(String[] args) {
        int a=42;
        System.out.println(((Integer)a).hashCode());
        int b=-42;
        System.out.println(((Integer)b).hashCode());

        double c=3.1415926;
        System.out.println(((Double)c).hashCode());

        String d="hq";
        System.out.println(d.hashCode());

        Student student=new Student(3,2,"BoBo","B");

        System.out.println(student.hashCode());

        HashSet<Student> set=new HashSet<>();
        set.add(student);


        HashMap<Student,Integer> map=new HashMap();

        map.put(student,100);

        //对于每一个Object有一个默认的hashCode()的实现，如果没有重写hashCode()
        // 则会默认去调用默认的hashCode(),这个是根据他们的创建对象的地址来进行映映射成整形，因此不一样。但是自己写了hashCode（）就一样







    }
}
