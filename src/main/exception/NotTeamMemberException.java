package exception;

/**
 * {@code NotFoundEmployeeException}是当找不到指定成员时抛出的异常。
 * @author MarkChern
 */
public class NotTeamMemberException extends TeamException
{
    public NotTeamMemberException()
    {
        super("The specified teammate " + "couldn't found.");
    }

    /**
     * {@code NotFoundEmployeeException}是在法找到对应成员时抛出的异常。
     */
    public NotTeamMemberException(int id)
    {
        super("The specified teammate with ID " + id + " couldn't found.");
    }
}
