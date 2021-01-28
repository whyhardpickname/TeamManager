package view;

import exception.NotFoundEmployeeException;
import exception.NotFoundEquipmentException;
import service.NameListService;
import service.TeamService;

/**
 * {@code TeamVies}负责菜单的显示和用户的操作
 * @author MarkChern
 */
public class TeamView
{
    /** 公司员工列表 */
    NameListService listSvc;

    /** 开发团队列表 */
    TeamService teamSvc;

    /**
     * {@code TeamView}初始化公司员工列表和开发团队列表。
     * @throws NotFoundEmployeeException
     * @throws NotFoundEquipmentException
     */
    public TeamView() throws NotFoundEmployeeException, NotFoundEquipmentException
    {
        listSvc = new NameListService();
        teamSvc = new TeamService();
    }

    /**
     * {@code enterMainMenu}方法显示主界面及控制方法。
     */
    public void enterMainMenu()
    {

    }

    /**
     * {@code listAllEmployees}方法以表格形式列出公司所有成员。
     */
    private void listAllEmployees()
    {

    }

    /**
     * {@code addMember}方法实现添加团队成员操作。
     */
    private void addMember()
    {

    }

    /**
     * {@code deleteMember}方法实现删除团队成员操作
     */
    private void deleteMember()
    {

    }
}
