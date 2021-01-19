package domain.employee;

import domain.equipment.Equipment;
import service.Status;

/**
 * 架构师类{@code Architect}是设计师类{@code Designer}的子类，区别是拥有股票。
 *
 * <p>架构师主要作为开发团队的一员。
 *
 * @author MarkChern
 */
public class Architect extends Designer
{
    /**股票*/
    private int stock;

    /**
     * 构造一个指定身份证明，姓名，年龄，薪水，成员ID，状态，领用设备，奖金和股票的架构师对象。
     *
     * @param id
     *      雇员身份证明
     * @param name
     *      姓名
     * @param age
     *      年龄
     * @param salary
     *      薪水
     * @param memberID
     *      公司成员加入开发团队后的身份证明
     * @param status
     *      成员的状态
     * @param equipment
     *      成员领用的设备
     * @param bonus
     *      奖金
     * @param stock
     *      股票
     */
    public Architect(int id, String name, int age, double salary, int memberID, Status status, Equipment equipment, double bonus, int stock)
    {
        super(id, name, age, salary, memberID, status, equipment, bonus);
        this.stock = stock;
    }

    public int getStock()
    {
        return stock;
    }
}
