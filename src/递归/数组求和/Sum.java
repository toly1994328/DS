package 递归.数组求和;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/20 0020:16:56
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 递归函数
     * @param arr 数组
     * @param l 开始位置
     * @return 从开始位置到最后所有元素和
     */
    private static int sum(int[] arr,int l) {
        if (l == arr.length) {
            return 0;
        }

        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 2, 3, 4}));
    }
}
