package bean;

import java.util.Objects;

/**
 * 作者：张风捷特烈
 * 时间：2018/9/18 0018:19:58
 * 邮箱：1981462002@qq.com
 * 说明：
 */
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return String.format("Person(name: %s, age: %d)\n", name, age);
    }
}
