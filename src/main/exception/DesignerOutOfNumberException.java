package exception;

import domain.employee.Designer;
import domain.employee.Programmer;
import service.TeamService;

/**
 * {@code NotADeveloperException}是团队异常类的子类，
 * 当尝试向团队添加超过对象人数限制的成员则抛出该异常类。
 * @author MarkChern
 */
public class DesignerOutOfNumberException extends OutOfNumberException
{

    public DesignerOutOfNumberException()
    {
    }


    /**
     * {@code OutOfNumberException}构造一个带人数信息超标的异常对象。
     * @param team
     *      开发团队
     */
    public DesignerOutOfNumberException(TeamService team)
    {
        super(Designer.class.getName() + "'s is out fo number " + team.getMaxDesigner());
    }
}
