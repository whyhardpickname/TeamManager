package service;

import domain.employee.Employee;
import domain.equipment.Equipment;
import domain.equipment.PC;
import exception.TeamException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

/**
 * {@code NameListService}类是用来保存公司全体员工的信息。
 *
 * <p>其构造器可以根据项目提供的{@code Data}类创建相应大小的雇员数组，
 * 以及不同类型的对象。
 *
 * @author MarkChern
 */
public class NameListService
{
    //TODO
    // -NameListService()构造器
    // -getAllEmployees ()方法
    // -getEmployee(id : int)方法
    // -测试

    /*所有公司员工对象*/
    Employee[] employees;


    /**
     * {@code NameListService}根据Data类的数据构建相应大小的{@code Employee}数组，
     * 再根据{@code Data}中的数据构建不同的对象。
     */
    public NameListService()
    {
    }

    /**
     * {@code getAllEmployees}获得当前所有员工
     *
     * @return 包含所有员工的数组
     */
    public Employee[] getAllEmployees()
    {
        //根据Data.EMPLOYEES数据构造相应大小数组
        employees = new Employee[Data.EMPLOYEES.length];

        //根据Data.EMPLOYEES数据构造相应对象
        //1.根据Data.EMPLOYEES[i][3]构建对应设备
        //2.根据Data.EMPLOYEES[i][0]构建对应员工对象
        //3.调用各自构造器
        for (int i = 0; i < Data.EMPLOYEES.length; i++)
        {

        }
        return null;
    }

    /**
     * {@code getEmployee}返回指定id的员工
     * @param id
     *      指定员工的id
     * @return  指定员工对象
     * @throws TeamException
     *          如果找不到指定员工
     */
    public Employee getEmployee(int id) throws TeamException
    {
        return null;
    }

    /**
     * {@code createEmployee}根据Data.EMPLOYEES每行数据的第一个数据构建对应员工对象
     * @param code
     *      员工类型编码
     * @return  code对应的员工类型
     */
    private Employee createEmployee(String code) throws Exception
    {
        Constructor constructor;
        if (code == "10")
        {
            constructor = PC.class.getConstructor(String.class, String.class);
        }
        else if (code == "11")
        {

        }
        else if (code == "12")
        {

        }
        else if (code == "13")
        {

        }
        else
        {

        }
        return null;
    }

    /**
     * {@code createEquipment}根据Data.EMPLOYEES每行第三项确定员工领用设备,
     * 再根据EQUIPMENTS构建对应设备
     * @param id
     *      员工id
     * @param code
     *      员工领用设备编码
     */
    private Equipment createEquipment(int id, String code)
    {

        if (code == "21")
        {

        }
        else if (code == "22")
        {

        }
        else if (code == "23")
        {

        }
        else
        {

        }
        return null;
    }
}
