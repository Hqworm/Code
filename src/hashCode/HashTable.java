package hashCode;

import java.util.TreeMap;
//O(N/M)
/*
  在 public class RBTree< K extends Comparable<K,V>>{}因必须具有可比较性所以要比较
 */
public class HashTable<K,V> {
    //在java 中 object实现了hashcode()方法  所以对k不需操作   需要特别操作则进行覆盖
    private TreeMap<K, V>[] hashTable;//
    private int M;//hashTable的长度，一个合适的素数
    private int size;//hashtable存储的变量的个数

    private static final int upperTol=10;//冲突最大容忍度
    private static final int lowerTol=2;
   // private static final int initCapacity=7;//初始化容量
    private   int capacityIndex=0;//
    //因为简单的M*2，M/2之后 数组大小不再是一个素数，可能导致hash值分布不均匀的问题，所以---
    private static final int[] capacity=
            {53,97,193,389,769,1543,3079,6151,12289,24593,
            49157,98317,196613,393241,786433,1572869,3145739,6291469,
            12382917,25165843,50331653,100663319,201326611,402653189,805306457,1610612714
            };

    public HashTable() {
        this.M = capacity[capacityIndex];
        this.size = 0;
        hashTable = new TreeMap[M];//只算是开辟了空间，但是每一个都没有实例化
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

/*
    public HashTable() {//当用户不知道该传入多大的空间时，可以给一个值
        this(initCapacity);
    }
*/

    private int hash(K key) {
        //key.hashCode() --可以把任意的key的类型转化成一个整型
        //& 0X7fffffff-- 消除key.hashCode()所对应的符号 把它弄成整数
        //  %M  m--合适的素数 初步解决冲突
        return (key.hashCode() & 0X7fffffff) % M;//把当前的key对应到当前的hashtable表的对应的索引的值

    }

    public int getSize() {
        return size;
    }

    /**
     * 添加一个元素
     * @param key   键
     * @param value  值
     */
    public void add(K key,V value){
        /*
        hashTable[hash(key)]  key在 hashTable中对应的一个索引的那个treemap
        hashTable[hash(key)].containsKey(key)
         */
        //hash(key)重复了多次
        /*if(hashTable[hash(key)].containsKey(key)){
            hashTable[hash(key)].put(key,value);//如果包含  将现在的hash（key）的位置的treemap值修改
        }else{
            hashTable[hash(key)].put(key,value);//如果没有，就直接添加
            size ++;
        }*/

        //改进后....
        TreeMap<K,V> map=hashTable[hash(key)];
        if(map.containsKey(key)){
            map.put(key,value);
        }else{
            map.put(key,value);
            size ++;
            /*if(size>=upperTol*M){//N/M=upperTol --  N==size  = M* upperTol
                resize(2*M);
            }*/
            if(size>=upperTol*M && capacityIndex+1<capacity.length){
                capacityIndex++;
                resize(capacity[capacityIndex]);

            }
        }


    }

    /**
     * 通过key来删除
     * @param key
     * @return ret 是删除的value
     */
    public V remove(K key){
        TreeMap<K,V> map=hashTable[hash(key)];
        V ret=null;
        if(map.containsKey(key)){//删除
            ret=map.remove(map);
            size--;
            /*if(size<lowerTol*M && M/2>=initCapacity){
                resize(M/2);
            }*/
            //改进之后
            if(size<lowerTol*M && capacityIndex-1>=0){
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;

    }

    /**
     * 修改
     * 通过key来修改 value的值
     * @param key
     * @param value
     */
    public void set(K key, V value){
        TreeMap<K,V> map=hashTable[hash(key)];
        if(!map.containsKey(key)){
            //如果要修改的不存在 则抛出异常
            throw new IllegalArgumentException(key+"  doesn't exist !");
        }
        map.put(key,value);
    }

    /**
     * 通过key 查找 看hashtable是否存在
     * @param key
     * @return
     */
    public boolean contains(K key){
        return hashTable[hash(key)].containsKey(key);
    }

    /**
     *通过 key 查找 其 value 值
     * @param key
     * @return
     */
    public V get(K key){
        return hashTable[hash(key)].get(key);
    }


    //hash 表的动态空间处理  如果平均每个地址承载的元素多过一定程度时，就扩容。 N/M>upperTol(容忍度)
    /*
      新开辟一个空间，现在的内容装进去--均摊 O(1)
     */

    //如果平均每个地址承载的元素小于一定程度时，就缩容。 N/M<lowerTol(容忍度)


    private void resize(int newM){
        TreeMap<K,V>[]newHashTable=new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i]=new TreeMap<>();
        }

        //把原来的数据放入新的 newHashTable中
        int oldM=M;
        this.M=newM;
        for (int i = 0; i <oldM ; i++) {//遍历吧hashTable中的数据 放入 NewHashTable
            TreeMap<K,V>map=hashTable[i];
            for (K key : map.keySet()) {//处理某个数组下标中的每一个元素
                newHashTable[hash(key)].put(key,map.get(key));//因为hash()函数中，是根据M类计算呢的，所以要将M的值转化成NewM
            }
        }

    }


    /**
     * hash表 均复杂度O(1) 但丢失了顺序性
     * 但是 二分搜索树 有顺序性，可以非常快的排序，最大值最小值
     * 既有集合，映射---底层链表、数，hash表
     * 有序集合，有序映射---平衡树结构  treeMap treeSet
     * 无序集合，无序映射：hashMap hashSet
     */


}
