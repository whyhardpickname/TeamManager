package domain.employee;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
public class EmployeeTest
{
    Employee employee;

    @BeforeEach
    public void setUp()
    {
        this.employee = new Employee(1, "mark", 28, 10000.0);
    }

    @AfterEach
    public void tearDown()
    {
        this.employee = null;
    }

    @Test
    public void testEmployeeConstructor()
    {
        assertEquals(1, employee.getId());
        assertEquals("mark", employee.getName());
        assertEquals(28, employee.getAge());
        assertEquals(10000.0, employee.getSalary());
    }

    @Test
    public void testGetID()
    {
        assertEquals(1, employee.getId());
    }

    @Test
    public void testGetName()
    {
        assertEquals("mark", employee.getName());
    }

    @Test
    public void testGetAge()
    {
        assertEquals(28, employee.getAge());
    }

    @Test
    public void testGetSalary()
    {
        assertEquals(10000.0, employee.getSalary());
    }
}