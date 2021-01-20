package exception;

/**
 * {@code NotFoundEmployeeException}是当找不到指定员工时抛出的异常。
 * @author MarkChern
 */
public class NotFoundEmployeeException extends TeamException
{
    /*指定员工id*/
    private int id;

    public NotFoundEmployeeException()
    {

    }

    /**
     * {@code NotFoundEmployeeException}是在指定id无法找到对应员工时抛出的异常。
     * @param id
     *      指定员工id
     */
    public NotFoundEmployeeException(int id)
    {
        super("The specified employee could not be found.");
        this.id = id;
    }
}
