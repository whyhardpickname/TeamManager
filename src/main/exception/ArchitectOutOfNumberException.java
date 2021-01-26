package exception;

import domain.employee.Architect;
import domain.employee.Designer;
import service.TeamService;

/**
 * {@code NotADeveloperException}是团队异常类的子类，
 * 当尝试向团队添加超过对象人数限制的成员则抛出该异常类。
 * @author MarkChern
 */
public class ArchitectOutOfNumberException extends OutOfNumberException
{

    public ArchitectOutOfNumberException()
    {
    }


    /**
     * {@code OutOfNumberException}构造一个带人数信息超标的异常对象。
     * @param team
     *      开发团队
     */
    public ArchitectOutOfNumberException(TeamService team)
    {
        super(Architect.class.getName() + "'s is out fo number " + team.getMaxArchitect());
    }
}
