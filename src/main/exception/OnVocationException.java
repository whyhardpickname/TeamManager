package exception;

import domain.employee.Employee;

/**
 * {@code NotADeveloperException}是团队操作异常类的子类，
 * 当尝试向团队添加正在休假的程序员类及其子类对象则抛出该异常类。
 * @author MarkChern
 */
//TODO 测试
public class OnVocationException extends TeamException
{
    public OnVocationException()
    {
    }

    /**
     * {@code NotADeveloperException}构造一个带信息的已经是开发者的异常对象。
     * @param employee
     */
    public OnVocationException(Employee employee)
    {
        super(employee.getName() + "is on vocation and can't be added.");
    }
}
