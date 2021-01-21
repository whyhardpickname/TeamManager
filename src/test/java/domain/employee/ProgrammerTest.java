package domain.employee;

import domain.equipment.PC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.Data;
import service.Status;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class ProgrammerTest
{
    Programmer programmer = new Programmer(1, "mark",
            28, 10000.0,new PC("戴尔", "3800-R33"));

    @BeforeEach
    void setUp()
    {
        programmer.setMemberID(1);
        programmer.setStatus(Status.FREE);
    }

    @Test
    void testProgrammerConstructor()
    {
        assertEquals(1, programmer.getMemberID());
        assertEquals(Status.FREE, programmer.getStatus());
        assertEquals("PC{model=戴尔, display=3800-R33}", programmer.getEquipment().getDescription());
    }
}