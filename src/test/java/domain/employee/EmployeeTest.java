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
    void setUp()
    {
        this.employee = new Employee(1, "mark", 28, 10000.0);
    }

    @AfterEach
    void tearDown()
    {
        this.employee = null;
    }

    @Test
    void testEmployeeConstructor()
    {
        assertEquals(1, employee.getId());
        assertEquals("mark", employee.getName());
        assertEquals(28, employee.getAge());
        assertEquals(10000.0, employee.getSalary());
    }

    @Test
    void testEqual()
    {
        assertEquals(new Employee(1, "mark", 28, 10000.0), employee);
    }
}