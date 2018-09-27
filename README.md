
>说说我对数据结构的理解吧：  
1---数据结构=数据+结构：  
2---说到结构，我第一反应就是生物的骨架，而数据则是附着在骨架上的躯体。  
3---躯体外显，骨架内隐，骨架的行为在躯体上表现。很符合数据与结构的关系。  
4---简而言之，我认为结构是数据的载体，数据是结构行为的体现  
5---血肉大同小异，但骨骼千差万别，有的灵巧娇小，有的笨重硕大，但各有千秋。

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


>由于使用不同的数据结构实现容器，容器的基本行为可以抽象成父类，来完成一些基本行为的规定。  
相当于为结构准备一个基本的躯壳。为了避免和Java内置容器重名，使用Group（群集）来命名。

##### Group类

```
定点添加        void add(int index, T el)
首添加          void addFirst(T el)
尾添加          void addLast(T el)

定位删除        T remove(int index)
删除首          T removeFirst()
删除尾          T removeLast()
删除某元素      int removeEl(T el)
删除所有某元素  boolean removeEls(T el)
清空 clear      void clear()

修改 set        T set(int index, T el)

根据索引取元素  T get(int index)
根据元素取索引  int[] getIndex(T el)

是否包含元素    boolean contains(T el)
尾连接两容器    Group<T> contact(Group<T> abstractChart)
定点连接容器    Group<T> contact(int index,Group<T> abstractChart)
是否为空        boolean isEmpty() 
获取大小        int size()
```

```
/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:7:42
 * 邮箱：1981462002@qq.com
 * 说明：容器的基类
 */
public abstract class Group<T> {
    protected int size;

    /**
     * 定点添加
     *
     * @param index 索引
     * @param el    数据元素
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
    public int removeEl(T el) {
        int[] indexes = getIndex(el);
        int index = -1;
        if (indexes.length > 0) {
            index = indexes[0];
            remove(indexes[0]);
        }
        return index;
    }

    /**
     * 删除所有指定元素
     *
     * @param el 数据元素
     */
    public boolean removeEls(T el) {

        int[] indexArray = getIndex(el);
        if (indexArray.length != 0) {
            for (int i = 0; i < indexArray.length; i++) {
                remove(indexArray[i] - i); // 注意-i
            }
            return true;
        }
        return false;
    }

    /**
     * 清空容器
     */
    public abstract void clear();

    /**
     * 设置某位置的元素新值
     *
     * @param index 索引
     * @param el    新值
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
     * 容器是否包含某元素
     *
     * @param el 数据元素
     * @return 是否包含
     */
    public boolean contains(T el) {
        return getIndex(el).length != 0;
    }

    /**
     * 连接两个容器
     *
     * @param abstractChart 插入容器
     * @return 合并后的容器
     */
    public Group<T> contact(Group<T> abstractChart) {
        return contact(size-1, abstractChart);
    }

    /**
     * 定点连接两个容器
     *
     * @param index 索引
     * @param abstractChart 插入容器
     * @return 合并后的容器
     */
    public abstract Group<T> contact(int index, Group<T> abstractChart);

    /**
     * 是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回容器大小
     *
     * @return 大小
     */
    public int size() {
        return size;
    }
}
```
---


#### 后记、
##### 1.声明：
>[1]本文由张风捷特烈原创,各图均由本人亲自所画，转载请注明  
[2]欢迎广大编程爱好者共同交流  
[3]个人能力有限，如有不正之处欢迎大家批评指证，必定虚心改正  
[4]你的喜欢与支持将是我最大的动力 

##### 2.连接传送门：
[更多数据结构知识欢迎访问:图解数据结构](https://www.jianshu.com/nb/29579097)  
[项目源码均在我的https://github.com/toly1994328/DS：欢迎star](https://github.com/toly1994328/DS)  
[张风捷特烈个人网站，编程笔记请访问：](http://www.toly1994.com)http://www.toly1994.com   



##### 3.联系我
>QQ:1981462002   
邮箱：1981462002@qq.com  
微信：zdl1994328  

##### 4.欢迎关注我的微信公众号，最新精彩文章，及时送达：  
![公众号.jpg](https://upload-images.jianshu.io/upload_images/9414344-c474349cd3bd4b82.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
