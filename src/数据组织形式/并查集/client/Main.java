package 数据组织形式.并查集.client;

import Jutils.TimeTest;
import base.IUF;
import 数据组织形式.并查集.*;

import java.util.Random;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/25 0025:12:15
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Main {
    public static void main(String[] args) {
        int opCount = 10000 * 1000;
        int size = 10000000;


        IUF quickFindUF = new QuickFindUF(size);
        IUF quickUnionUF = new QuickUnionUF(size);
        IUF quickUnion2UF = new QuickUnion2UF(size);
        IUF quickUnion3UF = new QuickUnion3UF(size);
        IUF quickUnion4UF = new QuickUnion4UF(size);
        IUF quickUnion5UF = new QuickUnion5UF(size);

//        testTime("快速查询",opCount, random, quickFindUF);
//        testTime("快速连接1",opCount, random, quickUnionUF);
//        testTime("快速连接优化",opCount, quickUnion2UF);
//        testTime("快速连接优化2",opCount, quickUnion3UF);
//        testTime("快速连接优化3", opCount, quickUnion4UF);
        testTime("快速连接优化4", opCount, quickUnion5UF);

    }

    private static void testTime(String name, int opCount, IUF iuf) {
        new TimeTest(name, 1) {
            @Override
            protected void run() {
                Random random = new Random();
                for (int i = 0; i < opCount; i++) {
                    int a = random.nextInt(iuf.size());
                    int b = random.nextInt(iuf.size());
                    iuf.unionEl(a, b);
                }
            }
        };
    }
}
