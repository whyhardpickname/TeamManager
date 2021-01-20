package exception;

/**
 * {@code TeamFulledException}是团队操作异常类的子类，
 * 当尝试向满员的团队添加团员则抛出该异常类。
 *
 * @author MarkChern
 */
//TODO 测试
public class TeamFullException extends TeamException
{
    /** 开发团队成员人数*/
    private int members;

    public TeamFullException()
    {
    }

    /**
     * {@code} TeamFulledException 构造一个带字符串信息的成员已满异常对象。
     * @param members
     */
    public TeamFullException(int members)
    {
        super("The team is full and can't be added.");
        this.members = members;
    }
}
