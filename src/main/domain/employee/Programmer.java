package domain.employee;

import domain.equipment.Equipment;
import service.Status;

/**
 * 程序员类{@code Programmer}是雇员的子类，除了雇员原有的属性，
 * 还包含成员ID(menberID),领用的设备{@link Equipment}和成员的状态{@link Status}。
 *
 * <p>程序员主要作为开发团队的一员。
 *
 * @author MarkChern
 */
public class Programmer extends Employee
{
    /**公司成员加入开发团队后的身份证明*/
    private int memberID;
    /**成员的状态，有空闲，已加入开发团队和正在休假三种状态*/
    private Status status;
    /**成员领用的设备*/
    private Equipment equipment;

    /**
     * 构造一个指定身份证明，姓名，年龄，薪水，成员ID，状态，领用设备的程序员对象。
     *
     * @param id
     *      雇员身份证明
     * @param name
     *      姓名
     * @param age
     *      年龄
     * @param salary
     *      薪水
     * @param equipment
     *      成员领用的设备
     */
    public Programmer(int id, String name, int age, double salary, Equipment equipment)
    {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberID()
    {
        return memberID;
    }

    public Status getStatus()
    {
        return status;
    }

    public Equipment getEquipment()
    {
        return equipment;
    }

    public void setMemberID(int memberID)
    {
        this.memberID = memberID;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }
}
