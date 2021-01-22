package domain.equipment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class PCTest
{
    PC pc;
    @BeforeEach
    void setUp()
    {
        pc = new PC("戴尔","3800-R33");
    }

    @AfterEach
    void tearDown()
    {
        pc = null;
    }

    @Test
    void testPCConstructor()
    {
        assertEquals("戴尔", pc.getModel());
        assertEquals("3800-R33", pc.getDisplay());
    }

    @Test
    void getDescription()
    {
        assertEquals("PC{model=戴尔, display=3800-R33}", pc.getDescription());
    }

    @Test
    void testEquals()
    {
        PC pc1 = new PC("戴尔","3800-R33");
        PC pc2 = new PC("戴尔","3800-R34");
        assertEquals(pc, pc1);
        assertNotEquals(pc, pc2);
    }
}