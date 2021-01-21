package service;

import domain.equipment.NoteBook;
import domain.equipment.PC;
import domain.equipment.Printer;
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
    void setUp() throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException
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
        assertEquals(pc, method.invoke(nameListService, 1, "21"));
        assertEquals(noteBook, method.invoke(nameListService, 0, "22"));
        assertEquals(printer, method.invoke(nameListService, 3, "23"));
        assertEquals(null, method.invoke(nameListService, 3, "24"));
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