
>说说我对数据结构的理解吧：  
1---数据结构=数据+结构：  
2---说到结构，我第一反应就是生物的骨架，而数据则是附着在骨架上的躯体。  
3---躯体外显，骨架内隐，骨架的行为在躯体上表现。很符合数据与结构的关系。  
4---简而言之，我认为结构是数据的载体，数据是结构行为的体现  
5---血肉大同小异，但骨骼千差万别，有的灵巧娇小，有的笨重硕大，但各有千秋。

数据的组织方式，高效操作数据


```
线性结构
    数组
    栈
    队列
    链表

树结构
    二分搜索树
    堆
    线段树
    Tire
    
    并查集
    AVL
    红黑树
    哈希表

图结构
```

---


>由于使用不同的数据结构实现集合，集合的基本行为可以抽象成父类，来完成一些基本行为的规定。  
相当于为结构准备一个基本的躯壳。为了避免和Java内置集合重名，使用Group（群集）来命名。

##### Group类

```
定点添加        void add(int index, T el)
首添加          void add(T el)
尾添加          void addLast(T el)

定位删除        T remove(int index)
删除首          T removeFirst()
删除尾          T removeLast()
删除某元素      int removeEl(T el)
删除所有某元素  int[] removeEls(T el)
清空 clear      void clear()

修改 set        T set(int index, T el)

根据索引取元素  T get(int index)
根据元素取索引  int[] getIndex(T el)

是否包含元素    boolean contains(T el)
尾连接两集合    Group<T> contact(Group<T> group)
定点连接集合    Group<T> contact(int index,Group<T> group)
是否为空        boolean isEmpty() 
获取大小        int size()
```

```
/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:7:42
 * 邮箱：1981462002@qq.com
 * 说明：集合的基类
 */
public abstract class Group<T> {
    protected int size;

    /**
     * 定点添加
     *
     * @param index 索引
     * @param el  数据元素
     */
    public abstract void add(int index, T el);

    /**
     * 首添加
     *
     * @param el 数据元素
     */
    public void addFirst(T el) {
        add(0, el);
    }

    /**
     * 尾添加
     *
     * @param el 数据元素
     */
    public void addLast(T el) {
        add(size - 1, el);
    }

    /**
     * 定位删除
     *
     * @param index 索引
     * @return 删除的元素
     */
    public abstract T remove(int index);

    /**
     * 删除首位
     *
     * @return 删除的元素
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除尾位
     *
     * @return 删除的元素
     */
    public T removeLast() {
        return remove(size - 1);
    }


    /**
     * 删除指定元素的第一次出现时
     *
     * @param el 数据元素
     * @return 元素位置
     */
    public abstract int removeEl(T el);

    /**
     * 删除所有指定元素
     *
     * @param el 数据元素
     * @return 元素位置数组
     */
    public abstract int[] removeEls(T el);

    /**
     * 设置某位置的元素新值
     *
     * @param index 索引
     * @param el  新值
     * @return 旧值
     */
    public abstract T set(int index, T el);

    /**
     * 根据指定位置获取元素
     *
     * @param index 索引
     * @return 数据元素
     */
    public abstract T get(int index);


    /**
     * 根据指定元素获取匹配索引
     *
     * @param el 数据元素
     * @return 索引集
     */
    public abstract int[] getIndex(T el);

    /**
     * 集合是否包含某元素
     * @param el 数据元素
     * @return 是否包含
     */
    public abstract boolean contains(T el);

    /**
     * 连接两个集合
     * @param group 插入集合
     * @return 合并后的集合
     */
    public Group<T> contact(Group<T> group){
        return contact(size - 1, group);
    }

    /**
     * 定点链接两个集合
     * @param index 索引
     * @param group 插入集合
     * @return 合并后的集合
     */
    public abstract Group<T> contact(int index,Group<T> group);

    /**
     * 是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回集合大小
     * @return 大小
     */
    public int size() {
        return size;
    }
}
```
