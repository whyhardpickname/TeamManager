package service;

import domain.employee.Architect;
import domain.employee.Designer;
import domain.employee.Employee;
import domain.employee.Programmer;
import domain.equipment.NoteBook;
import domain.equipment.PC;
import exception.NotFoundEmployeeException;
import exception.NotFoundEquipmentException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class TeamServiceTest
{
    NameListService nameList;
    TeamService team;

    @BeforeEach
    void setUp() throws NotFoundEmployeeException, NotFoundEquipmentException
    {
        nameList  = new NameListService();
        team = new TeamService();
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void addMember()
    {
    }

    @Test
    void removeMember()
    {
    }

    @Test
    void getTeam() throws NotFoundEmployeeException
    {
        //添加团队成员
        //架构师{"13", "2", "令狐冲", "32", "18000", "15000", "2000"},
        team.addMember(nameList.getEmployee(2));
        //设计师{"12", "5", "周芷若", "28", "10000", "5000"},
        team.addMember(nameList.getEmployee(5));
        //程序员{"11", "3", "任我行", "23", "7000"},
        //程序员{"11", "4", "张三丰", "24", "7300"},
        //程序员{"11", "6", "赵敏", "22", "6800"},
        team.addMember(nameList.getEmployee(3));
        team.addMember(nameList.getEmployee(4));
        team.addMember(nameList.getEmployee(6));

        assertEquals(nameList.getEmployee(2), team.getTeam()[0]);
        assertEquals(nameList.getEmployee(5), team.getTeam()[1]);
        assertEquals(nameList.getEmployee(3), team.getTeam()[2]);
        assertEquals(nameList.getEmployee(4), team.getTeam()[2]);
        assertEquals(nameList.getEmployee(6), team.getTeam()[2]);
        assertEquals(5, team.getTeam().length);
    }
}