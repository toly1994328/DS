package 线性结构.链表;

/**
 * 作者：张风捷特烈
 * 时间：2018/8/17 0017:16:51
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Client {
    public static void main(String[] args) {

        Linked<String> train = new Linked<>();

        train.addFirst("3点");
        train.addFirst("2点");
        train.addLast("5点");
        train.addLast("6点");
        train.add(2,"4点");



        System.out.println(train);
        System.out.println(train.get(3));
        System.out.println(train.getFirst());
        System.out.println(train.getLast());
        System.out.println(train.contains("6点"));
        System.out.println(train.contains("7点"));

//        train.remove(3);
//        train.remove(1);
//        train.remove(0);

        train.set(1, "100点");
        System.out.println(train);


    }
}
