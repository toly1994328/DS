package Jutils.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/5 0005:22:05
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class DeepClone<T> {
    public T deepClone() {//将对象写到流里
        ObjectInputStream oi = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);//从流里读出来
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            oi = new ObjectInputStream(bi);
            return (T) oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
