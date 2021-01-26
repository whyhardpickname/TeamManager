package service;

import domain.employee.Employee;
import domain.employee.Programmer;

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
    /** 开发团最大人数*/
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
    /** team数组用来保存当前团队中的各成员对象 */
    private Programmer[] team = new Programmer[maxMember];

    /**
     * {@code TeamService}构造开发团队的对象，并初始化开发团队成员。
     */
    public TeamService()
    {
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
    public void addMember(Employee employee)
    {

    }

    /**
     * {removeMember}方法从团队中删除成员
     * @param memberId
     *      删除对象的成员ID
     */
    public void removeMember(int memberId)
    {

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
        return team.length;
    }
}
