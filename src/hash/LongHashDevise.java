package hash;
/*
hash设置的三个原则：
                1.一致性 如果a==b 则 hash(a)==hash(b)  但hash值相同的key值可以不同。
                 2.高效性：计算的高效
                 均匀性：哈希值均匀分布（可以去mode一个素数可以简单的达到）
                 */



public class LongHashDevise {
    //比如省份证号  具体问题具体分析
    //一般会取模  解决分布不均匀-->简单的解决办法模一个素数
    //素数的选择，，可以根据自己的数据的规模，来进行素数选择--网上自己搜索



    /*
    键为浮点数：
    在计算机中，都用二进制表示，只不过计算机解析成了浮点数
    ---转成整型1来进行 处理
     */

    /**
     * 字符串 暂用空间的数量不一定
     * --转成整型来进行处理每一个字符就看做一个数字
     *  code=c*26*26*26+o*26*26+d*26*1+e
     * 可以把一个字符串看做成B进制一个大的整型
     * 可以把取模的过程放在里面--可以避免整型溢出
     */


    /**
     * 复合型---常用方法之一转成整形去设计
     */
}

