package domain.employee;

import java.util.Objects;

/**
 * 雇员类{@code Employee}是用来创建具有身份证明(ID),姓名，年龄和薪水的公司雇员。
 *
 * <p>雇员类主要作为父类，创建程序员，设计师和架构师子类。
 *
 * @author MarkChern
 */
public class Employee
{
    /**身份证*/
    private int id;
    /**姓名*/
    private String name;
    /**年龄*/
    private int age;
    /**薪水*/
    private double salary;

    /**
     * 构造一个指定身份证明，姓名，年龄和薪水的雇员对象。
     *
     * @param id
     *      雇员的身份证
     * @param name
     *      雇员的名字
     * @param age
     *      雇员的年龄
     * @param salary
     *      雇员的薪水
     */
    public Employee(int id, String name, int age, double salary)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                getAge() == employee.getAge() &&
                Double.compare(employee.getSalary(), getSalary()) == 0 &&
                Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getName(), getAge(), getSalary());
    }
}
