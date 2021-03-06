package exception;

import service.TeamService;

/**
 * {@code NotADeveloperException}是团队异常类的子类，
 * 当尝试向团队添加超过对象人数限制的成员则抛出该异常类。
 * @author MarkChern
 */
public class OutOfNumberException extends TeamException
{

    public OutOfNumberException()
    {
    }


    public OutOfNumberException(String message)
    {
        super(message);
    }

    /**
     * {@code OutOfNumberException}构造一个带人数信息超标的异常对象。
     * @param team
     *      开发团队
     */
    public OutOfNumberException(TeamService team)
    {
        super("the team is Out of number " + team.getMaxMember());
    }
}
