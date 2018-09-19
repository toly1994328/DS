package client;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/19 0019:8:59
 * 邮箱：1981462002@qq.com
 * 说明：数组测试
 */
public class ClientOfArray {

    public static void main(String[] args) {
        //生成数组--方式1
        int[] id = new int[5];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

        //生成数组--方式2
        String[] name = new String[]{"张", "风", "捷", "特", "烈"};
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i]);//张风捷特烈
        }
        //增强for循环
        for (String str : name) {
            System.out.print(str);//张风捷特烈
        }

        System.out.println(sum(id));
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum *= 2;
        }
        return sum;
    }
}
