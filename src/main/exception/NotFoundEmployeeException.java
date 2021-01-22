package exception;

/**
 * {@code NotFoundEmployeeException}是当找不到指定员工时抛出的异常。
 * @author MarkChern
 */
public class NotFoundEmployeeException extends TeamException
{
    public NotFoundEmployeeException()
    {
        super("The specified employee " + "couldn't found.");
    }

    /**
     * {@code NotFoundEmployeeException}是在法找到对应员工时抛出的异常。
     */
    public NotFoundEmployeeException(int id)
    {
        super("The specified employee with ID " + id + " couldn't found.");
    }
}
