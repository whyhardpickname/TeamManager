package service;

import domain.employee.Architect;
import domain.employee.Designer;
import domain.employee.Employee;
import domain.employee.Programmer;
import exception.*;

/**
 * {@code TeamService}用来创建和管理开发团队成员。
 *
 * <p>开发团队成员包括架构师，设计师和程序员。
 * 开发团队的人员组成要求是
 * - 最多一名架构师
 * - 最多两名设计师
 * - 最多三名程序员
 *
 * @author MarkChern
 */
public class TeamService
{
    /** 用来为开发团队新增成员自动生成团队中的唯一ID */
    private int counter = 1;
    /** 开发人员最大人数*/
    private final int maxMember = 5;
    /** 程序员最大人数*/
    private final int maxProgrammer = 3;
    /** 设计师最大人数*/
    private final int maxDesigner = 2;
    /** 架构师最大人数*/
    private final int maxArchitect = 1;
    /** 程序员当前人数*/
    private int programmers = 0;
    /** 设计师当前人数*/
    private int designers = 0;
    /** 架构师当前人数*/
    private int architects = 0;
    /** 团队当前人数 */
    private int members = 0;
    /** team数组用来保存当前团队中的各成员对象 */
    private Programmer[] team = new Programmer[maxMember];

    /**
     * {@code TeamService}构造开发团队的对象，并初始化开发团队成员。
     */
    public TeamService() {
    }

    /**
     * {@code getTeam}返回当前团队的所有对象
     * @return
     *      包含所有成员对象的数组，数组大小与成员人数一致
     */
    public Programmer[] getTeam()
    {
        return team;
    }

    /**
     * {@code}方法向团队添加成员
     * @param employee
     *      添加对象
     */
    public void addMember(Employee employee) throws TeamException {
        /**
         * 1.先检查团队是否已满，是的话抛出异常
         * 2.再检查实际类型对应人数是否已满，是的话抛出异常
         * 2.1 方法getClass, equals
         * 3.查看加入对象的状态是否处于空闲，是的话抛出异常
         * 4.再查看对象是否已加入团队，是的话抛出异常
         * 5.以上皆是，赋予对象新成员id，修改状态，更新id生成变量
         */
//        1.先检查团队是否已满，是的话抛出异常
        if (members >= maxMember) {
            throw new OutOfNumberException();
        }

//        2.再检查实际类型对应人数是否已满，是的话抛出异常,不是添加成员
        if (!employee.getClass().equals(Programmer.class)) {
            throw new NotADeveloperException();
        }
        Programmer programmer = (Programmer) employee;
        if (programmer.getStatus() == Status.VOCATION) {
            throw new OnVocationException();
        }
        else if (programmer.getStatus() == Status.BUSY) {
            throw new AlreadyADeveloperException();
        }

        if (employee.getClass().equals(Programmer.class)) {
            if (programmers >= maxProgrammer) {
                throw new ProgrammerOutOfNumberException();
            }
        }
        /*if (employee.getClass().equals(Programmer.class))
        {
            if (programmers >= maxProgrammer) {
                throw new ProgrammerOutOfNumberException();
            }
            else {
                Programmer programmer = (Programmer) employee;
                if (programmer.getStatus() == Status.VOCATION) {
                    throw new OnVocationException();
                }
                else if (programmer.getStatus() == Status.BUSY) {
                    throw new AlreadyADeveloperException();
                }

                team[members++] = programmer;
                programmers++;
                programmer.setStatus(Status.BUSY);
                programmer.setMemberID(counter++);
            }
        }
        else if (employee.getClass().equals(Designer.class)) {
            if (designers >= maxDesigner) {
                throw new DesignerOutOfNumberException();
            }
            else {
                Designer designer = (Designer) employee;
                if (designer.getStatus() == Status.VOCATION)
                {
                    throw new OnVocationException();
                } else if (designer.getStatus() == Status.BUSY)
                {
                    throw new AlreadyADeveloperException();
                }

                team[members++] = designer;
                designers++;
                designer.setStatus(Status.BUSY);
                designer.setMemberID(counter++);
            }
        }
        else if (employee.getClass().equals(Architect.class))
        {
            if (architects >= maxArchitect) {
                throw new ArchitectOutOfNumberException();
            }
            else {
                Architect architect = (Architect) employee;
                if (architect.getStatus() == Status.VOCATION) {
                    throw new OnVocationException();
                }
                else if (architect.getStatus() == Status.BUSY) {
                    throw new AlreadyADeveloperException();
                }

                team[members++] = architect;
                architects++;
                architect.setStatus(Status.BUSY);
                architect.setMemberID(counter++);
            }
        }
        else {
            throw new NotADeveloperException();
        }
    }*/

    /**
     * {removeMember}方法从团队中删除成员
     * @param memberId
     *      删除对象的成员ID
     */
    public void removeMember(int memberId) throws NotTeamMemberException
    {
        /**
         * 1.找到对应id成员
         * 2.从找到处开始依次用后面成员覆盖前面成员
         * 3.修改被删成员状态
         * 4.更新各类型成员人数。
         */
        for (int i = 0; i < members; i++)
        {
            if (team[i].getMemberID() == memberId)
            {
                team[i].setMemberID(-1);
                team[i].setStatus(Status.FREE);
                if (team[i].getClass().equals(Programmer.class))
                {
                    programmers--;
                }
                else if (team[i].getClass().equals(Designer.class))
                {
                    designers--;
                }
                else if (team[i].getClass().equals(Architect.class))
                {
                    architects--;
                }
                for (int j = i + 1; j < members; j++)
                {
                    team[j - 1] = team[j];
                }
                members--;
                return;
            }
        }
        throw new NotTeamMemberException();
    }

    public int getMaxMember()
    {
        return maxMember;
    }

    public int getMaxProgrammer()
    {
        return maxProgrammer;
    }

    public int getMaxDesigner()
    {
        return maxDesigner;
    }

    public int getMaxArchitect()
    {
        return maxArchitect;
    }

    public int getProgrammers()
    {
        return programmers;
    }

    public int getDesigners()
    {
        return designers;
    }

    public int getArchitects()
    {
        return architects;
    }

    public int getMembers()
    {
        return members;
    }
}
