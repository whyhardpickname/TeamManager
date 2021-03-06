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
    Employee employee;
    Programmer programmer;
    Designer designer;
    Architect architect;


    @BeforeEach
    void setUp() throws NotFoundEquipmentException, NotFoundEmployeeException
    {
        nameListService = new NameListService();
        //{"10", "1", "段誉", "22", "3000"}
        employee = new Employee(1, "段誉", 22, 3000);
        //{"11", "3", "任我行", "23", "7000"}
        programmer = new Programmer(3, "任我行", 23, 7000,
                new PC("宏碁 ", "AT7-N52"));
        //{"12", "5", "周芷若", "28", "10000", "5000"}
        designer = new Designer(5, "周芷若", 28, 10000,
                new NoteBook("联想Y5", 6000), 5000);
        //{"13", "8", "韦小宝", "30", "19800", "15000", "2500"}
        architect = new Architect(8, "韦小宝", 30, 19800,
                new PC("宏碁 ", "AT7-N52"), 15000, 2500);
    }

    @AfterEach
    void tearDown()
    {
        nameListService = null;
    }

    @Test
    void testCreateEquipment() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        PC pc = new PC("宏碁 ", "AT7-N52");
        NoteBook noteBook = new NoteBook("联想Y5", 6000);
        Printer printer = new Printer("激光", "佳能 2900");

        Method method = NameListService.class.getDeclaredMethod("createEquipment",
                int.class);
        method.setAccessible(true);
        //之所以不通过，是因为传入设备构造器的两个参数都是Data.EQUIPMENTS[row][1]
        //以及Data.EQUIPMENTS[row][1]第一行是空的。
        assertEquals(pc, method.invoke(nameListService, 2));
        assertEquals(noteBook, method.invoke(nameListService, 1));
        assertEquals(printer, method.invoke(nameListService, 4));
        assertNull(method.invoke(nameListService, 0));
    }

    @Test
    void testCreateEmployee() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method method = NameListService.class.getDeclaredMethod("createEmployee",
                int.class);
        method.setAccessible(true);
        assertEquals(employee, method.invoke(nameListService, 0));
        assertEquals(programmer, method.invoke(nameListService, 2));
        assertEquals(designer, method.invoke(nameListService, 4));
        assertEquals(architect, method.invoke(nameListService, 7));
    }
    @Test
    void getAllEmployees() {
        assertEquals(12, nameListService.getAllEmployees().length);
    }

    @Test
    void getEmployee() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method method = NameListService.class.getDeclaredMethod("getEmployee", int.class);
        method.setAccessible(true);
        assertEquals(employee, method.invoke(nameListService, 1));
        assertEquals(programmer, method.invoke(nameListService, 3));
        assertEquals(designer, method.invoke(nameListService, 5));
        assertEquals(architect, method.invoke(nameListService, 8));
    }
}