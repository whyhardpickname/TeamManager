package exception;

/**
 * {@code TeamOperationException}是一个开发团队操作的异常类。
 *
 * <p>该类主要作为异常父类。
 *
 * @author MarkChern
 */
//TODO 测试
public class TeamOperationException extends Exception
{
    public TeamOperationException()
    {
    }

    public TeamOperationException(String message)
    {
        super(message);
    }
}
