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
    /** 表示开发团队最大成员数 */
    private final int MAX_MENBER = 5;
    /** team数组用来保存当前团队中的各成员对象 */
    private Programmer[] team = new Programmer[MAX_MENBER];

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
}
