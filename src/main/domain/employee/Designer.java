package domain.employee;

import domain.equipment.Equipment;
import service.Status;

/**
 * 设计师类{@code Designer}是程序员类{@code Programmer}的子类，区在在于拥有奖金。
 *
 * <p>设计师主要作为开发团队中的一员。
 *
 * @author MarkChern
 *
 */
public class Designer extends Programmer
{
    /**奖金*/
    private double bonus;

    /**
     * 构造一个指定身份证明，姓名，年龄，薪水，成员ID，状态，领用设备和奖金的设计师对象。
     *
     * @param id
     *      雇员身份证明
     * @param name
     *      姓名
     * @param age
     *      年龄
     * @param salary
     *      薪水
     *      成员的状态
     * @param equipment
     *      成员领用的设备
     * @param bonus
     *      奖金
     */
    public Designer(int id, String name,
                    int age, double salary, Equipment equipment, double bonus)
    {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus()
    {
        return bonus;
    }
}
