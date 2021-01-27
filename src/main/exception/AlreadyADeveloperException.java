package exception;

import domain.employee.Employee;

/**
 * {@code NotADeveloperException}是团队操作异常类的子类，
 * 当尝试向团队添加已是程序员类及其子类对象则抛出该异常类。
 * @author MarkChern
 */
public class AlreadyADeveloperException extends TeamException
{
    public AlreadyADeveloperException()
    {
    }

    /**
     * {@code NotADeveloperException}构造一个带信息的已经是开发者的异常对象。
     * @param employee
     */
    public AlreadyADeveloperException(Employee employee)
    {
        super(employee.getName() + "is already a developer and can't be added.");
    }
}
