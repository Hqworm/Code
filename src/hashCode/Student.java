package hashCode;
/*
解决hash冲突的处理方法之一：链地址法
 */
public class Student {
    int grade;
    int cls;
    String firstName;
    String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {//返回的值为int int有符号 所以在后面可能会有负数出现
        int B=31;
        int hash=0;//复合的类型，把每一个成员变量看作一个数--可以把他转成一个整型。
        hash=hash*B+grade;
        hash=hash*B+cls;
        hash=hash*B+firstName.toLowerCase().hashCode();//这样字符就可以不区分大小写了

        hash=hash*B+lastName.toLowerCase().hashCode();

       // 可能会产生整型的溢出 会根据语言对于溢出的处理会得到一个整形的结果，虽然数字不正确，但是并不影响。
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        Student otherStudent=(Student)obj;
        return this.grade==otherStudent.grade&& this.cls==otherStudent.cls&&this.firstName.equals(otherStudent.firstName)&&this.lastName.equals(otherStudent.lastName);
        //  把 obj强制转换称 student的对象 ，，然后才进行每个成员变量进行比较。

    }
}
