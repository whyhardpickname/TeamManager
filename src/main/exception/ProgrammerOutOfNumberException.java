package exception;

import domain.employee.Programmer;
import service.TeamService;

/**
 * {@code NotADeveloperException}是团队异常类的子类，
 * 当尝试向团队添加超过对象人数限制的成员则抛出该异常类。
 * @author MarkChern
 */
public class ProgrammerOutOfNumberException extends OutOfNumberException
{

    public ProgrammerOutOfNumberException()
    {
    }


    /**
     * {@code OutOfNumberException}构造一个带人数信息超标的异常对象。
     * @param team
     *      开发团队
     */
    public ProgrammerOutOfNumberException(TeamService team)
    {
        super(Programmer.class.getName() + "'s is out fo number " + team.getMaxProgrammer());
    }
}
