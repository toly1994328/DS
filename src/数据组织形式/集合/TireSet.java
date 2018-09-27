package 数据组织形式.集合;

import base.ISet;
import 树结构.字典数.Tire;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/25 0025:9:39
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class TireSet implements ISet<String> {
    private Tire mTire;

    public TireSet() {
        mTire = new Tire();
    }

    @Override
    public void add(String el) {
        mTire.add(el);
    }

    @Override
    public void remove(String el) {

    }

    @Override
    public boolean contains(String el) {
        mTire.contains(el);
        return false;
    }

    @Override
    public int size() {
        return mTire.size();
    }

    @Override
    public boolean isEmpty() {
        return mTire.isEmpty();
    }
}
