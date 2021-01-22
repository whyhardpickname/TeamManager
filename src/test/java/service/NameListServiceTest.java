package service;

import domain.employee.Architect;
import domain.employee.Designer;
import domain.employee.Employee;
import domain.employee.Programmer;
import domain.equipment.NoteBook;
import domain.equipment.PC;
import domain.equipment.Printer;
import exception.NotFoundEmployeeException;
import exception.NotFoundEquipmentException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class NameListServiceTest
{
    NameListService nameListService;

    @BeforeEach
    void setUp() throws NotFoundEquipmentException, NotFoundEmployeeException
    {
        nameListService = new NameListService();
    }

    @AfterEach
    void tearDown()
    {
        nameListService = null;
    }

    @Test
    void testCreateEquipment() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException
    {
        PC pc = new PC("宏碁 ", "AT7-N52");
        NoteBook noteBook = new NoteBook("联想Y5", 6000);
        Printer printer = new Printer("激光", "佳能 2900");

        Method method = NameListService.class.getDeclaredMethod("createEquipment",
                int.class, String.class);
        method.setAccessible(true);
        //之所以不通过，是因为传入设备构造器的两个参数都是Data.EQUIPMENTS[row][1]
        //以及Data.EQUIPMENTS[row][1]第一行是空的。
        assertEquals(pc, method.invoke(nameListService, 2, "21"));
        assertEquals(noteBook, method.invoke(nameListService, 1, "22"));
        assertEquals(printer, method.invoke(nameListService, 4, "23"));
        assertThrows(NotFoundEquipmentException.class, () ->
                {
                    method.invoke(nameListService, 4, "24");
                });
    }

    @Test
    void testCreateEmployee() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException
    {
        //{"10", "1", "段誉", "22", "3000"}
        Employee employee = new Employee(1, "段誉", 22, 3000);
        //{"11", "3", "任我行", "23", "7000"}
        Programmer programmer = new Programmer(3, "任我行", 23, 7000,
                new PC("宏碁 ", "AT7-N52"));
        //{"12", "5", "周芷若", "28", "10000", "5000"}
        Designer designer = new Designer(5, "周芷若", 28, 10000,
                new NoteBook("联想Y5", 6000), 5000);
        //{"13", "8", "韦小宝", "30", "19800", "15000", "2500"}
        Architect architect = new Architect(8, "韦小宝", 30, 19800,
                new PC("宏碁 ", "AT7-N52"), 15000, 2500);

        Method method = NameListService.class.getDeclaredMethod("createEmployee",
                int.class, String.class);
        method.setAccessible(true);
        assertEquals(employee, method.invoke(nameListService, 0, "10"));
        assertEquals(programmer, method.invoke(nameListService, 2, "11"));
        assertEquals(designer, method.invoke(nameListService, 4, "12"));
        assertEquals(architect, method.invoke(nameListService, 7, "13"));
        assertEquals(new NotFoundEmployeeException(7),
                method.invoke(nameListService, 7, "14"));
    }
    @Test
    void getAllEmployees()
    {

    }

    @Test
    void getEmployee()
    {

    }
}