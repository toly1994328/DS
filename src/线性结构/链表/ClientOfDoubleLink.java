package 线性结构.链表;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/18 0018:23:46
 * 邮箱：1981462002@qq.com
 * 说明：双链表测试
 */
public class ClientOfDoubleLink {
    public static void main(String[] args) {
        DoubleLinkList<String> list = new DoubleLinkList<>();
        list.add("张");
        list.add("捷");

        list.add(1,"风");//添加
        list.add(2,"特");
        list.remove(3);//移除
        list.set(2,"火");//修改
        System.out.println(list.size());//大小----3
        System.out.println(list.isEmpty());//是否为空----false
        list.clear();//清空
        System.out.println(list.isEmpty());//true

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));//获取
        }
    }
}
