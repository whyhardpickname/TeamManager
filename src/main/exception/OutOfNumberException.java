package exception;

import domain.employee.Employee;

/**
 * {@code NotADeveloperException}是团队异常类的子类，
 * 当尝试向团队添加超过对象人数限制的成员则抛出该异常类。
 * @author MarkChern
 */
//TODO 测试
public class OutOfNumberException extends TeamException
{
    public OutOfNumberException()
    {
    }

    /**
     * {@code NotADeveloperException}构造一个带信息的已经是开发者的异常对象。
     * @param employee
     */
    public OutOfNumberException(Employee employee)
    {
        super(employee.getName() + "is already a developer and can't be added.");
    }
}
