package 数据组织形式.hashcode;

import bean.Person;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/27 0027:12:35
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class ClientOfHashCode {
    public static void main(String[] args) {
        Integer a = 49;
        Integer b = -49;
        System.out.println(a.hashCode());//49
        System.out.println(b.hashCode());//-49

        Float c = 3.14f;
        System.out.println(c.hashCode());//1078523331

        String toly = "toly";
        System.out.println(toly.hashCode());//3565896

        Person toly1 = new Person(toly, 24);
        Person toly2 = new Person(toly, 24);
        //默认哈希函数:取地址值
//        System.out.println(toly1.hashCode()); //1929600551
//        System.out.println(toly2.hashCode()); //1690716179
        //复写哈希函数后：
        System.out.println(toly1.hashCode());//修改后哈希函数：110543761
        System.out.println(toly2.hashCode());//修改后哈希函数：110543761

        Person lsP = new Person("lsP", 24);

        HashSet<Person> set = new HashSet<>();
        set.add(toly1);

        HashMap<Person, Integer> map = new HashMap<>();
        map.put(toly1, 1);




    }
}
