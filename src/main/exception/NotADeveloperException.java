package exception;

import domain.employee.Employee;

/**
 * {@code NotADeveloperException}是团队操作异常类的子类，
 * 当尝试向团队添加非程序员类及其子类对象则抛出该异常类。
 * @author MarkChern
 */
//TODO 测试
public class NotADeveloperException extends TeamException
{
    public NotADeveloperException()
    {
    }

    /**
     * {@code NotADeveloperException}构造一个带信息的非开发者异常对象。
     * @param employee
     */
    public NotADeveloperException(Employee employee)
    {
        super(employee.getName() + "is not a developer and can't be added.");
    }
}
