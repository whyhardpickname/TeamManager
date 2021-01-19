package domain.employee;

import domain.equipment.NoteBook;
import org.junit.jupiter.api.Test;
import service.Status;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class DesignerTest
{
    Designer designer = new Designer(1, "mark", 28, 10000.0,
            1, Status.BUSY, new NoteBook("联想Y5", 6000.0), 100000.0);

    @Test
    void testDesignerConstructor()
    {
        assertEquals(100000.0, designer.getBonus());
    }
}