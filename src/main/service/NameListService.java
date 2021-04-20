package service;

import domain.employee.Architect;
import domain.employee.Designer;
import domain.employee.Employee;
import domain.employee.Programmer;
import domain.equipment.Equipment;
import domain.equipment.NoteBook;
import domain.equipment.PC;
import domain.equipment.Printer;
import exception.NotFoundEmployeeException;
import exception.NotFoundEquipmentException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * {@code NameListService}类是用来保存公司全体员工的信息。
 *
 * <p>其构造器可以根据项目提供的{@code Data}类创建相应大小的雇员数组，
 * 以及不同类型的对象。
 *
 * @author MarkChern
 */
public class NameListService {
    /*所有公司员工对象*/
    Employee[] employees;

    /**
     * {@code NameListService}根据Data类的数据构建相应大小的{@code Employee}数组，
     * 再根据{@code Data}中的数据构建不同的对象。
     */
    public NameListService() throws  NotFoundEquipmentException, NotFoundEmployeeException {

        //根据Data.EMPLOYEES数组长度构造相应大小数组
        employees = new Employee[Data.EMPLOYEES.length];

        //根据Data.EMPLOYEES数据构造相应对象
        //1.根据Data.EMPLOYEES[i][3]构建对应设备
        //2.根据Data.EMPLOYEES[i][0]构建对应员工对象
        //3.调用各自构造器
        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            employees[i] = createEmployee(i);
        }
    }

    /**
     * {@code getAllEmployees}获得当前所有员工
     *
     * @return 包含所有员工的数组
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * {@code getEmployee}返回指定id的员工
     * @param id
     *      指定员工的id
     * @return  指定员工对象
     * @throws NotFoundEmployeeException
     *          如果找不到指定员工
     */
    public Employee getEmployee(int id) throws NotFoundEmployeeException {
        for(Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new NotFoundEmployeeException();

        /*
        Employee key = new Employee(id, null, 0, 0);
        int index = Arrays.binarySearch(employees, key, Employee::compareTo);
        if (index >= 0) {

            return employees[index];
        }
         */
    }

    /**
     * {@code createEmployee}根据Data.EMPLOYEES每行数据的第一个数据构建对应员工对象
     *
     * @param row
     *       Data.EMPLOYEES第row行下标
     * @return  code对应的员工类型
     *
     * @throws NotFoundEquipmentException
     *      是在无法找到对应设备时抛出的异常。
     * @throws NotFoundEmployeeException
     *      是当找不到指定员工时抛出的异常。
     */
    private Employee createEmployee(int row) throws NotFoundEquipmentException,
            NotFoundEmployeeException {
        int id = Integer.parseInt(Data.EMPLOYEES[row][1]);
        String name = Data.EMPLOYEES[row][2];
        int age = Integer.parseInt(Data.EMPLOYEES[row][3]);
        double salary = Double.parseDouble(Data.EMPLOYEES[row][4]);
        String code = Data.EMPLOYEES[row][0]; //员工编码

        switch (code)
        {
            case "10":
                return new Employee(id, name, age,salary);

            case "11":
                return new Programmer(id, name, age, salary,
                        createEquipment(row));

            case "12":
                double bonus = Integer.parseInt(Data.EMPLOYEES[row][5]);
                return new Designer(id, name, age, salary,
                        createEquipment(row), bonus);

            case "13":
                bonus = Double.parseDouble(Data.EMPLOYEES[row][5]);
                int stock = Integer.parseInt(Data.EMPLOYEES[row][6]);
                return new Architect(id, name, age, salary,
                        createEquipment(row), bonus, stock);

            default:
                throw new NotFoundEmployeeException();
        }
        /*
        if (code.equals("10"))
        {
            return new Employee(id, name, age,salary);
        }
        else if (code.equals("11"))
        {
            return new Programmer(id, name, age, salary,
                    createEquipment(row));
        }
        else if (code.equals("12"))
        {
            double bonus = Integer.parseInt(Data.EMPLOYEES[row][5]);
            return new Designer(id, name, age, salary,
                    createEquipment(row), bonus);
        }
        else if (code.equals("13"))
        {
            double bonus = Double.parseDouble(Data.EMPLOYEES[row][5]);
            int stock = Integer.parseInt(Data.EMPLOYEES[row][6]);
            return new Architect(id, name, age, salary,
                    createEquipment(row), bonus, stock);
        }

        throw new NotFoundEmployeeException();
         */
    }

    /**
     * {@code createEquipment}根据Data.EMPLOYEES每行第三项确定员工领用设备,
     * 再根据EQUIPMENTS构建对应设备
     * @param row
     *      员工id
     * @throws NotFoundEquipmentException
     *      当设备编码不存在时，抛出该异常。
     */
    private Equipment createEquipment(int row) throws NotFoundEquipmentException
    {
        //员工的设备对应设备集的行数，之前传入的code是雇员的code
        //由于存在没有设备的员工,提前设置为null
        String code = null; //设备编码
        if (Data.EQUIPMENTS[row].length != 0)
        {
            code = Data.EQUIPMENTS[row][0];
        }

        //Data.EQUIPMENTS[id][1]对应第一个参数，Data.EQUIPMENTS[id][2]对应第二个参数
        if (Objects.equals(code, "21"))
        {
            String model = Data.EQUIPMENTS[row][1];
            String display = Data.EQUIPMENTS[row][2];
            return new PC(model, display);
        }
        else if (Objects.equals(code,"22"))
        {
            String model = Data.EQUIPMENTS[row][1];
            double price = Double.parseDouble(Data.EQUIPMENTS[row][2]);
            return new NoteBook(model, price);
        }
        else if (Objects.equals(code, "23"))
        {
            String type = Data.EQUIPMENTS[row][1];
            String name = Data.EQUIPMENTS[row][2];
            return new Printer(type, name);
        }
        else if (Objects.equals(code,null))
        {
            return null;
        }
        throw new NotFoundEquipmentException();
    }
}
