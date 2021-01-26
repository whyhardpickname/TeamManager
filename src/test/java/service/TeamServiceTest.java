package service;

import domain.employee.Architect;
import domain.employee.Designer;
import domain.employee.Employee;
import domain.employee.Programmer;
import domain.equipment.NoteBook;
import domain.equipment.PC;
import exception.*;
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
        nameList = new NameListService();
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void addMember() throws NotFoundEmployeeException
    {
        team = new TeamService();
//        测试程序员人数超出异常
//        程序员{"11", "3", "任我行", "23", "7000"},
//        程序员{"11", "4", "张三丰", "24", "7300"},
//        程序员{"11", "6", "赵敏", "22", "6800"},
//        程序员{"11", "10", "小龙女", "21", "6600"},
        team.addMember(nameList.getEmployee(3));
        team.addMember(nameList.getEmployee(4));
        team.addMember(nameList.getEmployee(6));
        assertThrows(ProgrammerOutOfNumberException.class, () ->
                team.addMember(nameList.getEmployee(10)));

//        测试设计师人数超出异常
//        设计师{"12", "5", "周芷若", "28", "10000", "5000"},
//        设计师{"12", "7", "张无忌", "29", "10800","5200"},
//        设计师{"12", "12", "黄蓉", "27", "9600", "4800"}
        team.addMember(nameList.getEmployee(5));
        team.addMember(nameList.getEmployee(7));
        assertThrows(ArchitectOutOfNumberException.class, () ->
                team.addMember(nameList.getEmployee(10)));
//        测试团队人数
        assertEquals(5, team.getMembers());

//        架构师{"13", "2", "令狐冲", "32", "18000", "15000", "2000"},
//        架构师{"13", "8", "韦小宝", "30", "19800", "15000", "2500"},
//        测试团队人数超出异常
        assertThrows(OutOfNumberException.class, () ->
                team.addMember(nameList.getEmployee(2)));
//        测试架构师人数超出异常
        team = new TeamService();
        team.addMember(nameList.getEmployee(2));
        assertThrows(OutOfNumberException.class, () ->
                team.addMember(nameList.getEmployee(8)));
    }

    @Test
    void removeMember() throws NotFoundEmployeeException
    {
        team = new TeamService();
//        程序员{"11", "3", "任我行", "23", "7000"},
//        设计师{"12", "5", "周芷若", "28", "10000", "5000"}
//        架构师{"13", "2", "令狐冲", "32", "18000", "15000", "2000"},
        team.addMember(nameList.getEmployee(3));
        team.addMember(nameList.getEmployee(5));
        team.addMember(nameList.getEmployee(2));
//        测试删除不存在成员
        assertThrows(NotFoundEmployeeException.class, () ->
                team.addMember(nameList.getEmployee(4)));
        team.removeMember(3);
        team.removeMember(5);
        team.removeMember(2);
//        测试重复删除
        assertThrows(NotFoundEmployeeException.class, () ->
                team.addMember(nameList.getEmployee(3)));
    }

    @Test
    void getTeam() throws NotFoundEmployeeException
    {
        team = new TeamService();
//        程序员{"11", "3", "任我行", "23", "7000"},
//        设计师{"12", "5", "周芷若", "28", "10000", "5000"}
//        架构师{"13", "2", "令狐冲", "32", "18000", "15000", "2000"},
        Programmer[] programmers = new Programmer[3];
        programmers[0] = (Programmer) nameList.getEmployee(3);
        programmers[0] = (Designer) nameList.getEmployee(5);
        programmers[0] = (Architect) nameList.getEmployee(2);

        team.addMember(nameList.getEmployee(3));
        team.addMember(nameList.getEmployee(5));
        team.addMember(nameList.getEmployee(2));

        assertArrayEquals(programmers, team.getTeam());
    }
}