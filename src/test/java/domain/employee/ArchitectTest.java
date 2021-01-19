package domain.employee;

import domain.equipment.NoteBook;
import org.junit.jupiter.api.Test;
import service.Status;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class ArchitectTest
{
    Architect architect = new Architect(1, "mark", 28, 10000.0,
            1, Status.BUSY, new NoteBook("联想Y5", 6000.0), 100000.0,
            100000);

    @Test
    void testArchitect()
    {
        assertEquals(100000, architect.getStock());
    }
}