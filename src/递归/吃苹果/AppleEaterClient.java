package 递归.吃苹果;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/20 0020:16:45
 * 邮箱：1981462002@qq.com
 * 说明：一个简单的吃苹果递归
 */
public class AppleEaterClient {
    public static void main(String[] args) {
        Apple apple = new Apple(5);
        eat(apple);
        //苹果还剩4口
        //苹果还剩3口
        //苹果还剩2口
        //苹果还剩1口
        //苹果还剩0口
        //苹果吃完了
    }

    private static void eat(Apple apple) {
        if (apple.size <= 0) {
            System.out.println("苹果吃完了");
            return;
        }
        apple.size = apple.size - 1;
        System.out.println("苹果还剩" + apple.size + "口");
        eat(apple);

    }

    private static class Apple {
        public int size;
        public Apple(int size) {
            this.size = size;
        }
    }
}
